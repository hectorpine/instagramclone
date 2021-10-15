package com.portfolio.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseException;
import com.parse.SignUpCallback;

public class ParseApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("3d3Me75XT22HqtkMLOvupf8Y41wmHfMAXwL2YH6f")
                .clientKey("I6mz5qT0V1YJoC87IBwYfOP5QHL4b5esHyLqNmld")
                .server("https://parseapi.back4app.com")
                .build());

    }


}
