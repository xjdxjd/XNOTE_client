$(function(){
    $('label').click(function(){
        $('.event_year>li').removeClass('current');
        $(this).parent('li').addClass('current');
        var year = $(this).attr('for');
        $('#'+year).parent().prevAll('div').slideUp(500);
        $('#'+year).parent().slideDown(500).nextAll('div').slideDown(500);
    });
});