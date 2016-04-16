package com.execube.elantra.views;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.execube.elantra.R;
import com.execube.elantra.receiver.customHandler;
import com.pushbots.push.Pushbots;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */
public class SelectionPage extends AppCompatActivity{

    private Button mEventsButton;
    private Button mAlertsButton;
    private Button mAboutButton;
    private Button mDirectionsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.selection_page);



        mEventsButton=(Button)findViewById(R.id.events_button);
        mAboutButton=(Button)findViewById(R.id.about_button);
        mAlertsButton=(Button)findViewById(R.id.alerts_button);
        mDirectionsButton=(Button)findViewById(R.id.directions_button);





        if(Build.VERSION.SDK_INT!=21)
        {
            Typeface gothamRoundedMedium= Typeface.createFromAsset(getAssets(),"fonts/Gotham-Rounded-Medium.ttf");
            mEventsButton.setTypeface(gothamRoundedMedium);
            mAboutButton.setTypeface(gothamRoundedMedium);
            mDirectionsButton.setTypeface(gothamRoundedMedium);
            mAlertsButton.setTypeface(gothamRoundedMedium);


        }

            if(Build.VERSION.SDK_INT>=21)
            {
                getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            }
            mEventsButton.setTextColor(getResources().getColor(R.color.colorPrimary));
            mAboutButton.setTextColor(getResources().getColor(R.color.colorPrimary));
            mDirectionsButton.setTextColor(getResources().getColor(R.color.colorPrimary));
            mAlertsButton.setTextColor(getResources().getColor(R.color.colorPrimary));



        mEventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SelectionPage.this,EventActivity.class);

                startActivity(intent);
            }
        });


        mDirectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = "http://maps.google.com/maps?q=loc:" + "12.9021902" + "," + "77.518582" + " (" + "RNS Institute Of Technlogy" + ")";
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                startActivity(intent);
            }
        });

        mAlertsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SelectionPage.this,AlertsActivity.class);
                startActivity(intent);
            }
        });

        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SelectionPage.this,AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}
