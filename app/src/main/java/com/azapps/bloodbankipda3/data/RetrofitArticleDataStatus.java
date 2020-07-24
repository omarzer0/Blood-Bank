package com.azapps.bloodbankipda3.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrofitArticleDataStatus {

        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("msg")
        @Expose
        private String msg;
        @SerializedName("data")
        @Expose
        private ArticleData ArticleData;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public ArticleData getArticleData() {
            return ArticleData;
        }

        public void setArticleData(ArticleData ArticleData) {
            this.ArticleData = ArticleData;
        }

}