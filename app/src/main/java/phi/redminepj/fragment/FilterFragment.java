package phi.redminepj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import phi.redminepj.R;
import phi.redminepj.activity.LoginActivity;
import phi.redminepj.activity.SearchFilterActivity;


public class FilterFragment extends Fragment {
    LinearLayout btnFilterSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_contents_list, container, false);
        btnFilterSearch = (LinearLayout)view.findViewById(R.id.btnFilterSearch);
        btnFilterSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchFilterActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
