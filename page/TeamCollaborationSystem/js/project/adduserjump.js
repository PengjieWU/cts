function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg); //search,查询？后面的参数，并匹配正则
	if(r != null) return decodeURI(r[2]);
	return null;
}

$(function() {
	var projectId = GetQueryString("projectId");
	var targetEmail = GetQueryString("targetEmail");
	var role = GetQueryString("role");
	
	var addUserEntity = {"projectId":projectId,"targetEmail":targetEmail,"role":role};
	
	var routeUrl = "http://127.0.0.1:8088/teamcollaborationsystem/userproject/addUserJump.action";
	$.ajax({
            type: 'POST',//方法类型
            xhrFields: {withCredentials: true},
            dataType: "json",//预期服务器返回的数据类型
            contentType: "application/json",
            data:JSON.stringify(addUserEntity),
            async:false,
            url: routeUrl,//url
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result.code == 0){
                	var targetProjectId = result.data;
                	setTimeout("jumpPage()",5000);
                	
                }else{
                	if(result.code == "-1"){
                		alert(result.msg);
                	}
                }
            },
            error : function() {
                window.location.href = "error.html"
            }
        });

});


function jumpPage(){
	var projectId = GetQueryString("projectId");
	alert("初始化信息成功，开始进入项目组吧");
	window.location.href = "projectDetail.html?projectId= "+projectId;
}