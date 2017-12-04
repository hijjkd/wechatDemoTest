package com.liunan.wechatdemotest;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.text.UnicodeSetSpanner;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mDatas;

    private TextView mMessageTextView;
    private TextView mContactTextView;
    private TextView mMyInfoTextView;
    private TextView mName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        resetTextView();
    }


    //初始化所有控件
    private  void  initView(){
        mViewPager =  findViewById(R.id.id_viewpager);
        mMessageTextView=findViewById(R.id.id_tv_message);
        mContactTextView=findViewById(R.id.id_tv_contact);
        mMyInfoTextView=findViewById(R.id.id_tv_myinfo);
        mDatas = new ArrayList<Fragment>();
        MessageMainTabFragment tab01 = new MessageMainTabFragment();
        ContactMainTabFragment tab02 = new ContactMainTabFragment();
        MyInfoMainTabFragment tab03  = new MyInfoMainTabFragment();

        mDatas.add(tab01);
        mDatas.add(tab02);
        mDatas.add(tab03);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int arg0) {
                return mDatas.get(arg0);
            }

            @Override
            public int getCount() {
               return mDatas.size();
            }
        };
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTextView();
                switch (position){
                    case 0:
                        mMessageTextView.setTextColor(Color.parseColor("#008000"));
                        //mMessageTextView.setBackgroundColor(Color.GRAY);
                        break;
                    case 1:
                        mContactTextView.setTextColor(Color.parseColor("#008000"));
                        break;
                    case 2:
                        mMyInfoTextView.setTextColor(Color.parseColor("#008000"));
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    protected void resetTextView()
    {
        mMessageTextView.setTextColor(Color.BLACK);
        mMyInfoTextView.setTextColor(Color.BLACK);
        mContactTextView.setTextColor(Color.BLACK);
    }















}
