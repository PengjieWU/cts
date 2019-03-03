function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return unescape(r[2]);
	return null;
}

$(function() {
	var projectId = GetQueryString("projectId");
	alert(projectId);
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
					$("#targetUserId").html(str);
			}
		},
		error: function() {
			alert("网络异常！请稍后重试");
		}
	});

});

function addProjectStoryInfo(){
		alert("这是点击了创建项目按钮");
		var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/projectstoryinfo/addProjectStoryInfo.action";
		var paramObj = $("#storyCreateForm").serializeObject();
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

