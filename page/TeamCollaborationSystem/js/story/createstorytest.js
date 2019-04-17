function addProjectStoryInfo(){
		alert("这是点击了创建项目按钮");
		var file = document.getElementById("file").value;
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projectstoryinfo/addProjectStoryInfo.action";
		 var formData = new FormData();
          formData.append("myfile", document.getElementById("file").files[0]);
		$.ajax({
            type: 'POST',//方法类型
            xhrFields: {withCredentials: true},
            dataType: "json",//预期服务器返回的数据类型
            
       		 enctype: 'multipart/form-data',
            contentType: false,
             processData: false,
            //data:JSON.stringify(paramObj),
            async:false,
            url: routeUrl,//url
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result.code == 0){
                	
                	window.location.href="homepage.html";
                }else{
                	if(result.code == "-1"){
                		alert(result.msg);
                		window.location.href="error.html";
                	}
                }
            },
            error : function() {
            	window.location.href="error.html";
                alert("网络异常！请稍后重试");
            }
        });
    }