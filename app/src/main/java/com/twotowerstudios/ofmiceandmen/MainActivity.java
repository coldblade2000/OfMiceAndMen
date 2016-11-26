package com.twotowerstudios.ofmiceandmen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentPagerAdapter adapterViewPager;

    LinearLayout llMainHeader, llLogo;
    ImageView ivLogo;

    ViewPager vpPager;
    public static int publicCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Created by Diego Granada (TTS)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        llMainHeader = (LinearLayout) findViewById(R.id.llMainHeader);
        llLogo = (LinearLayout) findViewById(R.id.llLogo);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int actionBarSize = android.R.attr.actionBarSize;

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) llMainHeader.getLayoutParams();
        params.height = (int) Math.round(metrics.widthPixels*0.6666);
        //llMainHeader.getLayoutParams().height = (int) Math.round(metrics.widthPixels*0.5625+(metrics.widthPixels/6));
        /**llMainHeader.getLayoutParams().height = (int) Math.round(metrics.widthPixels*0.666);
        llMainHeader.requestLayout();*/
        //Log.v("MainActivity", "MainHeader height = " + (int) Math.round(metrics.widthPixels*0.5625));
        //Log.v("MainActivity", "MainHeader height-actionbar = " + (int) Math.round(metrics.widthPixels*0.5625-actionBarSize));
        llMainHeader.setLayoutParams(params);

        ivLogo.getLayoutParams().height = (int) Math.round(metrics.widthPixels / 3);
        ivLogo.getLayoutParams().width = (int) Math.round(metrics.widthPixels / 3);
        //ivLogo.getLayoutParams().

        vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        setTitle("Lennie");
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        /**llMainHeader.getLayoutParams().height = (int) Math.round(metrics.widthPixels*0.666);
        llMainHeader.requestLayout();*/
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) llMainHeader.getLayoutParams();
        params.height = (int) Math.round(metrics.widthPixels*0.4);
        llMainHeader.setLayoutParams(params);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /**
         * 0 = Lennie
         * 1 = George
         * 2 = Curley
         * 3 = Curley's wife
         * 4 = Candy
         */
        if (id == R.id.nav_lennie) {
            publicCharacter = 0;
            DescriptionFragment.elvDescription.invalidateViews();
            DescriptionFragment.prepareExpandableListData(publicCharacter);
            KeywordsFragment.adapter.notifyDataSetChanged();
            vpPager.getAdapter().notifyDataSetChanged();
            ivLogo.setImageResource(R.drawable.lennie);
            setTitle("Lennie");

        } else if (id == R.id.nav_george) {
            publicCharacter = 1;
            DescriptionFragment.elvDescription.invalidateViews();
            DescriptionFragment.prepareExpandableListData(publicCharacter);
            KeywordsFragment.adapter.notifyDataSetChanged();
            vpPager.getAdapter().notifyDataSetChanged();
            ivLogo.setImageResource(R.drawable.george);
            setTitle("George");

        } else if (id == R.id.nav_curley) {
            DescriptionFragment.elvDescription.invalidateViews();
            DescriptionFragment.prepareExpandableListData(2);
            publicCharacter = 2;
            KeywordsFragment.adapter.notifyDataSetChanged();
            vpPager.getAdapter().notifyDataSetChanged();
            ivLogo.setImageResource(R.drawable.curley);
            setTitle("Curley");
        } else if (id == R.id.nav_curleyswife) {
            DescriptionFragment.elvDescription.invalidateViews();
            DescriptionFragment.prepareExpandableListData(3);
            publicCharacter = 3;
            KeywordsFragment.adapter.notifyDataSetChanged();
            vpPager.getAdapter().notifyDataSetChanged();
            ivLogo.setImageResource(R.drawable.curleywife);
            setTitle("Curley's wife");
        } else if (id == R.id.nav_Candy) {
            DescriptionFragment.elvDescription.invalidateViews();
            DescriptionFragment.prepareExpandableListData(4);
            publicCharacter = 4;
            KeywordsFragment.adapter.notifyDataSetChanged();
            vpPager.getAdapter().notifyDataSetChanged();
            ivLogo.setImageResource(R.drawable.candy);
            setTitle("Candy");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return DescriptionFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return KeywordsFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return QuotesFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }
        public int getItemPosition(Object object){
            return POSITION_NONE;
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {

            String [] titlesArray = new String[]{"Description", "Keywords", "Quotes"};
            return titlesArray [position];
        }

    }


}
