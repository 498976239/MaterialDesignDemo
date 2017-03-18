package com.materialdesigndemo.www.materialdesigndemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.materialdesigndemo.www.materialdesigndemo.Adapter.TalLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> list;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("数据"+i);
        }
        TalLayoutAdapter adapter = new TalLayoutAdapter(getSupportFragmentManager(),list);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//将actionBar替换成toolbar
        /*为了使DrawerLayout和ToolBar连用，让ToolBar上面有点动画，就要以下几步，顺序很重要*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//该条语句要放在setSupportActionBar(toolbar)后
        //记住不要写成了getActionBar()；
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);//将DrawerLayou取出
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);//显示左侧图标
        drawerLayout.addDrawerListener(toggle);//设置监听
        toggle.syncState();//同步
        navigationView = (NavigationView) findViewById(R.id.navigation);
        /*设置监听事件*/
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.item_1:
                        finish();
                    break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
