package phi.redminepj.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.models.Membership;
import phi.redminepj.viewholder.MemberViewHolder;
import phi.redminepj.viewholder.StatusViewHolder;

/**
 * Created by haconglinh1990 on 14/04/2016.
 */
public class RecyclerViewMemberAdapter extends RecyclerView.Adapter<MemberViewHolder>{
    Context context;
    ArrayList<Membership> membershipArrayList;
    Membership membership;

    // Define listener member variable
    private static OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public RecyclerViewMemberAdapter(Context context, ArrayList<Membership> statusArrayList) {
        this.context = context;
        this.membershipArrayList = statusArrayList;
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_project_list1, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {
        membership = membershipArrayList.get(position);
        holder.viewNameProject.setText(membership.getUser().getName());
    }

    @Override
    public int getItemCount() {
        return membershipArrayList.size();
    }
}
