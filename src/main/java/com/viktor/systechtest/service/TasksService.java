package com.viktor.systechtest.service;

import java.util.List;

import com.viktor.systechtest.entity.Tasks;


public interface TasksService {

	boolean addNewUser(Tasks task);
	List<Tasks> getTasks(Tasks task);
	List<String> loadAssignees();
}
