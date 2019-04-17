$(function() {
	
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/user/findCurrentLoginUser.action";
	
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
				var userItem = result.data;
				document.getElementById("userId").value = userItem.userId;
				document.getElementById("userLoginAccount").value = userItem.userLoginAccount;
				document.getElementById("userName").value = userItem.userName;
				document.getElementById("userPassword").value = userItem.userPassword;
				document.getElementById("repeatUserPassword").value = userItem.userPassword;
			}
		},
		error: function() {
			window.location.href = "error.html"
		}
	});
});


function updateUser(){
		
		
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/user/updateUser.action";
		var paramObj = $("#userInfoUpdateForm").serializeObject();
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
                	
                	
                	window.location.href="homepage.html";
                }else{
                	if(result.code == "-1"){
                		window.location.href = "error.html"
                		alert(result.msg);
                	}
                }
            },
            error : function() {
                alert("网络异常！请稍后重试");
            }
        });
    }