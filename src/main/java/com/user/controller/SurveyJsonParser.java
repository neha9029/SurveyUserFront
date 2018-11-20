package com.user.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.dao.UserDao;
import com.user.entities.UserEntity;
import com.user.modelRequest.MultipleOptions;
import com.user.modelRequest.SurveyOptionsParse;
import com.user.modelRequest.SurveyQuestions;
import com.user.modelRequest.Surveys;
import com.user.service.UserService;

@Controller
public class SurveyJsonParser {
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;

	String REST_SERVICE_URI = "http://localhost:8081/adminPortal";

	String userIdFinal; 
	List<SurveyQuestions> surveyQuestionsList = new ArrayList<>();
	
	@GetMapping("/survey")
	public String getUserData(@RequestParam("userId") String userId, Model model) {
		userIdFinal = userId;
		Surveys surveyDetails = new Surveys();
		UserEntity userResponse = userService.findUserByUserId(userId);
		model.addAttribute("userDetails", userResponse);
		model.addAttribute("surveyDetails", surveyDetails);
		try {
			RestTemplate restTemplate = new RestTemplate();
			List<LinkedHashMap<String, Object>> surveyMap = restTemplate
					.getForObject(REST_SERVICE_URI + "/surveys/questions", List.class);

			if (surveyMap != null) {
				
				long i = 1;
				for (LinkedHashMap<String, Object> map : surveyMap) {
//					System.out.println("Survey : id=" + map.get("id") + ", SurveyName=" + map.get("surveyName")
//							+ ", surveyDescription=" + map.get("surveyDescription") + ", AccountType="
//							+ map.get("accountType"));
					if (map.get("accountType").equals(userResponse.getAccountType())) {

						List<LinkedHashMap<String, Object>> surveyQEnt = (List<LinkedHashMap<String, Object>>) map
								.get("surveyQuestionsEntity");
						// map.get("surveyQuestion");
						for (LinkedHashMap<String, Object> surveyQEntObj : surveyQEnt) {

							String quesTitle = (String) surveyQEntObj.get("questionTitle");
							long quesId = (Long) surveyQEntObj.get("questionId");

							List<LinkedHashMap<String, Object>> surveyAnswerEnt = (List<LinkedHashMap<String, Object>>) surveyQEntObj
									.get("surveyOptionsEntity");

							List<MultipleOptions> multipleOptions = new ArrayList<>();
							for (LinkedHashMap<String, Object> surveyAnswerEntObj : surveyAnswerEnt) {

								String optionsTitle = (String) surveyAnswerEntObj.get("optionTitle");

								ObjectMapper objectMapper = new ObjectMapper();

								List<SurveyOptionsParse> listOptions = objectMapper.readValue(optionsTitle,
										new TypeReference<List<SurveyOptionsParse>>() {
										});

								int j = 0;
								for (SurveyOptionsParse obj : listOptions) {
									MultipleOptions multiOp = new MultipleOptions();
									multiOp.setOptionTitle(obj.getQuestion());
									multiOp.setAsnwer(obj.getAnswer());
									multiOp.setOptionsDi(j);
									multiOp.setQuestionsDi(quesId);
									multipleOptions.add(multiOp);
									j++;
										
									
								}
								//model.addAttribute("options", multipleOptions);


							}
							SurveyQuestions surQues = new SurveyQuestions();
							surQues.setQuestionTitle(quesTitle);
							surQues.setMultipleOptions(multipleOptions);
							surQues.setQuestionId(System.currentTimeMillis());
							//System.out.println(surQues.getQuestionId());
							surveyQuestionsList.add(surQues);

							//System.out.println(surQues.toString());
							//model.addAttribute("surveyQuestionsD", new WrapperForQuestions(surveyQuestionsList));
							model.addAttribute("surveyQuestions", surveyQuestionsList);
						}

					}
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "survey";
	}
	
	
	@PostMapping(value="/surveyPost")
	public String postSurveyDetails(@ModelAttribute("userId") String userId, @ModelAttribute(value = "surveyQuestions") SurveyQuestions surveyQuestionsDetails, MultipleOptions multipleOptions) {

		int totalScore = 0;
		for(SurveyQuestions surQ : surveyQuestionsList) {
			
			int pos = 0;
			int rightAns = 0;
			for(MultipleOptions mulOp : surQ.getMultipleOptions()) {
				
				if(pos == rightAns && mulOp.isAsnwer()) {
					totalScore++;
				}
				pos++;
			}
		}
		
		totalScore = ThreadLocalRandom.current().nextInt(1, 99 + 1);

		System.out.println("score---"+totalScore);

		System.out.println("id"+this.userIdFinal);
		
		UserEntity userEntity = userService.findUserByUserId(userIdFinal);
		//System.out.println("id"+userEntity.getScore());

		userEntity.setScore(totalScore);
		userDao.save(userEntity);
		return "redirect:/login";
	}
}
