package phi.redminepj.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.adapters.FragmentAdapter;
import phi.redminepj.fragment.FilterFragment;
import phi.redminepj.fragment.MyTaskFragment;
import phi.redminepj.fragment.ProjectFragment;
import phi.redminepj.fragment.SettingFragment;

/**
 * Created by guiltygearxx on 16-05-2016.
 */
public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    FragmentAdapter fragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayoutMainActivity);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("Project"));
        tabLayout.addTab(tabLayout.newTab().setText("My Task"));
        tabLayout.addTab(tabLayout.newTab().setText("Filter"));
        tabLayout.addTab(tabLayout.newTab().setText("Setting"));

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new ProjectFragment());
        fragmentArrayList.add(new MyTaskFragment());
        fragmentArrayList.add(new FilterFragment());
        fragmentArrayList.add(new SettingFragment());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentArrayList);

        viewPager = (ViewPager) findViewById(R.id.viewPagerMainActivity);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
