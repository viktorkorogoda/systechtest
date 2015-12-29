package com.viktor.systechtest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.viktor.systechtest.dao.TasksDao;
import com.viktor.systechtest.dao.mapper.TasksMapper;
import com.viktor.systechtest.entity.Tasks;

@Repository
public class TasksDaoImpl implements TasksDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int insertTask(Tasks task) {
		String SQL = "INSERT INTO TASKS (id, summary, startdate, enddate, assignee) VALUES(TASKS_SEQ.nextval, :summary, to_date(:startdate,'dd.mm.yyyy'), to_date(:enddate,'dd.mm.yyyy'), :assignee)";
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("summary", task.getSummary());
		namedParameters.addValue("startdate", task.getStartDate());
		namedParameters.addValue("enddate", task.getEndDate());
		namedParameters.addValue("assignee", task.getAssignee());
		return namedParameterJdbcTemplate.update(SQL, namedParameters);
	}

	@Override
	public List<Tasks> getTasks(Tasks task) {
		String startDate = task.getStartDate();
		String endDate = task.getEndDate();
		String assignee = task.getAssignee();

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String SQL = "";
		if ((startDate == "") && (endDate == "") && (assignee.equalsIgnoreCase("All assignees"))) {
			SQL = "Select id, assignee, summary, startdate, enddate from TASKS";
		}

		if ((startDate == "") && (endDate == "") && (assignee.equalsIgnoreCase("All Assignees") == false)) {
			SQL = "Select id, assignee, summary, startdate, enddate from TASKS where (assignee like :assignee)";
			namedParameters.addValue("assignee", assignee);
		}

		if ((startDate == "") && (endDate != "") && (assignee.equalsIgnoreCase("All assignees"))) {
			SQL = "Select id, assignee, summary, startdate, enddate from TASKS where (enddate <= to_date(:enddate, 'dd.mm.yyyy'))";
			namedParameters.addValue("enddate", endDate);
		}

		if ((startDate == "") && (endDate != "") && (assignee.equalsIgnoreCase("All assignees") == false)) {
			SQL = "Select id, assignee, summary, startdate, enddate from TASKS where (enddate <= to_date(:enddate, 'dd.mm.yyyy')) and (assignee like :assignee)";
			namedParameters.addValue("enddate", endDate);
			namedParameters.addValue("assignee", assignee);
		}

		if ((startDate != "") && (endDate == "") && (assignee.equalsIgnoreCase("All assignees"))) {
			SQL = "Select id, assignee, summary, startdate, enddate from TASKS where (startdate >= to_date(:startDate, 'dd.mm.yyyy'))";
			namedParameters.addValue("startDate", startDate);
		}
		if ((startDate != "") && (endDate == "") && (assignee.equalsIgnoreCase("All assignees") == false)) {
			SQL = "Select id, assignee, summary, startdate, enddate from TASKS where (startdate >= to_date(:startDate, 'dd.mm.yyyy')) and (assignee like :assignee)";
			namedParameters.addValue("startDate", startDate);
			namedParameters.addValue("assignee", assignee);
		}
		if ((startDate != "") && (endDate != "") && (assignee.equalsIgnoreCase("All assignees"))) {
			SQL = "Select id, assignee, summary, startdate, enddate from TASKS where (startdate >= to_date(:startDate, 'dd.mm.yyyy')) and (endDate <= to_date(:endDate, 'dd.mm.yyyy'))";
			namedParameters.addValue("startDate", startDate);
			namedParameters.addValue("endDate", endDate);
		}
		if ((startDate != "") && (endDate != "") && (assignee.equalsIgnoreCase("All assignees") == false)) {
			SQL = "Select id, assignee, summary, startdate, enddate from TASKS where (startdate >= to_date(:startDate, 'dd.mm.yyyy')) and (endDate <= to_date(:endDate, 'dd.mm.yyyy')) and (assignee like :assignee)";
			namedParameters.addValue("startDate", startDate);
			namedParameters.addValue("endDate", endDate);
			namedParameters.addValue("assignee", assignee);
		}

		List<Tasks> tasksList = namedParameterJdbcTemplate.query(SQL, namedParameters, new TasksMapper());
		return tasksList;
	}

	@Override
	public List<String> getAssignees() {
		List<String> assigneesListAll = new ArrayList<String>();
		String SQL = "Select id, assignee, summary, startdate, enddate from tasks";
		List<Tasks> assigneesList = namedParameterJdbcTemplate.query(SQL, new TasksMapper());
		int assigneesListSize = assigneesList.size();
		for (int i = 0; i < assigneesListSize; i++) {
			assigneesListAll.add(assigneesList.get(i).getAssignee());
		}
		return assigneesListAll;
	}

}
