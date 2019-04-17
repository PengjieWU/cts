function findByUserLoginAccount() {
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
				window.location.href = "homepage.html";
			} else {
				alert(result.msg);
				window.location.href = "userLogin.html";
			}
		},
		error: function() {
			window.location.href = "userLogin.html";
			alert("网络异常！请稍后重试");
		}
	});
}



