
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
     if(r!=null)return  unescape(r[2]); return null;
}

$(function() {
	var projectId = GetQueryString("projectId");
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projecttaskinfo/findTaskInfoByProjectIdAndAllTeam.action?projectId="+projectId;
	$.ajax({
				type: "GET", //方法类型
				xhrFields: {
					withCredentials: true
				},
				dataType: "json", //预期服务器返回的数据类型
				async: true,
				//contentType: "application/json",
				url: routeUrl, //url
				success: function(result) {
					console.log(result); //打印服务端返回的数据(调试用)
					if(result.code == "0") {
						var taskList = result.data;
						var str = "";
						$(taskList).each(function(index,item){
							
							str+="<li>";
							str+="<div class=\"timeline-content\">";
							str+="<div class=\"left\">";
							str+="<div class=\"icon\">";
							str+="<i class=\"fa fa-picture-o\"></i>";
							str+="</div>";
							str+="<div class=\"date\">";
							var crtTime = new Date(item.creatorDateTime);
							var time1 = dateFtt("yyyy-MM-dd hh:mm:ss",crtTime);
							str+=time1;
							str+="</div>";
							str+="<div class=\"activity\">";
							str+="<div class=\"user\">";
							str+="<a href=\"#\">";
							str+=item.projectTaskScheduleCreatorName;
							str+="</a>";
							str+="<span>提交了工作汇报</span>";
							str+="</div>";
							str+="<div class=\"panel panel-default\">";
							str+="<div class=\"box-content\">";
							str+="<div class=\"panel-group panel-widget\" id=\"ac3\">";
							str+="<div class=\"panel panel-default\">";
							str+="<div class=\"panel-heading\">";
							str+="<h4 class=\"panel-title\">";
							str+="<a href=\"#\" data-toggle=\"collapse\" data-parent=\"#ac3\">";
							str+="DONE";
							str+="</a>";
							str+="</h4>";
							str+="</div>";
							str+="<div id=\"c1\" class=\"panel-collapse collapse in\">";
							str+="<div class=\"panel-body\">";
							str+=item.projectTaskScheduleDoneValue;
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="<div class=\"panel-group panel-widget\" id=\"ac3\">";
							str+="<div class=\"panel panel-default\">";
							str+="<div class=\"panel-heading\">";
							str+="<h4 class=\"panel-title\">";
							str+="<a href=\"#\" data-toggle=\"collapse\" data-parent=\"#ac3\">";
							str+="TODO";
							str+="</a>";
							str+="</h4>";
							str+="</div>";
							str+="<div id=\"c1\" class=\"panel-collapse collapse in\">";
							str+="<div class=\"panel-body\">";
							str+=item.projectTaskScheduleTodoValue;
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="<div class=\"panel-group panel-widget\" id=\"ac3\">";
							str+="<div class=\"panel panel-default\">";
							str+="<div class=\"panel-heading\">";
							str+="<h4 class=\"panel-title\">";
							str+="<a href=\"#\" data-toggle=\"collapse\" data-parent=\"#ac3\">";
							str+="PROBLEM";
							str+="</a>";
							str+="</h4>";
							str+="</div>";
							str+="<div id=\"c1\" class=\"panel-collapse collapse in\">";
							str+="<div class=\"panel-body\">";
							str+=item.projectTaskScheduleProblemValue;
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</li>"
						});
						$("#teamTaskList").html(str);
					}
				},
				error: function() {
					window.location.href = "error.html";
				}
			});
});

