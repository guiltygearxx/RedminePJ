package phi.redminepj.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

import phi.redminepj.R;

/**
 * Created by guiltygearxx on 19-05-2016.
 */
public class AddIssueActivity extends AppCompatActivity {
    static final int START_DATE_DIALOG_ID = 1;
    static final int DUE_DATE_DIALOG_ID = 2;
    LinearLayout btnStartDate, btnDueDate;
    private int year, month, day;
    String date;
    TextView textStartDate,textDueDate;

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
        btnStartDate = (LinearLayout) findViewById(R.id.btnStartDate);
        btnDueDate = (LinearLayout) findViewById(R.id.btnDueDate);
        textStartDate = (TextView)findViewById(R.id.textStartDate);
        textDueDate = (TextView)findViewById(R.id.textDueDate);
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
}
