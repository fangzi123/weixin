var title = "2499抢租十号线公寓, 开放预订仅限99套";
var desc = '距国贸15分钟，寓见家公寓十里河地铁店现已开始接受预订';
var imgUrl = getRootPath() + "/images/activity/1210shilihe/6.jpg";
var link = getRootPath() + "/rental/activity/shilihe_trade?activityId=1";

function getRootPath() {
    // // 获取当前网址
    // var curPath = window.document.location.href;
    // var pos = curPath.indexOf(pathName);
    // 获取主机地址
    // var hostPath = curPath.substring(0, pos);
    var hostPath = "http://182.92.24.42";
    // 获取带"/"的项目名
    var pathName = window.document.location.pathname;
    var projectName = pathName
            .substring(0, pathName.substr(1).indexOf('/') + 1);
    return (hostPath + projectName);
}

function shareFriend() {
    WeixinJSBridge.invoke('sendAppMessage', {
        "img_url" : imgUrl,
        "img_width" : "30",
        "img_height" : "30",
        "link" : link,
        "desc" : desc,
        "title" : title
    }, function(res) {
        _report('send_msg', res.err_msg);
    })
}

function shareTimeline() {
    WeixinJSBridge.invoke('shareTimeline', {
        "img_url" : imgUrl,
        "img_width" : "30",
        "img_height" : "30",
        "link" : link,
        "desc" : desc,
        "title" : title
    }, function(res) {
        _report('timeline', res.err_msg);
    });
}

// 当微信内置浏览器完成内部初始化后会触发WeixinJSBridgeReady事件。
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    // 发送给好友
    WeixinJSBridge.on('menu:share:appmessage', function(argv) {
        shareFriend();
    });

    // 分享到朋友圈
    WeixinJSBridge.on('menu:share:timeline', function(argv) {
        shareTimeline();
    });

}, false);
