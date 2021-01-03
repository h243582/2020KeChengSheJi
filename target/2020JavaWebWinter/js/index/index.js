var items = document.getElementsByClassName('item');
var points = document.getElementsByClassName('point')
var goPreBtn = document.getElementById('goPre');
var goNextBtn = document.getElementById('goNext');
// var goNextBtn = $("#goNext");
var index = 0;//图片在几张图片显示，第index张图片有active这个类名
var time = 0;//定时器
/**
 * index是多少就显示哪个图片
 */
var goIndex = function () {
    for (var i = 0; i < items.length; i++) {
        items[i].className = 'item';
        points[i].className = "point";
    }
    items[index].className = 'item active';
    points[index].className = 'point active';
}

var goNext = function () {
    index++;
    if (index === 4) {
        index = 0;
    }
    goIndex();
}
var goPre = function () {
    index--;
    if (index === -1) {
        index = 3;
    }
    goIndex();
}

// goNextBtn.addEventListener('click', function () {
//     goNext();
//     time = 0;
// });
// goPreBtn.addEventListener('click', function () {
//     goPre();
//     time = 0;
// });
//    点击点
for (var i = 0; i < points.length; i++) {
    points[i].addEventListener('click', function () {
        var pointIndex = this.getAttribute('data-index');
        index = pointIndex;
        goIndex();
        time = 0;
    });
}

//定时器自动轮播，点击时取消定时器
setInterval(function () {
    time++;
    if (time === 20) {
        goNext();
        time = 0;
    }
}, 100);