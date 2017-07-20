package com.softard.wow.meterialdesign;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import com.softard.wow.meterialdesign.recyclers.RecyclerFragment1;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;
    @BindView(R.id.drawer_navi) NavigationView mNavi;
    @BindView(R.id.drawer_frame) FrameLayout mFrameLayout;
    @BindView(R.id.drawer_toolbar) Toolbar mToolbar;
    @BindView(R.id.drawer_tab) TabLayout mTabLayout;
    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar,
                R.string.drawer_open_desc, R.string.drawer_close_desc);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavi.setNavigationItemSelectedListener(this);
        mFragmentManager = getFragmentManager();
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
//        RecyclerFragment1 fragment = new PlanetFragment();
        Bundle args = new Bundle();
//        args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
//        fragment.setArguments(args);

        mFragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.drawer_frame, fragment).commit();

        // update selected item and title, then close the drawer
//        mDrawerList.setItemChecked(position, true);
//        setTitle(mPlanetTitles[position]);
//        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navi_recycler:
                Log.d("DBW", "start navi");
                RecyclerFragment1 fragment = new RecyclerFragment1();
                mFragmentManager.beginTransaction().replace(R.id.drawer_frame, fragment).commit();
                break;
            default:break;
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
