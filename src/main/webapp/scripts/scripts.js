Date.prototype.getWeekDay = function() {
	  var day = this.getDay();
	  if(day==0) return 7;
	  else return day;  
	}

	// Returns current week start date
Date.prototype.getWeekStartDate = function() {
	  var date = new Date(this.getTime());      
	  date.setDate(this.getDate()-(this.getWeekDay()-1));
	  return date;     
	}

	// Returns current week end date
Date.prototype.getWeekEndDate = function() {
	  var date = new Date(this.getTime());      
	  date.setDate(this.getDate()+(7-this.getWeekDay()));
	  return date;     
	}

//set date period according to selected value
$(document).ready(function(){
	$("#period").on("change", function setDates() {
		var datePeriod = $("#period").val();
		var dates = getDates(datePeriod);
		$(".startDate").val(dates[0]);
		$(".endDate").val(dates[1]);
	});
});

function getDates(datePeriod) {
	var dates = new Array(2);
	var date = new Date();
	switch(datePeriod) {
		case "LastQuarter": {
			var quarter = Math.floor((date.getMonth() + 3) / 3);
				switch(quarter) {
					case 1 : {
						dates[0] = "01.09." + (date.getFullYear-1);
						dates[1] = "31.12." + (date.getFullYear-1);
						break;
					}
					case 2 :{
						var startDate = "01.01." + date.getFullYear();
						var endDate = "31.03." + date.getFullYear();
						break;
					}
					case 3 :{
						dates[0] = "01.04." + date.getFullYear();
						dates[1] = "30.06." + date.getFullYear();
						break;
					}
					case 4 :{
						dates[0] = "01.07." + date.getFullYear();
						dates[1] = "30.09." + date.getFullYear();
						break;
					}
				}
				break;
		}
	
		case "LastMonth": {
			dates[0] = new Date(date.getFullYear(), date.getMonth() -1, 1).toLocaleDateString();
			dates[1] = new Date(date.getFullYear(), date.getMonth(), 0).toLocaleDateString();
			break;
		}
		case "LastWeek": {
			msInDay = 86400000;
			currentDate = new Date();
			var date = new Date( currentDate - 7*msInDay );
			dates[0] = date.getWeekStartDate().toLocaleDateString();
			dates[1] = date.getWeekEndDate().toLocaleDateString();
			break;
		}
	
		case "CurrentQuarterToDate": {
			var quarter = Math.floor((date.getMonth() + 3) / 3);
				switch(quarter) {
					case 1 : {
						dates[0] = "01.01." + (date.getFullYear-1);
						break;
					}
					case 2 :{
						var startDate = "01.04." + date.getFullYear();
						break;
					}
					case 3 :{
						dates[0] = "01.07." + date.getFullYear();
						break;
					}
					case 4 :{
						dates[0] = "01.10." + date.getFullYear();
						break;
					}
		}
			dates[1] = new Date(date.getFullYear(), date.getMonth(), date.getDate()).toLocaleDateString();			
			break;
		}
		
		case "CurrentMonthToDate": {
			dates[0] = new Date(date.getFullYear(), date.getMonth(), 1).toLocaleDateString();
			dates[1] = new Date(date.getFullYear(), date.getMonth(), date.getDate()).toLocaleDateString();	
			break;
		}
	
		case "CurrentWeekToDate": {
			dates[0] = date.getWeekStartDate().toLocaleDateString();
			dates[1] = new Date(date.getFullYear(), date.getMonth(), date.getDate()).toLocaleDateString();
			break;
		}
	}
	return dates;
}	

$(function() {
    $("#datepickerStart").datepicker({ dateFormat: 'dd.mm.yy' });
    $("#datepickerStart").on("change",function(){
        var selected = $(this).val();
       
    });
});
$(function() {
    $("#datepickerEnd").datepicker({ dateFormat: 'dd.mm.yy' });
    $("#datepickeEnd").on("change",function(){
        var selected = $(this).val();
       
    });
});