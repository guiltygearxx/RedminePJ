package phi.redminepj.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.adapters.RecyclerViewProjectAdapter;
import phi.redminepj.models.Project;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.network.response.ProjectCallBack;

public class ProjectFragment extends Fragment {
    RecyclerView recyclerView;
    private static RecyclerViewProjectAdapter recyclerViewProjectAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new APIClient(getContext()).getProjectofCurentUser(new ProjectCallBack() {
            @Override
            public void onCompleted(int statusCode, ArrayList<Project> projectArrayList) {
                if (projectArrayList == null) {
                    Log.d(APIClient.MY_TAG, "projectArrayList in ProjectFragment is null, fuck off");
                } else {
                    recyclerViewProjectAdapter = new RecyclerViewProjectAdapter(getContext(), projectArrayList);
                    recyclerView.setAdapter(recyclerViewProjectAdapter);
                }
            }
        });
        //Log.d(MY_TAG, "onCreateView Project Fragment");
        View view = inflater.inflate(R.layout.fragment_project, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewProject);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


    }
}
