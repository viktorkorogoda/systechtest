package com.viktor.systechtest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.viktor.systechtest.entity.Tasks;
import com.viktor.systechtest.service.TasksService;
import com.viktor.systechtest.util.DateUtil;

@Controller
public class IndexController {

	@Autowired
	private TasksService taskService;

	@RequestMapping(value = { "/index" })
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public ModelAndView addNewUser(@ModelAttribute("tasks") Tasks task, BindingResult result) {
		ModelAndView model = new ModelAndView("search");
		boolean checkDate = true;

		if ((task.getStartDate() == "") || (task.getEndDate() == "") || (task.getSummary() == "") || (task.getAssignee() == "")) {
			model.addObject("wrongDate", "Fill the all filds");
			model.setViewName("index");
		} else {
			if (task.getStartDate() != "" && task.getEndDate() != "") {
				checkDate = DateUtil.dateCheck(task.getStartDate(), task.getEndDate());
			}
			if (checkDate == true) {
				taskService.addNewUser(task);
				model.setViewName("redirect:search");
			} else {
				model.addObject("wrongDate", "Enter a valid date");
				model.setViewName("index");
			}
		}
		return model;
	}
}
