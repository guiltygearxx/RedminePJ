package phi.redminepj.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import phi.redminepj.R;

/**
 * Created by guiltygearxx on 19-05-2016.
 */
public class AddIssueActivity extends AppCompatActivity {
    LinearLayout btnStartDate, btnDueDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_issues);
        getAllField();

    }

    public void getAllField() {
        btnStartDate = (LinearLayout) findViewById(R.id.btnStartDate);
        btnDueDate = (LinearLayout) findViewById(R.id.btnDueDate);
    }
}
