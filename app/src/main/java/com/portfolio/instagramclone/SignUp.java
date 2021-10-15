/**package com.portfolio.instagramclone;

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

public class SignUp extends AppCompatActivity {

    public static final String TAG = "Signup";
    private EditText etName;
    private EditText etPasscode;
    private EditText etEmail;

    private Button btnSignup;

    private ParseUser newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



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
    }

    private void signupUser(ParseUser newUser) {

        Log.i(TAG,"aTTEMPTING TO signup USER " );
         newUser.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {

        }
    });


    }


    private void goMainActivity() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

}
**/