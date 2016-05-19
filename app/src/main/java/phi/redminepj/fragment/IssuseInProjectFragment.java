package phi.redminepj.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.adapters.RecyclerViewIssueAdapter;
import phi.redminepj.models.Issue;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.network.response.IssueCallBack;

/**
 * Created by guiltygearxx on 18-05-2016.
 */
public class IssuseInProjectFragment extends Fragment {
    private static final String MY_TAG = "message_from_meomeo";
    public static final String PREFS_ID_PROJECT="idofproject";
    public static RecyclerViewIssueAdapter recyclerViewIssueAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(MY_TAG, "onCreated My Task Fragment before call API");
        SharedPreferences preferences = this.getActivity().getSharedPreferences(PREFS_ID_PROJECT, Context.MODE_PRIVATE);
        int idissueinproject = preferences.getInt("id_issue_of_project",0);
        Log.d(MY_TAG, "ID Issue In Project is: "+idissueinproject);
        new APIClient(getContext()).getIssues(APIClient.API_ALL_PROJECT_BY_ID + idissueinproject, new IssueCallBack() {
            @Override
            public void onCompleted(int statusCode, ArrayList<Issue> issueArrayList) {
                if (issueArrayList == null) {
                    Log.d(MY_TAG, "issueArrayList in MyTaskFragment is null, fuck off");
                } else {
                    Log.d(MY_TAG, "onCreate MyTaskFragment after call API, before put to adapter: " + issueArrayList.size());
                    recyclerViewIssueAdapter = new RecyclerViewIssueAdapter(getContext(), issueArrayList);
                    recyclerView.setAdapter(recyclerViewIssueAdapter);
                }


            }
        });
        // Inflate the layout for this fragment
        //Log.d(MY_TAG, "onCreateView Project Fragment");
        View view = inflater.inflate(R.layout.fragment_mytask, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMyTask);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
