function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}

$(function() {
	var projectId = GetQueryString("projectId");
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/question/findQuestionByProjectId.action?projectId="+projectId;
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
				var questionList = result.data;
				var str = "";
				$(questionList).each(function(index,item){
						
						str+="<li>";
						str+="<div class=\"search-info\">";
						str+="<a href=";
						str+="\"questiondetail.html?projectQuestionId=";
						str+=item.projectQuestionId;
						str+="\">";
						str+=item.projectQuestionKeyword;
						str+="</a>";
						str+="<p class=\"url\">";
						str+=item.projectCreatorName;
						str+="</p>"
						str+="<p>"
						str+=item.projectQuestionDescription;
						str+="</p>";
						str+="</div>";
						str+="</li>";
						
					});
					$("#questionList").html(str);
			}else{
				alert(result.msg)
				window.location.href= "error.html";
			}
		},
		error: function() {
			window.location.href= "error.html";
			alert("网络异常！请稍后重试");
		}
	});

});

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

function jumpQuestionAllProject() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "projectquestion.html?projectId="+projectId;
}

function jumpQuestionAdd() {
	
				var projectId = GetQueryString("projectId");
				window.location.href = "addquestion.html?projectId="+projectId;
}