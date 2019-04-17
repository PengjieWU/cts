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
				$("#projectName").html(projectItem.projectName);
				$("#projectCompany").html(projectItem.projectCompany);
				$("#projectDescription").html(projectItem.projectDescription);
				$("#projectSecrecy").html(projectItem.projectSecrecy);
				$("#projectDurationTime").html(projectItem.projectDurationTime);
				$("#projectContactEmail").html(projectItem.projectContactEmail);
				$("#projectContactPhone").html(projectItem.projectContactPhone);
				$("#projectContactName").html(projectItem.projectContactName);
				$("#status").html(projectItem.status);
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
});