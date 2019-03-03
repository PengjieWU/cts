function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}

$(function() {
	var projectId = GetQueryString("projectId");
	alert(projectId);
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/project/findProjectByProjectId.action?projectId="+projectId;
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
				var projectItem = result.data;
				document.getElementById("projectId").value = projectItem.projectId;
				document.getElementById("projectName").value = projectItem.projectName;
				document.getElementById("projectCompany").value = projectItem.projectCompany;
				document.getElementById("projectDescription").innerHTML = projectItem.projectDescription;
				document.getElementById("projectContactName").value = projectItem.projectContactName;
				document.getElementById("projectContactPhone").value = projectItem.projectContactPhone;
				document.getElementById("projectContactEmail").value = projectItem.projectContactEmail;
				document.getElementById("projectSecrecy").value = projectItem.projectSecrecy;
				document.getElementById("projectDurationTime").value = projectItem.projectDurationTime;
				document.getElementById("status").value = projectItem.status;
				document.getElementById("controlWord").value = projectItem.controlWord;
				document.getElementById("remark").value = projectItem.remark;
				document.getElementById("creator").value = projectItem.creator;
				document.getElementById("creatorDateTime").value = projectItem.creatorDateTime;
				var textarea=document.getElementById('projectDescription');
				textarea.style.height = textarea.scrollHeight + 'px';
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
});

function updateProjectInfo(){
		alert("这是点击了修改项目按钮");
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/project/updateProjectByLoginUser.action";
		var paramObj = $("#projectUpdateForm").serializeObject();
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
                	alert("修改项目成功");
                	window.location.href="homepage.html";
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