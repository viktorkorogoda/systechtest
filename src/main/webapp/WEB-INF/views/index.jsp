<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Web Photo Helper</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/tooltipster.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="scripts/jquery-2.1.3.js"></script>
<script type="text/javascript" src="scripts/jquery.tooltipster.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="scripts/scripts.js" type="text/javascript"></script>
<script src="//use.edgefonts.net/nobile:n4,i4,n5,i5,n7,i7:all;open-sans-condensed:n3,i3,n7:all;poiret-one:n4:all;lobster:n4:all;jura:n3,n4,n5,n6:all.js"></script> 

 <script>
        $(document).ready(function() {
            $('.tooltip').tooltipster();
        });
    </script>
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
				<form action="addTask" id="addTaskForm" modelAttribute = "tasks" class="form-horizontal" role="form" method="post">
					
					<div class="form-group">
						<label for="startDate" class="control-label col-sm-2"> Start Date</label>
						<div class="col-sm-10">
							<input style="width:50%" type="text" name="startDate" class="form-control startDate" id="datepickerStart" title="Enter date in following formats 25.12.2015" >
							</div>
					</div>
					
					<div class="form-group">
						<label for="endDate" class="control-label col-sm-2"> endDate</label>
						<div class="col-sm-10">
							<input style="width:50%" type="text"  name="endDate" class="form-control endDate" id="datepickerEnd" title="Enter date in following formats 25.12.2015">
						</div>
					</div>
					
					<div class="form-group">
						<label for="summary" class="control-label col-sm-2"> Summary</label>
						<div class="col-sm-10">
							<input type="text" id="summary" name="summary"  class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<label for="assigneeInput" class="control-label col-sm-2"> Assignee</label>
						<div class="col-sm-10">
							<input type="text" id="assignee" name="assignee" class="form-control">
						</div>
					</div>	
					
					 <div class="form-group"> 
   						 <div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-default" value="Add new task"> 
						  </div>
 					</div>
				</form>
				<h3 style = "text-align: center;"> ${wrongDate}</h3>

			</div>
				
		</div>
	</div>
</body>
</html>