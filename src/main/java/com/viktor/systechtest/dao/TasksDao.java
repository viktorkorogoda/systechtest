package com.viktor.systechtest.dao;

import java.util.List;

import com.viktor.systechtest.entity.Tasks;


public interface TasksDao {

	public int insertTask(Tasks task);
	public List<Tasks> getTasks(Tasks task);
	public List<String> getAssignees();

}
