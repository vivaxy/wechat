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
function share(n) {
    document.title = window.shareData.tTitle = n;
    document.getElementById("sbg").className = "sbgshow";
    window.setTimeout(hiddenMe, 5000);
}

function hiddenMe() {
    document.getElementById("sbg").className = "sbg";
}
//
//var mebtnopenurl = 'http://vivaxy.github.io/wechat/web/';
//document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
//
//    WeixinJSBridge.on('menu:share:appmessage', function (argv) {
//        WeixinJSBridge.invoke('sendAppMessage', {
//            "img_url": window.shareData.imgUrl,
//            "link": window.shareData.timeLineLink,
//            "desc": window.shareData.tContent,
//            "title": window.shareData.tTitle
//        }, function (res) {
//            document.location.href = mebtnopenurl;
//        })
//    });
//
//    WeixinJSBridge.on('menu:share:timeline', function (argv) {
//        WeixinJSBridge.invoke('shareTimeline', {
//            "img_url": window.shareData.imgUrl,
//            "img_width": "640",
//            "img_height": "640",
//            "link": window.shareData.timeLineLink,
//            "desc": window.shareData.tContent,
//            "title": window.shareData.tTitle
//        }, function (res) {
//            document.location.href = mebtnopenurl;
//        });
//    });
//
//
//    WeixinJSBridge.on('menu:share:weibo', function (argv) {
//        WeixinJSBridge.invoke('shareWeibo', {
//            "content": window.shareData.tContent,
//            "url": window.shareData.timeLineLink
//        }, function (res) {
//            document.location.href = mebtnopenurl;
//        });
//    });
//
//}, false)