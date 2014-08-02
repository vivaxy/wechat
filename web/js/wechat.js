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
var share = function (title, content) {
    document.title = window.shareData.tTitle = title;
    window.shareData.tContent = content;
    document.getElementById("sbg").className = "sbgshow";
    window.setTimeout(hiddenMe, 5000);
};

var hiddenMe = function () {
    document.getElementById("sbg").className = "sbg";
};

var mebtnopenurl = 'http://vivaxy.github.io/wechat/web/';
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {

    WeixinJSBridge.on('menu:share:appmessage', function (argv) {//发送给好友
        WeixinJSBridge.invoke('sendAppMessage', {
            "img_url": window.shareData.imgUrl,
            "link": window.shareData.timeLineLink,
            "desc": window.shareData.tContent,
            "title": window.shareData.tTitle
        }, function (res) {
            document.location.href = mebtnopenurl;
        })
    });

    WeixinJSBridge.on('menu:share:timeline', function (argv) {//分享到朋友圈
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


    WeixinJSBridge.on('menu:share:weibo', function (argv) {//分享到微博
        WeixinJSBridge.invoke('shareWeibo', {
            "content": window.shareData.tContent,
            "url": window.shareData.timeLineLink
        }, function (res) {
            document.location.href = mebtnopenurl;
        });
    });

}, false)