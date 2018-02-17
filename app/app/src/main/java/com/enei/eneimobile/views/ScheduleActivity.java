package com.enei.eneimobile.views;

import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.enei.eneimobile.R;
import com.enei.eneimobile.utils.Constants;
import com.enei.eneimobile.utils.DialogHelper;
import com.enei.eneimobile.views.adapters.SchedulePageAdapter;
import com.enei.eneimobile.views.fragments.Day1Fragment;
import com.enei.eneimobile.views.fragments.Day2Fragment;
import com.enei.eneimobile.views.fragments.Day3Fragment;
import com.enei.eneimobile.views.fragments.Day4Fragment;

public class ScheduleActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        setupViewPager();
        //mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setBackgroundColor(Constants.BACKGROUND_DARK_BLUE);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        Constants.appContext = this;
    }

    private void setupViewPager() {
        SchedulePageAdapter adapter = new SchedulePageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Day1Fragment());
        adapter.addFragment(new Day2Fragment());
        adapter.addFragment(new Day3Fragment());
        adapter.addFragment(new Day4Fragment());
        mViewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.schedule_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.schedule_help:
                showHelpDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showHelpDialog() {
        DialogHelper.showOkDialog(this, "Clica nas palestras ou workshops anunciados para acederes a mais informações.");
    }
}
