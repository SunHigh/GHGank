package com.example.sh.ghgank.model;

import java.util.List;

import javax.xml.transform.Result;

/**
 * Created by sh_pc on 2016/6/13.
 */
public class Gank {
    private boolean error;
    private List<Result> results;

    public Gank(List<Result> results, boolean error) {
        this.results = results;
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public class Result{
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private String used;
        private String who;

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

        public String getUsed() {
            return used;
        }

        public void setUsed(String used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }

}
