package com.example.mvpdemojava.model;

public class MainModel {

    String msg = "";

    public void checkaccount(String account, String passWord) {
        if (account.equals("Ray") ){
                msg = "successfal";
        }else {
            msg = "fail";
        }

    }

    public String checkSuccessfalAccoundMsg() {
        return msg;
    }
}
