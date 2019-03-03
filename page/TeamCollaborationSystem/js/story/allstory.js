function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}

$(function() {
	var projectId = GetQueryString("projectId");
	alert(projectId);
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
				$(userList).each(function(index,item){
						
						str+="<tr>";
						str+="<td>";
						str+=item.projectStoryName;
						str+="</td>";
						str+="<td>";
						str+=item.projectStoryTypeCode;
						str+="</td>";
						str+="<td class=\"hidden-350\">";
						str+=item.targetUserName;
						str+="</td>";
						str+="<td class=\"hidden-1024\">";
						str+=item.projectStoryProgress;
						str+="</td>";
						str+="<td class=\"hidden-480\">";
						str+=item.projectStoryDurationTime;
						str+="<a href=\"#\" onclick=\"viewStoryInfo(\'";
						str+=item.projectStoryId;
						str+="\')\"";
						str+="class=\"btn\" rel=\"tooltip\" title=\"View\">";
						str+="<i class=\"fa fa-edit\"></i>";
						str+="</a>";
						str+="</td>";
						str+="</tr>";
					});
					$("#userStoryList").html(str);
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});

});