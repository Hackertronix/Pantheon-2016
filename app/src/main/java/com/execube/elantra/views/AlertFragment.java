package com.execube.elantra.views;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.execube.elantra.R;

import java.util.ArrayList;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */
public class AlertFragment extends Fragment {

    private ArrayList<String> mAlerts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mAlerts=new ArrayList<>();
        SharedPreferences sharedPreferences= this.getActivity().getSharedPreferences("PantheonPreferences", Activity.MODE_PRIVATE);
        String alertsItems= sharedPreferences.getString("alerts",null);

        if(alertsItems!=null)
        {

            String[] alertList=alertsItems.split(",");

            for(int i=0;i<alertList.length;i++)
            {

                mAlerts.add(alertList[i]);
            }

        }

        else{
            mAlerts.add(alertsItems);
        }

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_alert_fragment,container,false);


        AlertAdapter mAdapter= new AlertAdapter();

        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.alert_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

        return view;
    }



    private class AlertViewHolder extends RecyclerView.ViewHolder{

        private TextView alertText;

        public AlertViewHolder(View itemView) {
            super(itemView);

            alertText=(TextView)itemView.findViewById(R.id.alert_textview);


            if (Build.VERSION.SDK_INT != 21) {
                Typeface robotoMonoRegular = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoMono-Regular.ttf");
                alertText.setTypeface(robotoMonoRegular);
            }

            alertText.setTextColor(getResources().getColor(R.color.colorTextTitle));

        }
    }

    private class AlertAdapter extends RecyclerView.Adapter<AlertViewHolder>{


        @Override
        public AlertViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(getActivity()).inflate(R.layout.alert_item,parent,false);

            return new AlertViewHolder(view);
        }

        @Override
        public void onBindViewHolder(AlertViewHolder holder, int position) {

            final String alert= mAlerts.get(position);
            if(alert!=null)
            {
                holder.alertText.setText(alert);
            }

            else
                holder.alertText.setText("Nothing here yet! Check back soon...");

        }

        @Override
        public int getItemCount() {
            return mAlerts.size();
        }
    }
}




