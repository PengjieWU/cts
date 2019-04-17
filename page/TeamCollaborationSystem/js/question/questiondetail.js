function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}

$(function() {
	var projectQuestionId = GetQueryString("projectQuestionId");
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/question/findQuestionByProjectQuestionId.action?projectQuestionId="+projectQuestionId;
	document.getElementById("projectQuestionBelong").value = projectQuestionId;
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
				document.getElementById("projectQuestionBelong").value = questionList.projectQuestionId;
				$("#projectQuestionKeyword").html(questionList.projectQuestionKeyword);
				$("#projectQuestionDescription").html(questionList.projectQuestionDescription);
			}else{
				alert(result.msg)
				window.location.href= "error.html";
			}
		},
		error: function() {
			//window.location.href= "error.html";
			alert("网络异常！请稍后重试");
		}
	});

});

$(function() {
	var projectQuestionId = GetQueryString("projectQuestionId");
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/question/findQuestionByBelongId.action?projectQuestionId="+projectQuestionId;
	document.getElementById("projectQuestionBelong").value = projectQuestionId;
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
				var answerList = result.data;
				var str = "";
				$(answerList).each(function(index,item){
						
						str+="<div class=\"media\">";
						str+="<div class=\"media-body\">";
						str+="<h4 class=\"media-heading\">";
						str+="<small>";
						str+=item.projectCreatorName;
						str+="</small>";
						str+="</h4>";
						str+="<p>";
						str+=item.projectQuestionAnswer;
						str+="</p>";
						str+="</div>";
						str+="</div>";
						
					});
					$("#answerList").html(str);
				
			}else{
				alert(result.msg)
				window.location.href= "error.html";
			}
		},
		error: function() {
			//window.location.href= "error.html";
			alert("网络异常！请稍后重试");
		}
	});

});

function addNewComment(){
		
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/question/addNewCommment.action";
		var paramObj = $("#addNewCommment").serializeObject();
		$.ajax({
            type: 'POST',//方法类型
            xhrFields: {withCredentials: true},
            dataType: "json",//预期服务器返回的数据类型
            contentType: "application/json",
            data:JSON.stringify(paramObj),
            async:false,
            url: routeUrl,//url
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result.code == 0){
                	
                	window.location.reload();
                }else{
                	if(result.code == "-1"){
                		window.location.href= "error.html";
                		alert(result.msg);
                	}
                }
            },
            error : function() {
            	
                alert("网络异常！请稍后重试");
            }
        });
    }


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