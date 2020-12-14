package com.example.mvpdemojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mvpdemojava.model.MainModel;
import com.example.mvpdemojava.presenter.MainPresenter;
import com.example.mvpdemojava.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private EditText account, passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainPresenter = new MainPresenter(this, new MainModel());
        mainPresenter.onCreat();

        // 取得 UI 介面中的 View 物件
        // 取得 View 物件後，再透過轉換成實際的物件
        ImageView android = (ImageView)this.findViewById(R.id.android);

        android.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
    }


    @Override
    public void clearEdittext() {
        getAccount().setText("");
        getPassWord().setText("");
    }

    @Override
    public void toastMsg(String checkSuccessfalAccoundMsg) {
        Toast.makeText(this, checkSuccessfalAccoundMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    public void btnLogin(View view) {
        mainPresenter.onLogInCheck(getAccount().getText().toString(), getPassWord().getText().toString());
    }

    private EditText getAccount(){
        return (EditText) findViewById(R.id.account);
    }

    private EditText getPassWord(){
        return (EditText) findViewById(R.id.password);
    }
}