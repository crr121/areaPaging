//定义全局变量
var pageSize = 10,curPage = 1,pageCount = 0;
window.onload = sendPageAjax;

//发送请求
function sendPageAjax(){
	$.post("AreaPageServlet",{"pageSize":pageSize,"curPage":curPage,"random":Math.random()},function(){
		//取出pagecount
		pageCount = data.pageCount;
		alert(pageCount);
		//取出pageInfo里面的10条数据显示 包括code name layer
	 $.each(data.pageInfo,function(index,area){
		 $("tbody").append("<tr><td>"+area.code+"</td>" +
		 		"<td>"+area.name+"</td>" +
		 				"<td>"+area.layer+"</td>" +
		 						"<td hrea='#'>修改</td></tr>");
	 });
	},"json");
}
