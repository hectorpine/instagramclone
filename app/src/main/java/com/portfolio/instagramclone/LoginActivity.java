package com.portfolio.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private EditText etName;
    private EditText etPasscode;
    private EditText etEmail;
    private Button btnSignup;
    private ParseUser newUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null) {
            goMainActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        newUser = new ParseUser();
        etName = findViewById(R.id.etName);
        etPasscode = findViewById(R.id.etPasscode);
        etEmail = findViewById(R.id.etEmail);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick login button");
                String username = etName.getText().toString();
                String password = etPasscode.getText().toString();
                String email = etEmail.getText().toString();

                newUser.setUsername(etName.getText().toString());
                newUser.setPassword(etPasscode.getText().toString());
                newUser.setEmail(etEmail.getText().toString());

                signupUser(newUser);

            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username,password);
            }
        });
    }



    private void loginUser(String username, String password) {
        Log.i(TAG,"aTTEMPTING TO LOGIN USER " + username);
        //TODO: navigate to the main activity if the  user has signed in properly
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                 if( e != null) {
                     Log.e(TAG, "Issue with login",e);
                     Toast.makeText(LoginActivity.this,"Issue with login!",Toast.LENGTH_SHORT).show();
                     return;
                 }
                 goMainActivity();
                 Toast.makeText(LoginActivity.this,"Success!",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void signupUser(ParseUser newUser) {

        Log.i(TAG,"aTTEMPTING TO signup USER " );
        newUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
           // goMainActivity();
            }

        });


    }


    private void goMainActivity() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }


}
