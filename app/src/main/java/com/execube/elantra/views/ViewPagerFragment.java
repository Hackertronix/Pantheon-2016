package com.execube.elantra.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.execube.elantra.R;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */
public class ViewPagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_viewpager,container,false);

        ViewPager viewPager= (ViewPager) view.findViewById(R.id.viewPager);
        TabLayout tabLayout= (TabLayout)view.findViewById(R.id.tabLayout);

        final Day1Fragment day1Fragment= new Day1Fragment();
        final Day2Fragment day2Fragment= new Day2Fragment();

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position==0?day1Fragment:day2Fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position==0?"DAY 1":"DAY 2";
            }
        });


        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
