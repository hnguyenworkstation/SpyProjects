package com.spyprojects.spyo;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.spyprojects.spyo.Fragments.AroundFragment;
import com.spyprojects.spyo.Fragments.MainStateFragment;
import com.spyprojects.spyo.Fragments.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends SpyoActivity
    implements MainStateFragment.OnFragmentInteractionListener,
        AroundFragment.OnFragmentInteractionListener,
        MessageFragment.OnFragmentInteractionListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int tabIcons[] = {
            R.drawable.ic_all_out,
            R.drawable.ic_camera,
            R.drawable.ic_chat
    };

    private int sTabIcons[] = {
            R.drawable.ic_all_out_s,
            R.drawable.ic_camera_s,
            R.drawable.ic_chat_s
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainStateFragment());
        adapter.addFragment(new AroundFragment());
        adapter.addFragment(new MessageFragment());
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

    }

    private void setupSelectedTabIcons() {
        int temp = tabLayout.getSelectedTabPosition();
        switch (temp) {
            case 0:
                tabLayout.getTabAt(0).setIcon(sTabIcons[0]);
                break;
            case 1:
                tabLayout.getTabAt(1).setIcon(sTabIcons[1]);
                break;
            case 2:
                tabLayout.getTabAt(2).setIcon(sTabIcons[2]);
                break;
            default:
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
