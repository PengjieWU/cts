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
						var crtTime = new Date(item.creatorDateTime);
						var time1 = dateFtt("yyyy-MM-dd hh:mm:ss",crtTime);
						str+=time1;
						str+="</td>";
						/*str+="<td class=\"hidden-480\">";
						str+="<a href=\"#\" onclick=\"deleteUserFromProject(\'";
						str+=item.userProjectId;
						str+="\')\"";
						str+="class=\"btn\" rel=\"tooltip\" title=\"Delete\">";
						str+="X";
						str+="</a>";
						str+="</td>";*/
						str+="</tr>";
					});
					$("#userList").html(str);
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



function deleteUserFromProject(userProjectId) {
	
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

function addUser() {
	var projectId = GetQueryString("projectId");
	
	window.location.href = "http://127.0.0.1:8020/TeamCollaborationSystem/adduser.html?projectId="+projectId;
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
							window.location.href = "error.html";
						}
					}
				},
				error: function() {
					window.location.href = "error.html";
				}
			});
});