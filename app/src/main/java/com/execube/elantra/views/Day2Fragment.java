package com.execube.elantra.views;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.execube.elantra.R;
import com.execube.elantra.model.Events;

import java.util.ArrayList;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */
public class Day2Fragment extends Fragment {

    private static String day2events[]={"Classical & Light Music Vocal Solo",
            "Beg Borrow Steal", "Air Crash",
            "Game Of Thrones Quiz","Crime Polis",
            "Solo Dance", "Sketch & Paint", "Beat The Heat",
            " Hindi Anthyakshari","Air Crash","Dumb Charades",
            "K'nataka Quiz"
            , "Concept Presentation",
            "Street Play","Bomb Diffusion",
            "Tech-Expo",
            "60 Seconds To Fame","Street Dance ","General Quiz","Band Wars"};



    // ADD DAY 2 EVENT DESCRIPTION IN THIS ARRAY IN ORDER

    private  static  String[] day2description ={ "Solo event. Time limit of 2+1 minutes. Any form of Hindustani or Carnatic classical music. No karaoke. 15 singers shall move on to the 2nd round.",
            "2 in a team. No cell phones bikes or cash allowed. Total of 10 rounds. Further rules to be explained on the spot.",
            "Team of 3 members. First round is written. Top scoring teams move to final. Quiz is about Karnataka and Kannadigas. Cash prize for top 2 teams.",
            "3 per team. Prelims consists of two rounds. Questions pertaining to Game Of Thrones TV series only (Season 1 to Season 5). Quiz master will explain the rules for finals.",
            "3 per team. Crime scene provided. Definite number of rounds wherein clues of the crime are deciphered. Team that finishes all rounds wins.",
            "Solo event. 3+1 minutes. Either western or eastern form of dance. No vulgarity.",
            "Solo event. Required materials should be brought by participants. Sheets shall be provided. On the spot topics. Duration is 90 min.",
            "Solo event. 2 rounds. No instruments allowed. Time limit is 2 minutes. Qualified participants will have beatbox sessions of 90 seconds each.",
            "3 per team. Prelims consist of four rounds where four teams will be selected. Finals consists of 3 rounds. Two winners will be rewarded.",
            "Solo event with on spot registration. Common Air Crash rules apply. Series of elimination rounds. Rules will be explained by judge.",
            "Maximum of 3 members per team. Prelims round is included. Finals for top 6 teams. Common rules for Dumb Charades apply.",
            "Team of 3 members. First round is written round. Top scoring teams move to final. Quiz is about Karnataka and Kannadigas. Cash prize for top 2 teams.",

            "Team of 2 members. Time limit of 4+2 minutes. Points rewarded for uniqueness of concept.",
            "Max 12 members per team. Time limit of 10+2 minutes. Props allowed, recorded music not allowed. Vulgarity results in disqualification.",
            "2 per team in the first round with a duration of 45 minutes. Elimination round conducted. Round 2 is diffusion where 6 teams will move on to the finals.",
            "Any type of robot is allowed. 3 per team. Best team selected based on robot and presentation.",
            "Solo event. Time limit of 1 minute. No vulgarity.",
            "Round 1 shall be a showcase round. Round 2 will be battle round. All rules of battle crew shall apply.",
            "3 per team. Prelims is a written round. Quiz master shall explain rules.",
            "3-10 in a team. 15+5 minutes(including setup) is given. No restriction on genre. 5-piece drum kit, mics, cable and amplifier will be provided."


    };



    //ADD DAY 2 EVENT TMINGS IN 24 HR FORMAT IN ORDER
    private static String day2timings[]={"09:00","09:00","09:00","09:00","09:00",
            "10:00","10:00","10:00","10:00",
            "11:00","11:00","11:00",
            "12:00","12:00","12:00","12:00",
            "13:00",
            "14:00","14:00",
            "15:00"};


