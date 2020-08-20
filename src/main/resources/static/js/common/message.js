layui.use(['layer'],function(){
    var layer = layui.layer;

});

function replyMess($btn)
{
    var mesId = $btn.find('input[name="mesId"]').val();
    var observerId = $btn.find('input[name="observerId"]').val();
    var observer = $btn.find('input[name="observer"]').val();
    layer.open({
        type: 2,
        anim: 1,
        title: '<i class="layui-icon" style="color: #1E9FFF;padding-right: 10px;">&#xe609;</i>回复留言',
        area: ['500px','220px'],
        offset: 't',
        shadeClose: true, //开启遮罩关闭
        content: [PATH + 'reply', 'no'],
        btn: '<span style="font-size: 12px;"><i class="layui-icon">&#xe642;</i>回复</span>',
        yes: function(index, layero){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            var $content = $(iframeWin.document.getElementsByName("content"));
            console.log();

            $.ajax({
                url: PATH + 'mes/addcomment',
                type: 'PUT',
                dataType: 'json',
                data: {
                    'mesId': mesId,
                    'observerId': observerId,
                    'observer': observer,
                    'content': $content.val(),
                    '_': new Date().getDate()
                },
                success: function (res) {
                    if(ZERO_CONSTANT == res.code){
                        layer.msg(res.message);
                        window.location.reload();
                    }else{
                        layer.msg(res.message);
                    }
                },
                error: function (res) {

                }
            });
            return false;
        }
    });
};

function replyComment($btn)
{
    var mesId = $btn.find('input[name="mesId"]').val();
    var observerId = $btn.find('input[name="observerId"]').val();
    var observer = $btn.find('input[name="observer"]').val();
    layer.open({
        type: 2,
        anim: 1,
        title: '<i class="layui-icon" style="color: #1E9FFF;padding-right: 10px;">&#xe658;</i>回复评论',
        area: ['500px','220px'],
        offset: 't',
        shadeClose: true, //开启遮罩关闭
        content: [PATH + 'reply', 'no'],
        btn: '<span style="font-size: 12px;"><i class="layui-icon">&#xe642;</i>回复</span>',
        yes: function(index, layero){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            var $content = $(iframeWin.document.getElementsByName("content"));
            console.log();

            $.ajax({
                url: PATH + 'mes/addreply',
                type: 'PUT',
                dataType: 'json',
                data: {
                    'mesId': mesId,
                    'observerId': observerId,
                    'observer': observer,
                    'content': $content.val(),
                    '_': new Date().getDate()
                },
                success: function (res) {
                    if(ZERO_CONSTANT == res.code){
                        layer.msg(res.message);
                        window.location.reload();
                    }else{
                        layer.msg(res.message);
                    }
                },
                error: function (res) {

                }
            });
            return false;
        }
    });
}
