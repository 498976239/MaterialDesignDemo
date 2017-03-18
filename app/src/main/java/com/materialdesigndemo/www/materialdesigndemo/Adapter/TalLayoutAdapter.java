package com.materialdesigndemo.www.materialdesigndemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.materialdesigndemo.www.materialdesigndemo.MaterialDesignFragment;

import java.util.List;

/**
 * Created by SS on 16-12-12.
 */
public class TalLayoutAdapter extends FragmentPagerAdapter {
    private List<String> title;
    public TalLayoutAdapter(FragmentManager fm, List<String> title) {
        super(fm);
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return MaterialDesignFragment.newInstance(title.get(position));
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
