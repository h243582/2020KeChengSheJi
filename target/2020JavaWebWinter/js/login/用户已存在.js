function alreadyHave(){
    document.querySelector(".black_overlay").style.display='block';
    document.querySelector(".window").style.display='block';
}
function outHave(){
    document.querySelector(".black_overlay_0").style.display='none';
    document.querySelector(".window_0").style.display='none';
}
function change(){
    $("#black").attr("class","black_overlay");
    $("#window").attr("class","window");
    $("#form").attr("action","FirstAddProblemServlet?method=new")
    alreadyHave();
}
function outChange(){
    $("#black").attr("class","black_overlay_0");
    $("#window").attr("class","window_0");
    outHave();
}