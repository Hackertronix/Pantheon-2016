package com.execube.elantra.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.execube.elantra.R;
import com.execube.elantra.receiver.customHandler;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.pushbots.push.Pushbots;

import io.fabric.sdk.android.Fabric;

public class PantheonSwag extends AppCompatActivity {

    private KenBurnsView swag;
    private Button activate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantheon_swag);

        Fabric.with(this, new Crashlytics());

        Pushbots.sharedInstance().init(this);

        Pushbots.sharedInstance().setCustomHandler(customHandler.class);


        swag=(KenBurnsView)findViewById(R.id.swag);
        activate=(Button)findViewById(R.id.activate);
        if(Build.VERSION.SDK_INT>=21) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
        }





        AccelerateDecelerateInterpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();
        RandomTransitionGenerator generator = new RandomTransitionGenerator(6000, ACCELERATE_DECELERATE);
        swag.setTransitionGenerator(generator); //set new transition on kenburns view

        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PantheonSwag.this,SelectionPage.class);
                startActivity(intent);
            }
        });
    }
}
