package com.viktor.systechtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viktor.systechtest.dao.TasksDao;
import com.viktor.systechtest.entity.Tasks;
import com.viktor.systechtest.service.TasksService;

@Service
public class TasksServiceImpl implements TasksService {

	@Autowired
	TasksDao tasksDao;

	public TasksDao getTaskaDao() {
		return this.tasksDao;
	}

	public TasksDao setTaskaDao() {
		return this.tasksDao;
	}

	@Override
	public boolean addNewUser(Tasks task) {
		int result = tasksDao.insertTask(task);
		return result > 0;
	}

	@Override
	public List<Tasks> getTasks(Tasks task) {

		return tasksDao.getTasks(task);
	}

	@Override
	public List<String> loadAssignees() {

		return tasksDao.getAssignees();
	}
}
