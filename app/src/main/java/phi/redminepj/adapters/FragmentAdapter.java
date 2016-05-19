package phi.redminepj.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

/**
 * Created by haconglinh1990 on 12/04/2016.
 */


public class FragmentAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private static final String MY_TAG = "message_from_meomeo";
    int numberOfTab;
    ArrayList<Fragment> fragmentArrayList;

    public FragmentAdapter(FragmentManager fm, int numberOfTab) {
        super(fm);
        this.numberOfTab = numberOfTab;
    }

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList){
        super(fm);
        this.fragmentArrayList = fragmentArrayList;
    }

//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                Log.d(MY_TAG, "on FragmentAdapter before create Project Fragment");
//                ProjectFragment project_fragment = new ProjectFragment();
//                Log.d(MY_TAG, "on FragmentAdapter after create Project Fragment");
//                return project_fragment;
//            case 1:
//                MyTaskFragment myTask_fragment = new MyTaskFragment();
//                return myTask_fragment;
//            case 2:
//                FilterFragment filter_fragment = new FilterFragment();
//                return filter_fragment;
//            case 3:
//                SettingFragment setting_fragment = new SettingFragment();
//                return setting_fragment;
//            default:
//                return null;
//        }
//    }
//    @Override
//    public int getCount() {
//        return numberOfTab;
//}
//}
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }



}