    //ADD DAY 2 VENUES IN THIS ARRAY IN ORDER
    private String day2venue[]={"Main stage", "Field", "EC Block","Mech Block lvl3",
            "Main stage", "Admin Block", "Mech Block", "EEE/IT Block",
            "Main Stage", "Edusat Hall", "CS/IS Block",
            "EEE/IT block",
            "Admin Block", "Field", "Mech Block", "EC Block",
            "EEE/IT Block",
            "Mech Block","Placement Cell","Main Stage",
            "Main Stage"};


    // PLEASE VALIDATE AND ADD THE DAY 2 COORDINATOR'S NUMBER IN THIS ARRAY
    private String day2coordinatorno[] = {"7022153497", "9035491661", "9739310656", "7406659227",
            "9886299824", "9036774789", "8197334611", "9900022559",
            "9108909361", "8050421256", "7411228907", "8050421256",
            "9916807522", "8867541575", "8867840160", "9886299824",
            "9341948012", "9902215623", "9036199499", "9902643437"};







    private ArrayList<Events> mEvents;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        mEvents=new ArrayList<>();
        for(int i=0;i< day2events.length;i++)
        {
            Events event= new Events();

            event.setFavourite(false);
            event.setEvent(day2events[i]);
            event.setDetails(day2description[i]);
            event.setVenue(day2venue[i]);
            event.setPhoneNumber(day2coordinatorno[i]);
            event.setTime(day2timings[i]);

            mEvents.add(event);

        }

        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_day2,container,false);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.day2_recyclerView);

        Day1EventAdapter mAdapter= new Day1EventAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

        return view;
    }




    //VIEW HOLDER

    private class Day1ViewHolder extends RecyclerView.ViewHolder{

        private TextView mEventTileTextView;
        private TextView mEventDetailsTextView;
        private TextView mVenueTextView;
        private TextView mTimeTextView;

        private ImageView mPhoneDialerView;

        public Day1ViewHolder(View itemView) {
            super(itemView);

            mEventTileTextView = (TextView) itemView.findViewById(R.id.phoenix_title_textview);
            mEventDetailsTextView = (TextView) itemView.findViewById(R.id.event_details_text_view);
            mVenueTextView = (TextView) itemView.findViewById(R.id.venue_textview);
            mTimeTextView = (TextView) itemView.findViewById(R.id.time_textview);
            mPhoneDialerView=(ImageView)itemView.findViewById(R.id.phonedial_imageview);

            if (Build.VERSION.SDK_INT != 21) {
                Typeface robotoMonoMedium = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoMono-Medium.ttf");


                mEventTileTextView.setTypeface(robotoMonoMedium);
                mEventDetailsTextView.setTypeface(robotoMonoMedium);
                mVenueTextView.setTypeface(robotoMonoMedium);
                mTimeTextView.setTypeface(robotoMonoMedium);
            }

            mEventTileTextView.setTextColor(getResources().getColor(R.color.colorTextTitle));
            mEventDetailsTextView.setTextColor(getResources().getColor(R.color.colorTextDescription));
            mVenueTextView.setTextColor(getResources().getColor(R.color.colorTextDescription));
            mTimeTextView.setTextColor(getResources().getColor(R.color.colorTextDescription));


        }


    }
    private class Day1EventAdapter extends RecyclerView.Adapter<Day1ViewHolder>{


        @Override
        public Day1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(getActivity()).inflate(R.layout.events_item,parent,false);

            return new Day1ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final Day1ViewHolder holder, int position) {

            final Events event= mEvents.get(position);

            holder.mEventTileTextView.setText(event.getEvent());
            holder.mEventDetailsTextView.setText(event.getDetails());
            holder.mVenueTextView.setText(event.getVenue());
            holder.mTimeTextView.setText(event.getTime());



            holder.mPhoneDialerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(Intent.ACTION_DIAL);
                    String number="tel:"+event.getPhoneNumber();
                    intent.setData(Uri.parse(number));
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mEvents.size();
        }
    }

}
