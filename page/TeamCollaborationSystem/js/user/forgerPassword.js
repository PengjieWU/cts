

function getVerificationCode() {
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/user/getVerificationCode.action";
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
				alert("验证码已发送");
				
			} else {
				alert("邮件发送失败，请稍后重试");
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
}


function checkVerificationCode() {
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/user/checkVerificationCode.action";
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
				var userLoginAccount = document.getElementById("userLoginAccount").value;
				window.location.href = "modifiedUserInfo.html?userLoginAccout="+userLoginAccount;
			} else {
				alert(result.msg);
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
}






