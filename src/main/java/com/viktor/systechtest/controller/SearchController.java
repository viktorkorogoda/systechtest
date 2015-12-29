package com.viktor.systechtest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.ListUtils;
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
public class SearchController {

	@Autowired
	TasksService tasksService;

	@RequestMapping(value = "/search")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		List<String> assignees = tasksService.loadAssignees();
		model.setViewName("search");
		model.addObject("assigneeList", assignees);
		return model;
	}

	@RequestMapping(value = "/searchTask", method = RequestMethod.GET)
	public ModelAndView getTasks(@ModelAttribute("tasks") Tasks task, BindingResult result) {
		ModelAndView model = new ModelAndView();
		model.setViewName("search");
		List<Tasks> tasksList = new ArrayList<Tasks>();
		List<String> assignees = new ArrayList<String>();
		boolean checkDate = true;

		if (task.getStartDate() != "" && task.getEndDate() != "") {
			checkDate = DateUtil.dateCheck(task.getStartDate(), task.getEndDate());
		}
		if (task.getStartDate() != "") {
			checkDate = DateUtil.dateCheck(task.getStartDate());
		}
		if (task.getEndDate() != "") {
			checkDate = DateUtil.dateCheck(task.getStartDate(), task.getEndDate());
		}
		if (checkDate == true) {
			tasksList = tasksService.getTasks(task);
			assignees = tasksService.loadAssignees();
			for (int i = 0; i < tasksList.size(); i++) {
				tasksList.get(i).setStartDate(DateUtil.dateConvert(tasksList.get(i).getStartDate().substring(0, 10)));
				tasksList.get(i).setEndDate(DateUtil.dateConvert(tasksList.get(i).getEndDate().substring(0, 10)));
			}

			if (tasksList.isEmpty()) {
				model.addObject("taskNotFound", "Tasks not found");
				model.addObject("assigneeList", assignees);
			}
			if (ListUtils.emptyIfNull(tasksList) != null) {
				model.addObject("tasksTable", new ArrayList<Tasks>(tasksList));
				model.addObject("assigneeList", assignees);
			}
		} else {
			model.addObject("wrongDate", "Enter a valid date");
			model.addObject("assigneeList", assignees);
		}
		return model;
	}
}
