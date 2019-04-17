function addUser() {
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/user/addUser.action";
	var paramObj = $("#userRegisterForm").serializeObject();
	$.ajax({
		type: "POST", //方法类型
		xhrFields: {withCredentials: true},
		dataType: "json", //预期服务器返回的数据类型
		async: false,
		contentType: "application/json",
		data: JSON.stringify(paramObj),
		url: routeUrl, //url
		success: function(result) {
			console.log(result); //打印服务端返回的数据(调试用)
			if(result.code == "0") {
				alert("注册成功");
				window.location.href = "homepage.html";
			} else {
				if(result.code == "-1") {
					alert("注册失败");
				}
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
}


function judgeUserLoginAccoutLegal() {
	
	var userLoginAccount =  document.getElementById("userLoginAccount").value;
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/user/judgeUserLoginAccoutLegal.action?userLoginAccount="+userLoginAccount;
	
	$.ajax({
		type: "GET", //方法类型
		xhrFields: {withCredentials: true},
		dataType: "json", //预期服务器返回的数据类型
		async: false,
		//contentType: "application/json",
		//data: JSON.stringify(paramObj),
		url: routeUrl, //url
		success: function(result) {
			console.log(result); //打印服务端返回的数据(调试用)
			if(result.code == "0") {
				if(result.data!= null){
					alert(result.data);
				}
			} else {
				if(result.code == "-1") {
					alert("账号已被他人使用过，请尝试找回密码");
				}
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
}