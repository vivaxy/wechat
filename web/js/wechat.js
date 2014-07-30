/**
 * Author : vivaxy
 * Date   : 2014/7/30 8:32
 * Project: wechat
 */
window.shareData = {
    "imgUrl": "http://www.baidu.com/img/baidu_sylogo1.gif",
    "timeLineLink": "http://vivaxy.github.io/wechat/web/",
    "tTitle": "this is a title",
    "tContent": "this is a content"
};

function showme() {
    if (navigator.userAgent.indexOf("iPhone") != -1) {
        window.location.href = "http://mp.weixin.qq.com/s?__biz=MzA5NDY4MzMxOQ==&mid=200506249&idx=1&sn=600daa415b4d0c00e526e93bb9cd1bea#rd";
    } else {
        window.location.href = "http://wechat.nibaguai.com/cat/install.php";
    }
}
function share(n) {
    document.title = window.shareData.tTitle = "你输入了" + n;
    document.getElementById("sbg").className = "sbgshow";
    window.setTimeout(hiddenMe, 5000);
    document.getElementById("myfav").style.display = "none";
}

function hiddenMe() {
    document.getElementById("sbg").className = "sbg";
}

var mebtnopenurl = 'http://vivaxy.github.io/wechat/web/';
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {

    WeixinJSBridge.on('menu:share:appmessage', function (argv) {
        WeixinJSBridge.invoke('sendAppMessage', {
            "img_url": window.shareData.imgUrl,
            "link": window.shareData.timeLineLink,
            "desc": window.shareData.tContent,
            "title": window.shareData.tTitle
        }, function (res) {
            document.location.href = mebtnopenurl;
        })
    });

    WeixinJSBridge.on('menu:share:timeline', function (argv) {
        WeixinJSBridge.invoke('shareTimeline', {
            "img_url": window.shareData.imgUrl,
            "img_width": "640",
            "img_height": "640",
            "link": window.shareData.timeLineLink,
            "desc": window.shareData.tContent,
            "title": window.shareData.tTitle
        }, function (res) {
            document.location.href = mebtnopenurl;
        });
    });


    WeixinJSBridge.on('menu:share:weibo', function (argv) {
        WeixinJSBridge.invoke('shareWeibo', {
            "content": window.shareData.tContent,
            "url": window.shareData.timeLineLink
        }, function (res) {
            document.location.href = mebtnopenurl;
        });
    });

}, false)