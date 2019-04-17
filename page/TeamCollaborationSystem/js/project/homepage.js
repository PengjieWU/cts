//这是进入页面初始化的方法
$(function() {
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/project/findProjectByLoginUser.action";
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
				var projectList = result.data;
				if(projectList.length == 0){//登录后自己没有创建过的项目
					$("#homepagediv2").hide();
					$("#homepagediv3").hide();
					$("#homepagediv4").hide();
				}else{ //登录后自己有过创建的项目
					$("#homepagediv1").hide();
					$("#homepagediv3").hide();
					$("#homepagediv4").hide();
					var str = "";
					$(projectList).each(function(index,item){ 
						str+="<div class=\"blog-list-post small\">";
						str+="<div class=\"preview-img col-sm-3\">";
						str+="<a href=\"#\">";
						str+="<img src=\"img/demo/big/2.jpg\" alt=\"了解更多\">";
						str+="</a>";
						str+="</div>";
						str+="<div class=\"post-content col-sm-9\">";
						str+="<h4 class=\"post-title\">";
						str+="<a href=\"projectdetail.html?";
						str+="projectId="
						str+=item.projectId;
						str+="\">";
						str+=item.projectName;
						str+="</a>";
						str+="</h4>";
						str+="<div class=\"post-meta\">";
						str+="<span class=\"date\">";
						str+="<i class=\"fa fa-calendar\"></i>";
						str+=item.projectCompany;
						str+="</span>";
						str+="<span class=\"comments\">";
						str+="<i class=\"fa fa-comments\"></i>";
						str+="<a href=\"#\">";
						str+=item.projectSecrecy;
						str+="</a>";
						str+="</span>";
						str+="<span class=\"comments\">";
						str+="<i class=\"fa fa-comments\"></i>";
						str+="<a href=\"#\">";
						str+=item.projectDurationTime;
						str+="</a>";
						str+="</span>";
						str+="<span class=\"comments\">";
						str+="<i class=\"fa fa-comments\"></i>";
						str+="<a href=\"#\">";
						str+=item.projectContactEmail;
						str+="</a>";
						str+="</span>";
						str+="<span class=\"comments\">";
						str+="<i class=\"fa fa-comments\"></i>";
						str+="<a href=\"#\">";
						str+=item.projectContactPhone;
						str+="</a>";
						str+="</span>";
						str+="<span class=\"comments\">";
						str+="<i class=\"fa fa-comments\"></i>";
						str+="<a href=\"#\">";
						str+=item.projectContactName;
						str+="</a>";
						str+="</span>";
						str+="<span class=\"comments\">";
						str+="<i class=\"fa fa-comments\"></i>";
						str+="<a href=\"#\">";
						str+=item.status;
						str+="</a>";
						str+="</span>";
						str+="</div>";
						str+="<div class=\"post-text\">";
						str+="<p>";
						str+=item.projectDescription;
						str+="</div>";
						str+="</div>";
						str+="</div>";
					});
					$("#homepagediv2").html(str);
				}	
			} else {
				if(result.code == "-1") {
					window.location.href= "error.html";
					$("#homepagediv2").hide();
					$("#homepagediv3").hide();
					$("#homepagediv4").hide();
				}
			}
		},
		error: function() {
			window.location.href = "error.html"
		}
	});
});

//这是进入页面初始化的方法，用来调取查询左侧树状栏
$(function() {
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/project/findProjectByLoginUser.action";
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
				var projectList = result.data;
				if(projectList.length == 0){//登录后自己没有创建过的项目	
				}else{ //登录后自己有过创建的项目
					var str = "";
					$(projectList).each(function(index,item){ 
						str+="<li>";
						str+="<a href=\"projectdetail.html?";
						str+="projectId="
						str+=item.projectId;
						str+="\">";
						str+=item.projectName;
						str+="</a>";
						str+="</li>";
					});
					$("#leftMenuProjectOfMineCreate").html(str);
				}	
			} 
		},
		error: function() {
			window.location.href = "error.html"
		}
	});
});


//这是进入页面初始化的方法，用来调取查询左侧树状栏查找我参与的项目
$(function() {
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/userproject/findProjectByLoginUserJoin.action";
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
				var projectList = result.data;
				if(projectList.length == 0){//登录后自己没有创建过的项目
				}else{ //登录后自己有过创建的项目
					var str = "";
					$(projectList).each(function(index,item){ 
						str+="<li>";
						str+="<a href=\"projectdetail.html?";
						str+="projectId="
						str+=item.projectId;
						str+="\">";
						str+=item.projectName;
						str+="</a>";
						str+="</li>";
					});
					$("#leftMenuProjectOfMineJoin").html(str);
				}	
			} 
		},
		error: function() {
		}
	});
});

