package com.dekotlinapp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.dekotlinapp.InterfaceClass.LoginController;
import com.dekotlinapp.R;

/**
 * Created by AMD21 on 8/6/17.
 */

public class LoginActivity extends Activity implements LoginController {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ShowToast();

    }

    @Override
    public void ShowToast() {
        Toast.makeText(LoginActivity.this, "MESSAGE", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Log() {

        Log.d("Log", "LOG");
    }

    @Override
    public void CallWebservice() {

        //Callhere to Webservice
    }

    @Override
    public void inNetwork() {

//        Check Internet
    }
}
