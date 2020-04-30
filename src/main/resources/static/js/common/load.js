function toGoalPage(pageName){
	$("#main").load('/XNOTE_portal/load/toGoalPage',{'pageName':pageName});
}
//$.ajax({
//	url:'',
//	type: 'get',
//	data:{
//		'pageName':pageName
//	},
//	dataType: 'json',
//	success: function(res){
//		if(res.code == 0){
//			 window.location.assign("www.baidu.com");
//		}
//		if(res.code > 0){
//			 window.location.assign("www.baidu.com");
//		}
//	}
//})
//$("#main").load('/XNOTE_portal/load/toGoalPage',{'pageName':pageName});

function open_portal(){
	$("#main").load("/XNOTE_portal/load/toGoalPage");
}