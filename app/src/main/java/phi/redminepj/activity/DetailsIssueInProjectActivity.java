package phi.redminepj.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import phi.redminepj.R;
import phi.redminepj.models.Issue;
import phi.redminepj.models.Journal;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.network.response.IssueDetailCallBack;
import phi.redminepj.ultils.DateUtil;

/**
 * Created by guiltygearxx on 18-05-2016.
 */
public class DetailsIssueInProjectActivity extends AppCompatActivity {
    private static final String MY_TAG = "message_from_meomeo";
    public static final String PREFS_ID_ISSUE = "idoissue";
    TextView textIssueID, textCreateDateFromNow, textSubject, textDescription, textProject, textStatus, textPriority, textAssignedTo, textDoneRatio, textStartDate, textDueDate, textAuthorName, textCreateDate, textUpdateDate, textEstimatedHours;
    DateFormat formatter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_details);
        loadAllField();
        final DateUtil dateUtil = new DateUtil();
        final Date date = new Date();
        String strDateFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println("Ngày hôm nay : " + sdf.format(date));

        SharedPreferences preferences = getSharedPreferences(PREFS_ID_ISSUE, Context.MODE_PRIVATE);
        int idissue = preferences.getInt("id_issue_in_details", 0);

        new APIClient(DetailsIssueInProjectActivity.this).getDetailIssues(APIClient.API_GET_ISSUE_ID
                        + idissue + ".json?include=attachments,relations,journals,children",
                new IssueDetailCallBack() {
                    @Override
                    public void onCompleted(int statusCode, Issue issue) {
                        if (statusCode == 200) {
                            Log.d(MY_TAG, "onCreate DetailIssue after call API, before put to adapter is success");
                            textIssueID.setText("#" + issue.getId().toString());
                            textCreateDateFromNow.setText(issue.getCreatedOn().toString());
                            textSubject.setText(issue.getSubject().toString());
                            try {
                                textDescription.setText(issue.getDescription().toString());
                            } catch (Exception e) {
                                textDescription.setText("");
                            }

                            textProject.setText(issue.getProject().getName().toString());
                            textStatus.setText(issue.getStatus().getName().toString());
                            textPriority.setText(issue.getPriority().getName().toString());
                            textAssignedTo.setText(issue.getAssignedTo().getName().toString());
                            textDoneRatio.setText(issue.getDoneRatio().toString()+"%");
                            textStartDate.setText(issue.getStartDate().toString());
                            try {
                                textDueDate.setText(issue.getDueDate().toString());
                            } catch (Exception e) {
                                textDueDate.setText("");
                            }
                            textAuthorName.setText(issue.getAuthor().getName().toString());
                            textCreateDate.setText(issue.getCreatedOn().toString());
                            textUpdateDate.setText(issue.getUpdatedOn().toString());

                            if (issue.getSpentHours() != null) {
                                textEstimatedHours.setText(issue.getSpentHours() + "");
                            } else {
                                textEstimatedHours.setText("0.0");
                            }

                            ArrayList<Journal> journals = (ArrayList<Journal>) issue.getJournals();
                            Log.d(MY_TAG, "Total List Journal: " + journals.size());

                            for (Journal journal : journals) {
                                Log.d(MY_TAG, "List ID Journal: " + journal.getId());
                            }

                        } else

                        {
                            Log.d(MY_TAG, "onCreate DetailIssue after call API, failse");
                        }


                    }
                }

        );
    }

    public void loadAllField() {
        textIssueID = (TextView) findViewById(R.id.textIssueID);
        textCreateDateFromNow = (TextView) findViewById(R.id.textCreateDateFromNow);
        textSubject = (TextView) findViewById(R.id.textSubject);
        textDescription = (TextView) findViewById(R.id.textDescription);
        textProject = (TextView) findViewById(R.id.textProject);
        textStatus = (TextView) findViewById(R.id.textStatus);
        textPriority = (TextView) findViewById(R.id.textPriority);
        textAssignedTo = (TextView) findViewById(R.id.textAssignedTo);
        textDoneRatio = (TextView) findViewById(R.id.textDoneRatio);
        textStartDate = (TextView) findViewById(R.id.textStartDate);
        textDueDate = (TextView) findViewById(R.id.textDueDate);
        textAuthorName = (TextView) findViewById(R.id.textAuthorName);
        textCreateDate = (TextView) findViewById(R.id.textCreateDate);
        textUpdateDate = (TextView) findViewById(R.id.textUpdateDate);
        textEstimatedHours = (TextView) findViewById(R.id.textEstimatedHours);
    }
}
