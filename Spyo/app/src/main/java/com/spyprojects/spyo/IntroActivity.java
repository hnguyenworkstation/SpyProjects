package com.spyprojects.spyo;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IntroActivity extends SpyoActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private Button registerBtn;
    private Button loginBtn;
    private List<View> introList;
    private ImageView[] imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // Translucent navigation bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        introList = new ArrayList<>();
        introList.add(getLayoutInflater().inflate(R.layout.intro_slice1, null));
        introList.add(getLayoutInflater().inflate(R.layout.intro_slice1, null));
        introList.add(getLayoutInflater().inflate(R.layout.intro_slice1, null));

        imageViews = new ImageView[introList.size()];
        LinearLayout layout = (LinearLayout) findViewById(R.id.viewGroup);
        for (int i = 0; i < introList.size(); i++) {
            imageViews[i] = new ImageView(IntroActivity.this);
            if (0 == i) {
                imageViews[i].setBackgroundResource(R.drawable.ic_dot_select);
            } else {
                imageViews[i].setBackgroundResource(R.drawable.ic_dot_normal);
            }
            imageViews[i].setPadding(10, 10, 10, 10);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMarginStart(10);
            lp.setMarginEnd(10);
            imageViews[i].setLayoutParams(lp);
            layout.addView(imageViews[i]);
        }

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        registerBtn = (Button) findViewById(R.id.intro_reg_btn);
        registerBtn.setOnClickListener(this);
        loginBtn = (Button) findViewById(R.id.intro_login_btn);
        loginBtn.setOnClickListener(this);

        viewPager.setAdapter(new ViewPagerAdapter(introList));
        viewPager.setOnPageChangeListener(new ViewPagerPageChangeListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intro_login_btn:
                Intent temp = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(temp);
                break;
            case R.id.intro_reg_btn:
                Intent temp1 = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(temp1);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    class ViewPagerPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int state) {
        }

        @Override
        public void onPageScrolled(int page, float positionOffset,
                                   int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int page) {
            for (int i = 0; i < introList.size(); i++) {
                if (page == i) {
                    imageViews[i].setBackgroundResource(R.drawable.ic_dot_select);
                } else {
                    imageViews[i].setBackgroundResource(R.drawable.ic_dot_normal);
                }
            }
        }
    }

    class ViewPagerAdapter extends PagerAdapter {
        private List<View> list = null;
        public ViewPagerAdapter(List<View> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

    }
}
