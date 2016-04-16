package com.execube.elantra.views;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.execube.elantra.R;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */public class AboutActivity extends AppCompatActivity {

    private TextView mMeHeader;
    private TextView mKrupaHeader;
    private TextView mMeDesc;
    private TextView mKrupaDesc;

    private Button mForkButton;

    private ImageView mMeMailButton;
    private ImageView mKrupaMailButton;

    private ImageView mMeTwitter;
    private ImageView mKrupaTwitter;
    private ImageView mGitHub;

    private TextView mHeaderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        mMeHeader = (TextView) findViewById(R.id.me_header);
        mMeDesc = (TextView) findViewById(R.id.me_name);
        mKrupaHeader = (TextView) findViewById(R.id.krupa_header);
        mKrupaDesc = (TextView) findViewById(R.id.krupa_name);
        mHeaderText = (TextView) findViewById(R.id.header_text_view);
        mMeMailButton = (ImageView) findViewById(R.id.me_mail);
        mKrupaMailButton = (ImageView) findViewById(R.id.krupa_email);
        mMeTwitter = (ImageView) findViewById(R.id.me_twitter);
        mKrupaTwitter = (ImageView) findViewById(R.id.krupa_twiiter);
        mGitHub = (ImageView) findViewById(R.id.gitimage);

        if (Build.VERSION.SDK_INT != 21) {


            Typeface robotoMonoRegular = Typeface.createFromAsset(getAssets(), "fonts/RobotoMono-Regular.ttf");
            Typeface robotoMonoMedium = Typeface.createFromAsset(getAssets(), "fonts/RobotoMono-Medium.ttf");

            mMeHeader.setTypeface(robotoMonoRegular);
            mMeDesc.setTypeface(robotoMonoMedium);
            mKrupaHeader.setTypeface(robotoMonoRegular);
            mKrupaDesc.setTypeface(robotoMonoMedium);
            mHeaderText.setTypeface(robotoMonoMedium);

        }


        mHeaderText.setTextColor(getResources().getColor(R.color.colorHeaderText));

        mMeHeader.setTextColor(getResources().getColor(R.color.colorTextTitle));
        mMeDesc.setTextColor(getResources().getColor(R.color.colorTextTitle));
        mKrupaHeader.setTextColor(getResources().getColor(R.color.colorTextTitle));
        mKrupaDesc.setTextColor(getResources().getColor(R.color.colorTextTitle));


        mMeTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("twitter://user?screen_name=hackertronix"));
                    startActivity(intent);

                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://twitter.com/#!/hackertronix")));
                }
            }
        });


        mKrupaTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("twitter://user?screen_name=krupahebbar"));
                    startActivity(intent);

                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://twitter.com/#!/krupahebbar")));
                }
            }
        });

        mMeMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("mailto:leavethemails@gmail.com")
                );
                startActivity(intent);
            }
        });


        mKrupaMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("mailto:krupa.hebbar@gmail.com")
                );
                startActivity(intent);
            }
        });


        mGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Hackertronix/Pantheon-2016"));
                startActivity(intent);
            }
        });


    }
}
