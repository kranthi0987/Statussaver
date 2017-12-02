package com.sanjay.statussaver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Splash_activity extends AppCompatActivity {
    PermissionListener permissionlistener;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);
        Log.d("splash", "onCreate: ");
//        if (Build.VERSION.SDK_INT >= 23) {
//            checkPerm();
//            return;
//        }

        Timer t = new Timer();
        boolean checkConnection=new ApplicationUtility().checkConnection(this);
        if (checkConnection) {
            t.schedule(new splash(), 3000);
        } else {
            Toast.makeText(Splash_activity.this,
                    "connection not found...plz check connection", 3000).show();
        }
    }
    private void checkPerm() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(Splash_activity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(Splash_activity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }


        };
    }

    class splash extends TimerTask {

        @Override
        public void run() {
            Intent i = new Intent(Splash_activity.this,MainActivity.class);
            finish();
            startActivity(i);
        }

    }





}
