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
public class Day1Fragment extends Fragment {


    //ADD DAY 2 EVENT NAMES IN THIS ARRAY IN ORDER
    private static String day1events[]={"Vocal light music group","Instrumental","Movie clip recreation","Western Group Dance","Indian Group Dance", "RAMP", "Techcharades","Karaoke","Web designing","Online treasure hunt", "Rangoli", "On spot photography"
            , "Slow drag", "Kannada dumb charades","Kannada anthyakshari", "Gaanchaali bidi kannada maathaadi",
            "Vocal classical music solo prelims", "Vocal light music solo prelims","Antichess", "Mini Militia", "FIFA", "Counterstrike"};



    // ADD DAY 1 EVENT DESCRIPTION IN THIS ARRAY IN ORDER

    private  static  String[] day1description ={"6 in team. Maximum 2 entries per college. Karaoke allowed. Filmic and non-filmic allowed. Original composition allowed"
            ,"Western and eastern music.4+1 min.1 accomplishment allowed.unlimited enteries.no backing track allowed.",
            "6 in team. 2-minute video clip will be provided. 5+2 minute is given to recreate. Most comic scene will be rewarded. No vulgarity",
            "6+6 in a team. 5+2 minutes is given. Carry ID card. Report 2 hours prior to event",
            "8+4 in a team. 5+3 minutes is given. Any theme is allowed. Report 2 hours prior to the event. Should submit a video of their prior performances",
            "Open theme. 12+2 in a team. 6+2 minutes is given. Report 3 hours before event. Carry ID cards. Audio track to be given 1 hour in prior. No use of water, fire, pet, animal skin.",
            "3 in team. Tech version of dumb charades. 1 member mimes other 2 guesses. Multiple rounds",
            "Solo event. Western instruments to be used.  5+1 minute is given. 2 rounds. 6 contestants will be shortlisted to 2nd round",
            "2 in team. 3-hour time is given. Systems will be provided",
            "2 in team. First round is written. Second round is on computer. Google imaging NOT allowed",
            "Individual event. 1 hour is given. Colors and rangoli powder will be provided",
            "Individual event. Topic is given on-spot. 2-hour time is given. Photos to be taken at RNSIT. On board editing allowed (Photoshop/post-processing not allowed)",
            "Carry your own bikes (boys) and scooty (girls). Last one reaching the line wins. Multiple rounds",
            "3 in team. Standard dumb charades rules apply. No speaking. 1 will mime other 2 guess",
            "Team of 2 members wherein the prelims will be written round. Top scoring teams will be selected for finals. Coordinator's decision is final",
            "It's a solo event where the topic will be given on the spot. 5 min preparation time. Speak in Kannada for 2 min but the timer stops as soon as you omit a Non-Kannada word. Judge's decision is final",
            "Solo event. Time limit of 2+1 min. Any form of Hindustani or Carnatic classical music. No karaoke. 15 singers shall move on to the 2nd round",
            "Solo event.  Time limit of 2+1 min. No karaoke. Indian or non-filmic song can be sung. No Western music. Top 15 singers shall move on to second round. Indian filmic or non-filmic songs can be sung",
            "Solo event wherein standard rules of anti-chess apply. Matches are knockout. Time limit may or may not be present, depending on the event coordinator",
            "Team consisting of 4 members. Match duration is 7 min. Team with maximum wins after allotted time will proceed. It will be direct elimination. Unlimited entries for the event",
            "Solo event with difficulty level being legendary, 4mins per half. Elimination based on number of goals scored per team. Penalty shootout in case of a draw. No time will be allotted for practicing. Gamers can get their own joysticks and keyboards",
            "Team of 5 members. Round will be a race to 5 wins in the 1000$ map. Direct elimination. Consequent rounds will be on de_dust2, de_train and de_inferno. No practice session. Gamers can get their own Mouse or joystick"};



    //ADD DAY 1 EVENT TMINGS IN 24 HR FORMAT IN ORDER


    private static String day1timings[]={"10:00","11:00","12:00","14:00",
            "14:00","17:00","9:00","11:00",
            "10:00","10:00","9:00","10:00",
            "11:00","9:00","11:00","13:00",
            "9:00","9:00","9:00","9:00",
            "9:00","9:00"};



    //ADD DAY 1 VENUES IN THIS ARRAY IN ORDER
    private String day1venue[]={"Main stage", "Main stage", "Main stage", "Main stage",
            "Main stage", "Main stage", "Edusat hall", "Edusat hall",
            "EEE lab", "Mech Lab", "Street", "Street", "Street",
            "CS/IS block", "CS/IS block", "CS/IS block", "EC block lvl1","EC block lvl1","MCA/CS/IS lab", "MCA/CS/IS lab", "MCA/CS/IS lab", "MCA/CS/IS lab"};



    private String[] day1coordinator_no= {"9448260823", "7411179295", "9902643437", "9060991914",
            "9886080813", "9611831671", "9986464852", "8971205200",
            "9686684184", "805062998", "9980764095", "9448131963",
            "8792329243", "9739310656", "9739310656", "9739310656",
            "7022153497", "8722580150", "9880833798", "8884834111", "8277024701", "8904471865"};







    private ArrayList<Events> mEvents;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        mEvents=new ArrayList<>();
        for(int i=0;i<day1events.length;i++)
        {
            Events event= new Events();

            event.setFavourite(false);
            event.setEvent(day1events[i]);
            event.setDetails(day1description[i]);
            event.setVenue(day1venue[i]);
            event.setPhoneNumber(day1coordinator_no[i]);
            event.setTime(day1timings[i]);

            mEvents.add(event);

        }

        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_day1,container,false);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.day1_recyclerView);

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
                Typeface robotoMonoRegular = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoMono-Regular.ttf");


                mEventTileTextView.setTypeface(robotoMonoMedium);
                mEventDetailsTextView.setTypeface(robotoMonoMedium);
                mVenueTextView.setTypeface(robotoMonoRegular);
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
