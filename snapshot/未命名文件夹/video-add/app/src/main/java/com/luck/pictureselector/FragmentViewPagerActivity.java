package com.luck.pictureselector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by toplu1015 on 2018/4/25.
 */

public class FragmentViewPagerActivity extends FragmentActivity {

    private TextView geren;
    private LinearLayout gerenLine;
    private TextView tuanti;
    private LinearLayout tuantiLine;
    private ViewPager viewPager;

    private ArrayList<Fragment> fragments = new ArrayList<android.support.v4.app.Fragment>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        geren = (TextView) findViewById(R.id.geren);
        gerenLine = (LinearLayout) findViewById(R.id.geren_line);
        tuanti = (TextView) findViewById(R.id.tuanti);
        tuantiLine = (LinearLayout) findViewById(R.id.tuanti_line);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        initAdapter();
        initOperation();
    }

    private void initAdapter() {
        viewPager.setCurrentItem(GO_OUT);
        fragments.add(new FragmentPerson());
        fragments.add(new FragmentTeam());
        FragmentManager fm = getSupportFragmentManager();
        MyPagerAdapter adapter = new MyPagerAdapter(fm);
        viewPager.setAdapter(adapter);
    }

    private void initOperation() {
        geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuantiLine.setVisibility(View.GONE);
                gerenLine.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(GO_OUT);
            }
        });

        tuanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuantiLine.setVisibility(View.VISIBLE);
                gerenLine.setVisibility(View.GONE);
                viewPager.setCurrentItem(HUOMIAN);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int pos) {
                switch (pos) {
                    case HUOMIAN:
                        viewPager.setCurrentItem(HUOMIAN);
                        tuantiLine.setVisibility(View.VISIBLE);
                        gerenLine.setVisibility(View.GONE);
                        break;
                    case GO_OUT:
                        tuantiLine.setVisibility(View.GONE);
                        gerenLine.setVisibility(View.VISIBLE);
                        viewPager.setCurrentItem(GO_OUT);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 两个Fragment的Aadapter
     */
    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }

    private static final int GO_OUT = 0;
    private static final int HUOMIAN = 1;

}
