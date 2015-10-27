package com.pankra.gitrepolist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pankra.gitrepolist.dummy.DummyContent;
import com.pankra.gitrepolist.model.User;

import java.util.List;

import static com.pankra.gitrepolist.RecyclerUserListFragment.*;

/**
 * Created by SPankratov on 26.10.2015.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private List<User> mDataSet;
    private UserListCallback mUserListCallback;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        private UserListCallback listCallback;

        public void setListCallback(UserListCallback listCallback) {
            this.listCallback = listCallback;
        }

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public void onClick(View v) {
            Log.d("DDDD", "Element " + getLayoutPosition() + " clicked.");
            listCallback.onItemSelected(DummyContent.ITEMS.get(getLayoutPosition()).id);
        }
    }

    public UserAdapter(List<User> mDataSet) {
        this.mDataSet = mDataSet;
    }

    public void setUserListCallback(UserListCallback userListCallback) {
        this.mUserListCallback = userListCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        vh.setListCallback(mUserListCallback);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView().setText(mDataSet.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
