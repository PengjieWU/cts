function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}




$(function() {
	var projectStoryId = GetQueryString("projectStoryId");
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projectstoryinfo/findStoryInfoByProjectStoryId.action?projectStoryId="+projectStoryId;
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
				var storyItem = result.data;
				document.getElementById("projectStoryId").value = storyItem.projectStoryId;
				document.getElementById("projectStoryName").value = storyItem.projectStoryName;
				document.getElementById("projectStoryTypeCode").value = storyItem.projectStoryTypeCode;
				document.getElementById("projectStoryDescription").innerHTML = storyItem.projectStoryDescription;
				document.getElementById("projectStoryProgress").value = storyItem.projectStoryProgress;
				document.getElementById("targetUserId").value = storyItem.targetUserId;
				document.getElementById("projectStoryPrioritySeq").value = storyItem.projectStoryPrioritySeq;
				document.getElementById("projectStoryDurationTime").value = storyItem.projectStoryDurationTime;
				document.getElementById("status").value = storyItem.status;
				document.getElementById("controlWord").value = storyItem.controlWord;
				document.getElementById("remark").value = storyItem.remark;
				document.getElementById("creator").value = storyItem.creator;
				document.getElementById("creatorDateTime").value = storyItem.creatorDateTime;
				var textarea=document.getElementById('projectStoryDescription');
				textarea.style.height = textarea.scrollHeight + 'px';
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
});

$(function() {
	var projectStoryId = GetQueryString("projectStoryId");
	document.getElementById("projectStoryId").value = projectStoryId;
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projectstoryinfo/findUserByProjectStoryId.action?projectStoryId="+projectStoryId;
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
				var userList = result.data;
				var str = "";
				str+="<option value=\"\"></option>";
				$(userList).each(function(index,item){
						
						str+="<option value=\"";
						str+=item.userId+"\"";
						
						str+=">";
						str+=item.userName;
						str+="</option>";
					});
					$("#targetUserId").html(str);
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});

});
function updateProjectStoryInfo(){
		var projectStoryId = GetQueryString("projectStoryId");
		
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projectstoryinfo/updateProjectStoryInfo.action";
		var paramObj = $("#storyUpdateForm").serializeObject();
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
                	
                	window.location.href="modifiedstory.html?projectStoryId="+projectStoryId;
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