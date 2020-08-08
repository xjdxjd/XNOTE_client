$(function () {

    $(".nav > a").each(function () {
        $(this).click(function () {
            $(".nav > a").removeClass("active");
            $(this).addClass('active');
        })
    })
    // $('.nav>a').on()
});
