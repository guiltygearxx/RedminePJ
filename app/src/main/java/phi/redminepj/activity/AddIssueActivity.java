package phi.redminepj.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import phi.redminepj.adapters.RecyclerViewProjectAdapter1;
import phi.redminepj.models.Project;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.network.response.ProjectCallBack;

/**
 * Created by guiltygearxx on 19-05-2016.
 */
public class AddIssueActivity extends AppCompatActivity {
    private static RecyclerViewProjectAdapter1 recyclerViewProjectAdapter;
    static final int START_DATE_DIALOG_ID = 1;
    static final int DUE_DATE_DIALOG_ID = 2;
    LinearLayout btnStartDate, btnDueDate, btnDoneRatio, btnProject;
    private int year, month, day;
    String date;
    TextView textStartDate, textDueDate, textDoneRatio, textProject, textSubject, textDescription, textEstimatedHours, textParentIssueID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_issues);
        getAllField();

        btnStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(START_DATE_DIALOG_ID);
            }
        });
        btnDueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DUE_DATE_DIALOG_ID);
            }
        });

    }

    public void getAllField() {
        textProject = (TextView) findViewById(R.id.textProject);
        btnStartDate = (LinearLayout) findViewById(R.id.btnStartDate);
        btnDueDate = (LinearLayout) findViewById(R.id.btnDueDate);
        btnDoneRatio = (LinearLayout) findViewById(R.id.btnDoneRatio);
        btnProject = (LinearLayout) findViewById(R.id.btnProject);
        textStartDate = (TextView) findViewById(R.id.textStartDate);
        textDueDate = (TextView) findViewById(R.id.textDueDate);
        textDoneRatio = (TextView) findViewById(R.id.textDoneRatio);
        textSubject = (TextView) findViewById(R.id.textSubject);
        textDescription = (TextView) findViewById(R.id.textDescription);
        textEstimatedHours = (TextView) findViewById(R.id.textEstimatedHours);
        textParentIssueID = (TextView) findViewById(R.id.textParentIssueID);
    }

    private void UpdateStartDate() {
        textStartDate.setText(new StringBuilder().append(day).append('/').append(month + 1).append('/').append(year));
    }

    private void UpdateDueDate() {
        textDueDate.setText(new StringBuilder().append(day).append('/').append(month + 1).append('/').append(year));
    }

    private DatePickerDialog.OnDateSetListener startdateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int years, int monthOfYear, int dayOfMonth) {
            year = years;
            month = monthOfYear;
            day = dayOfMonth;
            UpdateStartDate();
        }
    };

    private DatePickerDialog.OnDateSetListener duedateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int years, int monthOfYear, int dayOfMonth) {
            year = years;
            month = monthOfYear;
            day = dayOfMonth;
            UpdateDueDate();
        }
    };

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case START_DATE_DIALOG_ID:
                return new DatePickerDialog(this, startdateListener, year, month, day);

            case DUE_DATE_DIALOG_ID:
                return new DatePickerDialog(this, duedateListener, year, month, day);
        }
        return null;
    }

    public void onSetDoneRatio(View view) {
        final Dialog dialog = new Dialog(AddIssueActivity.this);
        dialog.setContentView(R.layout.list_issuse_done);
        final RadioButton rb0 = (RadioButton) dialog.findViewById(R.id.rb0);
        final RadioButton rb1 = (RadioButton) dialog.findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton) dialog.findViewById(R.id.rb2);
        final RadioButton rb3 = (RadioButton) dialog.findViewById(R.id.rb3);
        final RadioButton rb4 = (RadioButton) dialog.findViewById(R.id.rb4);
        final RadioButton rb5 = (RadioButton) dialog.findViewById(R.id.rb5);
        final RadioButton rb6 = (RadioButton) dialog.findViewById(R.id.rb6);
        final RadioButton rb7 = (RadioButton) dialog.findViewById(R.id.rb7);
        final RadioButton rb8 = (RadioButton) dialog.findViewById(R.id.rb8);
        final RadioButton rb9 = (RadioButton) dialog.findViewById(R.id.rb9);
        final RadioButton rb10 = (RadioButton) dialog.findViewById(R.id.rb10);

        rb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("0");
                dialog.dismiss();
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("10");
                dialog.dismiss();
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("20");
                dialog.dismiss();
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("30");
                dialog.dismiss();
            }
        });

        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("40");
                dialog.dismiss();
            }
        });
        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("50");
                dialog.dismiss();
            }
        });
        rb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("60");
                dialog.dismiss();
            }
        });
        rb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("70");
                dialog.dismiss();
            }
        });
        rb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("80");
                dialog.dismiss();
            }
        });
        rb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("90");
                dialog.dismiss();
            }
        });
        rb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDoneRatio.setText("100");
                dialog.dismiss();
            }
        });
        dialog.setCancelable(true);
        dialog.setTitle("% Done");
        dialog.show();
    }

    public void onsetTextSubject(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(AddIssueActivity.this);
        getApplicationContext();
        builder.setCancelable(true);
        builder.setInverseBackgroundForced(true);
        builder.setMessage("Enter your subject");
        final EditText input = new EditText(AddIssueActivity.this);
        builder.setView(input);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String txtSubject = input.getText().toString();
                        textSubject.setText(txtSubject.toString());
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }
        );
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onsetTexDescription(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(AddIssueActivity.this);
        getApplicationContext();
        builder.setCancelable(true);
        builder.setInverseBackgroundForced(true);
        builder.setMessage("Enter your description");
        final EditText input = new EditText(AddIssueActivity.this);
        builder.setView(input);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String txtDescription = input.getText().toString();
                        textDescription.setText(txtDescription.toString());
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }
        );
        AlertDialog alert = builder.create();
        alert.show();
    }


    public void onsetTextPriority(View view) {
        final Dialog dialog = new Dialog(AddIssueActivity.this);
        dialog.setContentView(R.layout.list_issuse_priority);
        final Button btnCancel = (Button)dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(true);
        dialog.setTitle("Priority");
        dialog.show();
    }

    public void onsetTextEstimate(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(AddIssueActivity.this);
        getApplicationContext();
        builder.setCancelable(true);
        builder.setInverseBackgroundForced(true);
        builder.setMessage("Enter your estimate");
        final EditText input = new EditText(AddIssueActivity.this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String txtEstimate = input.getText().toString();
                        textEstimatedHours.setText(txtEstimate.toString() + ".0");
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }
        );
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onsetTextParentTask(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(AddIssueActivity.this);
        getApplicationContext();
        builder.setCancelable(true);
        builder.setInverseBackgroundForced(true);
        builder.setMessage("Enter your parent task");
        final EditText input = new EditText(AddIssueActivity.this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String txtParent = input.getText().toString();
                        textParentIssueID.setText(txtParent.toString());
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }
        );
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void getListofProject(View view) {
        final Dialog dialog = new Dialog(AddIssueActivity.this);
        dialog.setContentView(R.layout.list_issue_project);
        final TextView name_project = (TextView) dialog.findViewById(R.id.name_project);
        final RecyclerView recyclerViewProject = (RecyclerView) dialog.findViewById(R.id.recyclerViewProject);
        recyclerViewProject.setHasFixedSize(true);
        recyclerViewProject.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        new APIClient(getBaseContext()).getProjectofCurentUser(new ProjectCallBack() {
            @Override
            public void onCompleted(int statusCode, final ArrayList<Project> projectArrayList) {
                if (projectArrayList == null) {
                    Log.d(APIClient.MY_TAG, "projectArrayList in ProjectFragment is null, fuck off");
                } else {
                    recyclerViewProjectAdapter = new RecyclerViewProjectAdapter1(getBaseContext(), projectArrayList);
                    recyclerViewProject.setAdapter(recyclerViewProjectAdapter);
                    recyclerViewProject.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerViewProject, new ClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            Project project = projectArrayList.get(position);
                            textProject.setText(project.getName().toString());
                            Toast.makeText(getApplicationContext(), position + " is selected!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                        @Override
                        public void onLongClick(View view, int position) {

                        }
                    }));
                }
            }
        });
        dialog.setCancelable(true);
        dialog.setTitle("Project");
        dialog.show();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private AddIssueActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final AddIssueActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
