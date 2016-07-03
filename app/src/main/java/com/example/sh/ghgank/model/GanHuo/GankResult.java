package com.example.sh.ghgank.model.GanHuo;

import java.util.List;

/**
 * Created by sh_pc on 2016/7/3.
 */
public class GankResult {

    /**
     * error : false
     * results : [{"_id":"57755676421aa97a566cc167","createdAt":"2016-07-01T01:27:18.971Z","desc":"Material Design初露锋芒之复杂视图轻松实现","publishedAt":"2016-07-01T11:06:20.244Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/e64a4e08f57a","used":true,"who":null},{"_id":"57751b8b421aa97f5186e44d","createdAt":"2016-06-30T21:15:55.132Z","desc":"weex开源了","publishedAt":"2016-07-01T11:06:20.244Z","source":"chrome","type":"Android","url":"https://github.com/alibaba/weex","used":true,"who":"wuzheng"},{"_id":"577512e2421aa97a53656c37","createdAt":"2016-06-30T20:38:58.916Z","desc":"Android Jebkins自动构建 实现方案","publishedAt":"2016-07-01T11:06:20.244Z","source":"web","type":"Android","url":"http://valuesfeng.github.io/2016/06/30/Android-jenkins","used":true,"who":null},{"_id":"5774c2d5421aa97a566cc15d","createdAt":"2016-06-30T14:57:25.327Z","desc":"一个倾斜的TextView，适用于标签场景。","publishedAt":"2016-07-01T11:06:20.244Z","source":"web","type":"Android","url":"https://github.com/HeZaiJin/SlantedTextView","used":true,"who":"张浩"},{"_id":"5774ae1b421aa97a566cc159","createdAt":"2016-06-30T13:28:59.540Z","desc":"局域网WiFi文件上传框架，基于CocoaHTTPServer，可自定义上传文件的数量和存储位置，使用简单。欢迎Star！","publishedAt":"2016-07-01T11:06:20.244Z","source":"web","type":"iOS","url":"https://github.com/Soulghost/SGWiFiUpload","used":true,"who":null},{"_id":"5774911c421aa97a566cc153","createdAt":"2016-06-30T11:25:16.598Z","desc":"6.30","publishedAt":"2016-06-30T11:40:10.110Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f5d36vpqyuj20zk0qo7fc.jpg","used":true,"who":"代码家"},{"_id":"57749095421aa97f5186e43c","createdAt":"2016-06-30T11:23:01.559Z","desc":"OC 参考前端实现的 FlexBox 布局","publishedAt":"2016-06-30T11:40:10.110Z","source":"chrome","type":"iOS","url":"https://github.com/molon/MLLayout","used":true,"who":"代码家"},{"_id":"5774905f421aa97a566cc152","createdAt":"2016-06-30T11:22:07.39Z","desc":"Xcode 插件帮你快速插入缺失的头文件，协议和父类","publishedAt":"2016-06-30T11:40:10.110Z","source":"chrome","type":"iOS","url":"https://github.com/music4kid/FastStub-Xcode","used":true,"who":"代码家"},{"_id":"57748fe6421aa901fb9825da","createdAt":"2016-06-30T11:20:06.197Z","desc":"Swift 实现的一个 Loading 动画","publishedAt":"2016-06-30T11:40:10.110Z","source":"chrome","type":"iOS","url":"https://github.com/Loveway/HWLoadingAnimation","used":true,"who":"代码家"},{"_id":"57748900421aa97a53656c22","createdAt":"2016-06-30T10:50:40.662Z","desc":"一个基于 react 和 redux 的前端框架。","publishedAt":"2016-06-30T11:40:10.110Z","source":"web","type":"前端","url":"https://github.com/sorrycc/dva","used":true,"who":"chencheng (云谦)"}]
     */

    private boolean error;
    /**
     * _id : 57755676421aa97a566cc167
     * createdAt : 2016-07-01T01:27:18.971Z
     * desc : Material Design初露锋芒之复杂视图轻松实现
     * publishedAt : 2016-07-01T11:06:20.244Z
     * source : web
     * type : Android
     * url : http://www.jianshu.com/p/e64a4e08f57a
     * used : true
     * who : null
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private Object who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public Object getWho() {
            return who;
        }

        public void setWho(Object who) {
            this.who = who;
        }
    }
}
