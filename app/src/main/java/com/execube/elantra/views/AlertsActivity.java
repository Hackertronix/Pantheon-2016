package com.execube.elantra.views;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.execube.elantra.R;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */
public class AlertsActivity extends AppCompatActivity {

    private static final String TAG = "AlertActivity";
    private TextView mAlertHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        mAlertHeader=(TextView)findViewById(R.id.alert_header_text_view);


        if (Build.VERSION.SDK_INT != 21) {
            Typeface robotoMonoMedium= Typeface.createFromAsset(getAssets(),"fonts/RobotoMono-Medium.ttf");
            mAlertHeader.setTypeface(robotoMonoMedium);
        }


        mAlertHeader.setTextColor(getResources().getColor(R.color.colorHeaderText));

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.alert_list_container);

        if (fragment == null) {
            fragment = new AlertFragment();
            fragmentManager.beginTransaction().add(R.id.alert_list_container, fragment).commit();

        }
    }
}
