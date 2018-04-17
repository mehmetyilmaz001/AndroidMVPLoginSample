package ninjakod.mvploginsample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ninjakod.mvploginsample.R;
import ninjakod.mvploginsample.model.LoginModel;
import ninjakod.mvploginsample.presenter.LoginPresenter;
import ninjakod.mvploginsample.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{
    EditText mUserName, mPassword;
    Button mBtnLogin;
    LoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = findViewById(R.id.editTextUserName);
        mPassword = findViewById(R.id.editTextPassword);
        mBtnLogin = findViewById(R.id.btnLogin);
        mLoginPresenter = new LoginModel(this);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mUserName.getText().toString();
                String pass = mPassword.getText().toString();

                mLoginPresenter.performLogin(user, pass);
            }
        });
    }

    @Override
    public void loginValidation() {
        Toast.makeText(this, "Giriş hatalı!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Giriş başarılı :)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Hata oluştu :(", Toast.LENGTH_SHORT).show();
    }
}
