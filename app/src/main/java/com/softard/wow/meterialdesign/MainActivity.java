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
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import com.softard.wow.meterialdesign.recyclers.RecyclerFragment1;
import com.softard.wow.meterialdesign.recyclers.StaggeredRecyclerFragment;

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

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                if (tab.getText().equals("Linear")) {
                    fragment = new RecyclerFragment1();
                } else {
                    fragment = new StaggeredRecyclerFragment();
                }
                mFragmentManager.beginTransaction().replace(R.id.drawer_frame, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navi_recycler:
                manageTabs(TabType.TYPE_RECYCLER);
//                mTabLayout.setVisibility(View.VISIBLE);
//                mTabLayout.removeAllTabs();

//                mTabLayout.addTab(mTabLayout.newTab().setText("Linear"));
//                mTabLayout.addTab(mTabLayout.newTab().setText("Staggered"));
//                mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                    @Override
//                    public void onTabSelected(TabLayout.Tab tab) {
//                        Fragment fragment = null;
//                        if (tab.getText().equals("Linear")) {
//                            fragment = new RecyclerFragment1();
//                        } else {
//                            fragment = new StaggeredRecyclerFragment();
//                        }
//                        mFragmentManager.beginTransaction().replace(R.id.drawer_frame, fragment).commit();
//                    }
//
//                    @Override
//                    public void onTabUnselected(TabLayout.Tab tab) {
//
//                    }
//
//                    @Override
//                    public void onTabReselected(TabLayout.Tab tab) {
//
//                    }
//                });
//                mTabLayout.getTabAt(0).select();



                break;
            default:break;
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    enum TabType {
        TYPE_RECYCLER;
    }

    private void manageTabs(TabType type) {
        mTabLayout.setVisibility(View.GONE);
        mTabLayout.removeAllTabs();
        switch (type) {
            case TYPE_RECYCLER:
                mTabLayout.addTab(mTabLayout.newTab().setText("Linear"));
                mTabLayout.addTab(mTabLayout.newTab().setText("Staggered"));
                mTabLayout.getTabAt(0).select();

                mTabLayout.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

}
