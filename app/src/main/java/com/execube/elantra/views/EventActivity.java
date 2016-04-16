package com.execube.elantra.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.execube.elantra.R;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */
public class EventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity);

        FragmentManager fragmentManager= getSupportFragmentManager();
        Fragment fragment= fragmentManager.findFragmentById(R.id.viewpager_container);

        if(fragment==null)
        {
            fragment=new ViewPagerFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.viewpager_container,fragment)
                    .commit();

        }
    }
}
