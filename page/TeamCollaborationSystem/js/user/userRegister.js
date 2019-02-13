	function addUser(){
		alert("这是点击了注册按钮");
		var url = "http://127.0.0.1:8088/teamcollaborationsyste/user/addUser.action";
		var data = $("#userRegisterForm").serializeObject();
		$.ajax({
            type: 'POST',//方法类型
            dataType: "json",//预期服务器返回的数据类型
            contentType: "application/json",
            data:JSON.stringify(data),
            url: url,//url
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result.code == 0){
                	alert("注册成功");
                    //window.location.href = "userLogin.html"
                };
            },
            error : function() {
                alert("网络异常！请稍后重试");
            }
        });
    }