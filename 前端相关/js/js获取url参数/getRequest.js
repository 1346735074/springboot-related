/*
 * 需要依赖jquery.js
 */
jQuery.extend({
    /*获取参数
    * 使用步骤：
    * GetRequest  获取Request集合
     * 1.var Request = new Object();
     * 2.Request = $.GetRequest();
     * 3.var a = Request['a'];
    * */
    GetRequest: function() {
        function getRequest() {
            var url = location.search; //获取url中"?"符后的字串
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for(var i = 0; i < strs.length; i ++) {
                    theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
                }
            }
            return theRequest;
        }
        return getRequest();
    },
    /*获取网址http://baidu.com*/
    GetHost:function () {
        function getHost() {
            var http = window.location.protocol;//获取 URL 的协议部分
            var url = window.location.host;//获取 URL 的主机部分
            return http+"//"+url+"/";
        }
        return getHost();
    }
});