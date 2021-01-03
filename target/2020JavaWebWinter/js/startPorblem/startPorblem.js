$(function () {
    $(":checkbox").click(function () {
        // var T2_1_t = document.getElementsByName("T2_1");
        if (document.getElementsByName("T2_1")[5].checked){
            $(".T2_1_t").css("display","inline");
        }else{
            $(".T2_1_t").css("display","none");
        }

        if (document.getElementsByName("T2_6")[6].checked){
            $(".T2_6_t").css("display","inline");
        }else{
            $(".T2_6_t").css("display","none");
        }

        if (document.getElementsByName("T2_4")[5].checked){
            $(".T2_4_t").css("display","inline");
        }else{
            $(".T2_4_t").css("display","none");
        }
})

    $(":radio").click(function () {
        var resource = $('input[name="T2_11"]:checked').val();
        if (resource === "没有") {
            $(".t12").css("display", "none");
        } else {
            $(".t12").css("display", "inline");
        }


        var T2_12 = $('input[name="T2_12"]:checked').val();
        // console.log(T2_12);
        if (T2_12 === "其他") {
            $(".T2_12_t").css("display", "inline");
        } else {
            $(".T2_12_t").css("display", "none");
        }

    });
})

