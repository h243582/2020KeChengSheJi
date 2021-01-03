function gogo() {
    var $space = $(".space3");
    var $table = $(".space3 table");
    if ($space.attr("class") === "space3") {
        setTimeout(function (){
            $table.attr("class", "table active");
        },800);

        $space.attr("class", "space3 active");

    } else {
        setTimeout(function (){
            $table.attr("class", "table");
        },100);

        $space.attr("class", "space3");


    }

}