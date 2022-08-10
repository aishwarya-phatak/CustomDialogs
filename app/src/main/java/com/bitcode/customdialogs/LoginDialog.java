package com.bitcode.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {

    private EditText edtUsername,edtPassword;
    private Button btnSignIn;

    public interface OnLoginListener{
        void onSuccess();
        void onFail();
    }

    private OnLoginListener onLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener){
        this.onLoginListener = onLoginListener;
    }

    public LoginDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.login_dialog);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new BtnSignInClickListener());
    }

    private class BtnSignInClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            if (edtUsername.getText().toString().equals("bitcode") &&
            edtPassword.getText().toString().equals("bitcode123")){
                //makeToast("Login Successful");
                //Log.e("tag","Login Successful");
                onLoginListener.onSuccess();
                 dismiss();
            }else{
                //makeToast("Login Failed");
                //Log.e("tag","Login Failed");
                onLoginListener.onFail();
            }
        }
    }

    private void makeToast(String text){
        Toast.makeText(getContext(),text,Toast.LENGTH_LONG).show();
    }
}
