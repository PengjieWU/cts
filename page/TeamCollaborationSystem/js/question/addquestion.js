function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}


$(function() {
	var projectId = GetQueryString("projectId");
	
	document.getElementById("projectId").value = projectId;
});


function addQuestion() {
	
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/question/addQuestion.action";
		var paramObj = $("#questionCreateForm").serializeObject();
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
                	
                	var projectId = GetQueryString("projectId");
                	window.location.href="projectquestion.html?projectId="+projectId;
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

$(function() {
	var projectId = GetQueryString("projectId");
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projectstoryinfo/findStoryInfoByProjectId.action?projectId="+projectId;
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
				str+="<option value=\"";
				str+="\"";
				str+=">";
				str+="";
				str+="</option>";
				$(userList).each(function(index,item){
						str+="<option value=\"";
						str+=item.projectStoryId+"\"";
						str+=">";
						str+=item.projectStoryName;
						str+="</option>";
						
					});
					document.getElementById('projectStoryId').innerHTML=str;
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});

});