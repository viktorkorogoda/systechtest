<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Web Photo Helper</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="scripts/jquery-2.1.3.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="//use.edgefonts.net/nobile:n4,i4,n5,i5,n7,i7:all;open-sans-condensed:n3,i3,n7:all;poiret-one:n4:all;lobster:n4:all;jura:n3,n4,n5,n6:all.js"></script> 
<script src="scripts/scripts.js" type="text/javascript"></script>



</head>
<body>

	<div class="mainArea">
		<div class="menu-container">
			<div class="menu" id="menu">
				<ul class="menu-tabs">
					<li id="main-page" class="menu-list"><a href="index">Add task</a></li>
					<li id="services" class="menu-list"><a href="search">Search task</a></li>			
				</ul>
			</div>
		
		</div>
		<div class="content-area">
			<div class="content-area-block">
				<form action="searchTask" id="searchTaskForm" modelAttribute = "tasksBean" class="form-horizontal" role="form" method="get">
				
					<div class="form-group">
						<label for="startDate" class="control-label col-sm-2"> Start Date</label>
						<div class="col-sm-10">
							<input type="text" name="startDate" class="form-control startDate" id="datepickerStart" style="width:50%" title="Enter date in following formats 25.12.2015" > 
						</div>
							
					</div>
					
					<div class="form-group">
						<label for="endDate" class="control-label col-sm-2"> endDate</label>
						<div class="col-sm-10">
							<input type="text"  name="endDate" class="form-control endDate" id="datepickerEnd" style="width:50%" title="Enter date in following formats 25.12.2015" >
						</div>
					</div>
					
					
					
					<div class="form-group">
						<label for="assigneeInput" class="control-label col-sm-2">Assignee</label>
						<div class="col-sm-10">
							<select size="" id="assignee" name="assignee" class="form-control">
							<option value="All Assignees">All assignees</option>
							<c:forEach items="${assigneeList}" var="option">
                    			<option value="${option}">${option}</option>
              				</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="period" class="control-label col-sm-2"> Period</label>
						<div class="col-sm-10">
							<select size="" id="period" name="period"  class="form-control" > 
								<option>Select period</option>
								<option value="LastQuarter"> Last Quarter </option>
								<option value="LastMonth"> Last Month </option>
								<option value="LastWeek"> Last Week </option>
								<option value="CurrentQuarterToDate"> Current Quarter to Date</option>
								<option value="CurrentMonthToDate"> Current Month to Date</option>
								<option value="CurrentWeekToDate"> Current Week to Date</option>
							</select>
						</div>
					</div>					
					
					 <div class="form-group"> 
   						 <div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-default" value="Find"> 
						  </div>
 					</div>
				</form>
				<div id = "tasksTableDiv">
				<h1>Task list</h1>
				<hr>
				<h3 style = "text-align: center;"> ${taskNotFound}</h3>
				<h3 style = "text-align: center;"> ${wrongDate}</h3>
				<c:if test="${not empty tasksTable}">
					<table class="user-table table table-bordered" id="tasks-table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Summary</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Assignee</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tasksTable}" var="task">
								<tr>
									<td>${task.id}</td>
									<td>${task.summary}</td>
									<td>${task.startDate}</td>
									<td>${task.endDate}</td>
									<td>${task.assignee}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				</div>

			</div>
				
		</div>
	</div>
</body>
</html>