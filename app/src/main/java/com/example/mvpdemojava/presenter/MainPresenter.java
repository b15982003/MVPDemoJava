package com.example.mvpdemojava.presenter;

import com.example.mvpdemojava.model.MainModel;
import com.example.mvpdemojava.view.MainView;

public class MainPresenter {

    private MainView mainView;
    private MainModel mainModel;

    public MainPresenter(MainView mainView,MainModel mainModel){
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    public void onCreat(){
        mainView.setContentView();
    }

    public void onLogInCheck(String account,String passWord){
        mainModel.checkaccount(account,passWord);

        mainView.clearEdittext();
        mainView.toastMsg(mainModel.checkSuccessfalAccoundMsg());
    }
}
