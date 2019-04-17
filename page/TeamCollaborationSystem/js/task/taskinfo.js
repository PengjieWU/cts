function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}

$(function() {
	var projectId = GetQueryString("projectId");
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projecttaskinfo/findTaskInfoByProjectIdAndMySelf.action?projectId="+projectId;
	
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
				var taskItem = result.data;
				document.getElementById("projectTaskScheduleId").value = taskItem.projectTaskScheduleId;
				document.getElementById("projectResourceId").value = taskItem.projectResourceId;
				document.getElementById("projectTaskResourceName").value = taskItem.projectTaskResourceName;
				document.getElementById("projectTaskResourceType").value = taskItem.projectTaskResourceType;
				document.getElementById("projectTaskScheduleTypeCode").value = taskItem.projectTaskScheduleTypeCode;
				document.getElementById("projectTaskScheduleCreatorName").value = taskItem.projectTaskScheduleCreatorName;
				document.getElementById("status").value = taskItem.status;
				document.getElementById("controlWord").value = taskItem.controlWord;
				document.getElementById("remark").value = taskItem.remark;
				document.getElementById("creator").value = taskItem.creator;
				document.getElementById("creatorDateTime").value = taskItem.creatorDateTime;
				
				document.getElementById("projectTaskScheduleDoneValue").innerHTML = taskItem.projectTaskScheduleDoneValue;
				document.getElementById("projectTaskScheduleTodoValue").innerHTML = taskItem.projectTaskScheduleTodoValue;
				document.getElementById("projectTaskScheduleProblemValue").innerHTML = taskItem.projectTaskScheduleProblemValue;
				var textarea1=document.getElementById('projectTaskScheduleDoneValue');
				textarea1.style.height = textarea1.scrollHeight + 'px';
				var textarea2=document.getElementById('projectTaskScheduleTodoValue');
				textarea2.style.height = textarea2.scrollHeight + 'px';
				var textarea3=document.getElementById('projectTaskScheduleProblemValue');
				textarea3.style.height = textarea3.scrollHeight + 'px';
				document.getElementById("projectId").value = projectId;
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
});

function submitTaskInfo(){
		var projectId = GetQueryString("projectId");
		
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projecttaskinfo/submitTaskInfo.action";
		var paramObj = $("#taskInfoForm").serializeObject();
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
                	var taskItem = result.data;
                	
                	window.location.href="taskinfo.html?projectId="+projectId;
                }else{
                	if(result.code == "-1"){
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