package phi.redminepj.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.adapters.RecyclerViewMemberAdapter;
import phi.redminepj.adapters.RecyclerViewProjectAdapter1;
import phi.redminepj.adapters.RecyclerViewStatusAdapter;
import phi.redminepj.adapters.RecyclerViewTrackersAdapter;
import phi.redminepj.models.IssueStatus;
import phi.redminepj.models.Membership;
import phi.redminepj.models.Project;
import phi.redminepj.models.Tracker;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.network.response.MemberCallBack;
import phi.redminepj.network.response.ProjectCallBack;
import phi.redminepj.network.response.StatusCallBack;
import phi.redminepj.network.response.TrackersCallBack;

/**
 * Created by guiltygearxx on 19-05-2016.
 */
public class EditIssueActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issues_edit);
    }
}
