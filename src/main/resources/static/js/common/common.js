
$('.doComment').click(function(){
	showTextarea($(this));
	return false;
});

function showTextarea($this)
{
	var $commentss = $this.parent(".comment").siblings(".commentss");
	if($commentss.css('display') == 'none'){
		$commentss.slideDown('slow');
		commformreload(PATH);
	}else{
		$commentss.slideUp('slow');
	}
}

function loadNotePageCut(path, laypage, $notes)
{
	var noteCount, pageSize = 10;

	$.get({
		url: path + 'note/getNoteCount',
		dataType: 'json',
		async: false,
		success: function(res){
			noteCount = res.data;
		}
	});

	laypage.render({
		elem: 'index-page',
		count: noteCount,
		limit: pageSize,
		theme: '#1E9FFF',
		jump: function(obj){
			$.get({
				url: path + 'note/getPagination',
				dateType: 'json',
				data: {
					'pageCode': obj.curr,
					'pageSize': obj.limit
				},
				success: function(res){
					var note = '', noteP = '<p></p>';
					res.data.notes.forEach(function(item,index){
						note = note +
							'<div class="item">' +
							'<div class="item-box layer-photos-demo1 layer-photos-demo">' +
							'<h3>' +
							'<a class="noteTile" href="'+path+'/note/details/'+ item.id + '">'+ item.noteTitle +'</a><br>' +
							upNoteLabel(item.noteCategory) +
							'</h3>' +
							'<h5>' +
							'<i class="layui-icon" style="color: #42b983; margin-right: 8px;">&#xe617;</i>发布于:' +
							'<span>'+ new Date(item.createTime).Format("yyyy-MM-dd") +'</span>' +
							'</h5>' +
							$(noteP).html(item.noteContent.noteContext).text() +
							'</div>' +
							'</div>';
					});
					$notes.html(note);
					return false;
				},
				error: function(res){

					return false;
				}
			});
		}
	});
}

function upNoteLabel(noteCategory)
{
	var noteLabel = '';
	$.each(noteCategory, function(key,value){
		noteLabel = noteLabel +'<span class="noteLabel"><i class="layui-icon">&#xe66e;</i>' + value.cateName +'</span>';
	});
	return noteLabel;
}

function commformreload(path)
{
	layui.use('form', function(){
		var form = layui.form;

		form.on('submit(commform)', function(data){
			$.post({
				url: path+'note/addComment',
				dataType: 'json',
				data: {
					'noteId': data.field.noteId,
					'commText': data.field.commText
				},
				success: function(res){
					if(res.code == 0){
						var itemText = '';
						res.data.forEach(function(item,index){
							itemText = itemText + assembleItem(item);
						});
						$(".comment-list").text("").html(itemText);
					}else{
						layer.msg(res.message);
					}
				}
			});
			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	});
}

function assembleItem(item)
{
	var ss = '<div class="comment-item">' +
			'<p class="citem-name layui-col-sm10">' +
			'<span>' +
				item.userName +
			'</span>' +
			'<i class="layui-icon" style="color: #42b983;">&#xe62e;</i>' +
			'</p>' +
			'<p class="citem-time layui-col-sm2">' +
				new Date(item.createTime).Format("yyyy-MM-dd") +
			'</p>' +
			'<div class="citem-text layui-col-sm12">' +
				item.commText +
			'</div>' +
			'</div>';

	return ss;
}

function xmSelectRun()
{
	var cates = [];
	$.get({
		url: PATH + 'note/getNoteCategory',
		dataType: 'json',
		success: function (res) {
			if(res.code == 0){
				res.data.data.forEach(function(item, index){
					//  组装数据
					var cateItem = {name: item.cateName,value: item.cateCode};
					cates[index] = cateItem;
				});

				//  渲染下拉框
				xmSelect.render({
					el: '#noteCate',
					name: 'noteCate',
					language: 'zn',
					tips: '请选择分类',
					empty: '暂无分类，请先添加笔记分类',
					filterable: true,
					data: cates
				});
			}else{
				layer.msg(res.message);
			}
		}
	});
}

function addNote(data)
{
	console.log(JSON.stringify(data.field));
	console.log(data.field.noteTitle);
	console.log(data.field.noteCate);
	console.log(data.field.content);
	$.ajax({
		url: PATH + 'addnote',
		type: 'PUT',
		dataType: 'JSON',
		data: {
			'note': JSON.stringify(data.field),
			'_': new Date().getTime()
		},
		success: function(res){
			layer.msg(res.code);
		},
		error: function (res) {
			console.log(res.responseJSON.message);
			layer.msg("code = "+ res.responseJSON.status + ", message = " + res.responseJSON.message);
		}
	});
	return false;
}

function logout()
{
	$.get({
		url: PATH + 'login/logout',
		dataType: 'json',
		success: function (res) {
			layer.msg(res.message);
			location.reload();
		}
	})
}