document.onkeydown=function(event){

var e = event || window.event || arguments.callee.caller.arguments[0];



	if(e && e.keyCode==13){ // enter 键
		 
		var projectId = GetQueryString("projectId");
		var selectDay = document.getElementById("selectDay").value;
		
		if(null != selectDay){
			var paramObj = {"projectId":projectId,"selectDay":selectDay};
			var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projecttaskinfo/findTaskInfoByProjectIdAndAllTeam.action";
			$.ajax({
				type: "POST", //方法类型
				xhrFields: {
					withCredentials: true
				},
				dataType: "json", //预期服务器返回的数据类型
				async: true,
				contentType: "application/json",
				data:JSON.stringify(paramObj),
				url: routeUrl, //url
				success: function(result) {
					console.log(result); //打印服务端返回的数据(调试用)
					if(result.code == "0") {
						var taskList = result.data;
						var str = "";
						$(taskList).each(function(index,item){
							
							str+="<li>";
							str+="<div class=\"timeline-content\">";
							str+="<div class=\"left\">";
							str+="<div class=\"icon\">";
							str+="<i class=\"fa fa-picture-o\"></i>";
							str+="</div>";
							str+="<div class=\"date\">";
							var crtTime = new Date(item.creatorDateTime);
							var time1 = dateFtt("yyyy-MM-dd hh:mm:ss",crtTime);
							str+=time1;
							str+="</div>";
							str+="<div class=\"activity\">";
							str+="<div class=\"user\">";
							str+="<a href=\"#\">";
							str+=item.projectTaskScheduleCreatorName;
							str+="</a>";
							str+="<span>提交了工作汇报</span>";
							str+="</div>";
							str+="<div class=\"panel panel-default\">";
							str+="<div class=\"box-content\">";
							str+="<div class=\"panel-group panel-widget\" id=\"ac3\">";
							str+="<div class=\"panel panel-default\">";
							str+="<div class=\"panel-heading\">";
							str+="<h4 class=\"panel-title\">";
							str+="<a href=\"#\" data-toggle=\"collapse\" data-parent=\"#ac3\">";
							str+="DONE";
							str+="</a>";
							str+="</h4>";
							str+="</div>";
							str+="<div id=\"c1\" class=\"panel-collapse collapse in\">";
							str+="<div class=\"panel-body\">";
							str+=item.projectTaskScheduleDoneValue;
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="<div class=\"panel-group panel-widget\" id=\"ac3\">";
							str+="<div class=\"panel panel-default\">";
							str+="<div class=\"panel-heading\">";
							str+="<h4 class=\"panel-title\">";
							str+="<a href=\"#\" data-toggle=\"collapse\" data-parent=\"#ac3\">";
							str+="TODO";
							str+="</a>";
							str+="</h4>";
							str+="</div>";
							str+="<div id=\"c1\" class=\"panel-collapse collapse in\">";
							str+="<div class=\"panel-body\">";
							str+=item.projectTaskScheduleTodoValue;
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="<div class=\"panel-group panel-widget\" id=\"ac3\">";
							str+="<div class=\"panel panel-default\">";
							str+="<div class=\"panel-heading\">";
							str+="<h4 class=\"panel-title\">";
							str+="<a href=\"#\" data-toggle=\"collapse\" data-parent=\"#ac3\">";
							str+="PROBLEM";
							str+="</a>";
							str+="</h4>";
							str+="</div>";
							str+="<div id=\"c1\" class=\"panel-collapse collapse in\">";
							str+="<div class=\"panel-body\">";
							str+=item.projectTaskScheduleProblemValue;
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							str+="</li>"
						});
						$("#teamTaskList").html(str);
					}
				},
				error: function() {
					window.location.href= "error.html";
				}
			});
		}
	
	}

};

function jumpProjectIntroduce() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "projectintroduction.html?projectId="+projectId;
}

function jumpProjectUser() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "projectuser.html?projectId="+projectId;
}

function jumpAllStory() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "allstorytest.html?projectId="+projectId;
}

function jumpCreateStory() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "createstory.html?projectId="+projectId;
}

function jumpTaskInfo() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "taskinfo.html?projectId="+projectId;
}

function jumpStoryAllMine() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "storyofmine.html?projectId="+projectId;
}


function dateFtt(fmt,date)   
{ //author: meizz   
  var o = {   
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}  


function jumpQuestionAllProject() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "projectquestion.html?projectId="+projectId;
}

function jumpQuestionAdd() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "addquestion.html?projectId="+projectId;
}

$(function() {
	var projectId = GetQueryString("projectId");
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projectMenuInfo/findProjectMenuByLoginUser.action?projectId="+projectId;
	$.ajax({
				type: "GET", //方法类型
				xhrFields: {
					withCredentials: true
				},
				dataType: "json", //预期服务器返回的数据类型
				async: true,
				//contentType: "application/json",
				url: routeUrl, //url
				success: function(result) {
					console.log(result); //打印服务端返回的数据(调试用)
					if(result.code == "0") {
						var menuList = result.data;
						var str = "";
						if(menuList.length > 0){
							str+="<div class=\"subnav-title\">";
							str+="<a href=\"#\" class=\'toggle-subnav\'>";
							str+="<i class=\"fa fa-angle-down\"></i>";
							str+="<span>管理员菜单项</span>";
							str+="</a>";
							str+="</div>";
							str+="<ul class=\"subnav-menu\">";
							$(menuList).each(function(index,item){
								str+="<li>"
								str+="<a href=\"";
								str+=item.menuUrl;
								str+="?projectId=";
								str+=projectId;
								str+="\">";
								str+=item.menuName;
								str+="</a>";
								str+="</li>";
							});
							str+="</ul>";
						}
						$("#adminMenu").html(str);
					}else{
						if(result.code == "-1") {
							alert(result.msg);
						}
					}
				},
				error: function() {
					window.location.href = "error.html";
				}
			});
});


function projectTaskAnalyse() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "projectTaskAnalyse.html?projectId="+projectId;
}