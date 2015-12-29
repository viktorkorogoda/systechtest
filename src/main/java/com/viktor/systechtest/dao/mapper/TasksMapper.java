package com.viktor.systechtest.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.viktor.systechtest.entity.Tasks;


public class TasksMapper implements RowMapper<Tasks> {

	@Override
	public Tasks mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tasks task = new Tasks();
		task.setId(rs.getInt("id"));
		task.setAssignee(rs.getString("assignee"));
		task.setSummary(rs.getString("summary"));
		task.setStartDate(rs.getString("startdate"));
		task.setEndDate(rs.getString("enddate"));
		return task;
	}

}
