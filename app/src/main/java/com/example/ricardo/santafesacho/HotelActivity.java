package com.example.ricardo.santafesacho;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import android.widget.TextView;

public class HotelActivity extends AppCompatActivity {

    String username, correo, password;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        Bundle extras= getIntent().getExtras();
        username = extras.getString("username");
        correo = extras.getString("correo");
        password = extras.getString("password");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hotel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        switch (id) {
            case R.id.mPerfil:
                Intent intent = new Intent(HotelActivity.this, PerfilActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                intent.putExtra("password",password);
                startActivity(intent);
                finish();
                break;
            case R.id.mLogOut:
                intent = new Intent(HotelActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mMain:
                intent = new Intent(HotelActivity.this, MainActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                intent.putExtra("password",password);
                startActivity(intent);
                finish();
                break;
            case R.id.mLugares:
                intent = new Intent(HotelActivity.this, LugaresActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                intent.putExtra("password",password);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent = new Intent(HotelActivity.this, RestaurantesActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                intent.putExtra("password",password);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                /*intent = new Intent(BaresActivity.this, MotelesActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();*/
                break;
        }

        return true;
        //return super.onOptionsItemSelected(item);
    }

    /*
     * A placeholder fragment containing a simple view.
*/
    public static class PlaceholderFragment extends Fragment {

  /*       * The fragment argument representing the section number for this
         * fragment.
*/
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

/*
         * Returns a new instance of this fragment for the given section
         * number.
*/
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_hotel, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            switch (position){

                case 0:
                    HotelUnoFragment tab1 = new HotelUnoFragment();
                    return tab1;
                case 1:
                    HotelDosFragment tab2 = new HotelDosFragment();
                    return tab2;
                case 2:
                    HotelTresFragment tab3 = new HotelTresFragment();
                    return tab3;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Hotel Colonial";
                case 1:
                    return "Hotel Mariscal Robledo";
                case 2:
                    return "Hotel Porton Del Sol";
            }
            return null;
        }
    }
}
