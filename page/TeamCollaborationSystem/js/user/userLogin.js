function findByUserLoginAccount() {
	alert("这是点击了登录按钮");
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/user/findByUserLoginAccount.action";
	var paramObj = $("#userLoginForm").serializeObject();
	$.ajax({
		type: "POST",
		xhrFields: {withCredentials: true},
		dataType: "json",
		contentType: "application/json",
		async: false,
		data: JSON.stringify(paramObj),
		url: routeUrl,
		success: function(result) {
			if(result.code == "0") {
				alert("登录成功");
				window.location.href = "homepage.html";
			} else {
				alert("登录失败");
				window.location.href = "userRegister.html";
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
}