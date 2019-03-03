	function addProject(){
		alert("这是点击了创建项目按钮");
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/project/addProject.action";
		var paramObj = $("#projectCreateForm").serializeObject();
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
                	alert("创建项目成功");
                	window.location.href="homepage.html";
                }else{
                	if(result.code == "-1"){
                		alert(result.msg);
                	}
                }
            },
            error : function() {
                alert("网络异常！请稍后重试");
            }
        });
    }