package phi.redminepj.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.adapters.RecyclerViewProjectAdapter1;
import phi.redminepj.models.Project;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.network.response.ProjectCallBack;

/**
 * Created by guiltygearxx on 21-05-2016.
 */
public class SearchFilterActivity extends AppCompatActivity {
    private static RecyclerViewProjectAdapter1 recyclerViewProjectAdapter;
    LinearLayout btnProject;
    TextView textProject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search_filter);
        getAllField();
    }

    public void getAllField() {
        textProject = (TextView) findViewById(R.id.textProject);
        btnProject = (LinearLayout) findViewById(R.id.btnProject);
    }

    public void getListofProjectFilter(View view) {
        final Dialog dialog = new Dialog(SearchFilterActivity.this);
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
                    recyclerViewProject.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerViewProject, new AddIssueActivity.ClickListener() {
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
