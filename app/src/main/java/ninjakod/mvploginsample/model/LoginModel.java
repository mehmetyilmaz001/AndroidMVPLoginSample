package ninjakod.mvploginsample.model;

import android.text.TextUtils;

import ninjakod.mvploginsample.presenter.LoginPresenter;
import ninjakod.mvploginsample.view.LoginView;

public class LoginModel implements LoginPresenter {


    LoginView mLoginView;

    public LoginModel(LoginView loginView){
        mLoginView = loginView;
    }

    @Override
    public void performLogin(String userName, String password) {
        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
            mLoginView.loginValidation();

        }else if(userName.equals("admin") && password.equals("admin")){
            mLoginView.loginSuccess();

        }else {
            mLoginView.loginError();
        }
    }
}
