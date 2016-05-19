package phi.redminepj.activity;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;

        import java.util.ArrayList;

        import phi.redminepj.R;
        import phi.redminepj.adapters.FragmentAdapter;
        import phi.redminepj.fragment.IssuseInProjectFragment;

/**
 * Created by guiltygearxx on 18-05-2016.
 */
public class IssueInProjectActivity extends AppCompatActivity {
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_list);
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new IssuseInProjectFragment());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentArrayList);
        viewPager = (ViewPager) findViewById(R.id.viewPagerIssueActivity);
        viewPager.setAdapter(fragmentAdapter);
    }
}
