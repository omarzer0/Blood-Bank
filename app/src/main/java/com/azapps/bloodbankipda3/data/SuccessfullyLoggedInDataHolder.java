package com.azapps.bloodbankipda3.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuccessfullyLoggedInDataHolder {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private SuccessfullyLoggedInData successfullyLoggedInData;

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

    public SuccessfullyLoggedInData getSuccessfullyLoggedInData() {
        return successfullyLoggedInData;
    }

    public void setSuccessfullyLoggedInData(SuccessfullyLoggedInData successfullyLoggedInData) {
        this.successfullyLoggedInData = successfullyLoggedInData;
    }

}