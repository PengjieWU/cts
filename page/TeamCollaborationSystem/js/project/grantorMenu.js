function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}

$(function() {
	var projectId = GetQueryString("projectId");
	
	document.getElementById("projectId").value = projectId;
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
				str+="<option value=\"\"></option>";
				$(userList).each(function(index,item){
						
						str+="<option value=\"";
						str+=item.userId+"\"";
						
						str+=">";
						str+=item.userName;
						str+="</option>";
					});
					$("#receiveId").html(str);
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});

});

$(function() {
	
	
	var projectId = GetQueryString("projectId");
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/systemMenu/getSystemMenu.action?projectId"+projectId;
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
				str+="<option value=\"\"></option>";
				$(menuList).each(function(index,item){
						
						str+="<option value=\"";
						str+=item.menuId+"\"";
						
						str+=">";
						str+=item.menuName;
						str+="</option>";
					});
					$("#menuId").html(str);
			}else{
				alert(result.msg);
			}
		},
		error: function() {
			window.location.href = "error.html"
		}
	});

});


function addProjectUserMenu(){
		
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projectMenuInfo/grantorMenu.action";
		var paramObj = $("#addProjectUserMenuForm").serializeObject();
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
                	alert("授予权限成功");
                	window.location.reload();
                }else{
                	if(result.code == "-1"){
                		alert(result.msg);	
                	}
                }
            },
            error : function() {
            	window.location.href="error.html";
               
            }
        });
 }