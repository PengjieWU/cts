function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}


$(function() {
	var userLoginAccount = GetQueryString("userLoginAccout");
	alert(userLoginAccount);
	document.getElementById("userLoginAccount").value = userLoginAccount;
});


function updateUser(){
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/user/updateUser.action";
	var paramObj = $("#userInfoUpdateForm").serializeObject();
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
				alert("网络异常，请稍后重试");
				var userLoginAccount = document.getElementById("userLoginAccount").value;
				window.location.href = "modifiedUserInfo.html?userLoginAccout="+userLoginAccount;
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});
	
}
