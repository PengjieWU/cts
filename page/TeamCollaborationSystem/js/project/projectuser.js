function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}

function getLocalTime(nS) {     
   return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/,' ');     
}

$(function() {
	var projectId = GetQueryString("projectId");
	alert(projectId);
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/userproject/findUserByProjectId.action?projectId="+projectId;
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
				$(userList).each(function(index,item){
						var creatorDateTimeStamp = item.creatorDateTime;
						var creatorDateTime = getLocalTime(creatorDateTimeStamp);
						str+="<tr>";
						str+="<td>";
						str+=item.userName;
						str+="</td>";
						str+="<td>";
						str+=item.userLoginAccount;
						str+="</td>";
						str+="<td class=\"hidden-350\">";
						str+=item.projectRole;
						str+="</td>";
						str+="<td class=\"hidden-1024\">";
						str+=creatorDateTime
						str+="</td>";
						str+="<td class=\"hidden-480\">";
						str+="<a href=\"#\" onclick=\"deleteUserFromProject(\'";
						str+=item.userProjectId;
						str+="\')\"";
						str+="class=\"btn\" rel=\"tooltip\" title=\"Delete\">";
						str+="X";
						str+="</a>";
						str+="</td>";
						str+="</tr>";
					});
					$("#userList").html(str);
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});

});



function deleteUserFromProject(userProjectId) {
	alert(userProjectId);
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/userproject/deleteUserFromProject.action?userProjectId="+userProjectId;
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
				window.location.reload();
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
}

