package com.portfolio.instagramclone;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.portfolio.instagramclone.fragments.ComposeFragment;
import com.portfolio.instagramclone.fragments.PostsFragment;
import com.portfolio.instagramclone.fragments.ProfileFragment;

import java.io.File;
import java.util.List;

import static com.google.android.material.bottomnavigation.BottomNavigationView.*;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    final FragmentManager fragmentManager = getSupportFragmentManager();
    private SwipeRefreshLayout swipeContainer;

    private BottomNavigationView bottomNavigationView;

    ActivityResultLauncher<Intent> activityResultLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

       /* swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Fragment fragment = new PostsFragment();
            }
        });

        */



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                       // Toast.makeText(MainActivity.this,"Home!",Toast.LENGTH_SHORT).show();
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                       // Toast.makeText(MainActivity.this,"Compose!",Toast.LENGTH_SHORT).show();
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                    default:
                       // Toast.makeText(MainActivity.this,"Profile!",Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }





}