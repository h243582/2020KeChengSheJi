function panDuan(){
    //吧登录编程注册
    $(".j1 table tr:first-child th" ).text("用户注册界面");
    $(".j1 table tr:nth-child(2) th" ).text("这里没有快速安全注册，别期待了");

    // document.querySelector(".j1 table tr:nth-child(2) th")
    document.getElementById("username").placeholder = "请输入注册账号";
    // $(".j1 table tr:nth-child(3) th").placeholder("请输入注册账号");
    document.getElementById("password").placeholder = "请输入密码";
    $(".j1 table tr:nth-child(5) th input").val("注册");
    $(".form").attr("action","RegisterServlet");//submit提交RegisterServlet
    $('.form').attr("onsubmit","return validate();");
    $("#username").attr("class","register")
}

