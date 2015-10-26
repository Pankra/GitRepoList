package com.pankra.gitrepolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pankra.gitrepolist.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SPankratov on 26.10.2015.
 */
public class RecyclerUserListFragment extends Fragment {
    protected List<String> mDataSet;
    protected RecyclerView mRecyclerView;
    protected UserAdapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataSet();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_user_list_fragment, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new UserAdapter(mDataSet);

        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void initDataSet() {
        List<String> dataSet = new ArrayList<>();
        for (DummyContent.DummyItem item : DummyContent.ITEMS) {
            dataSet.add(item.toString());
        }
        mDataSet = dataSet;
    }
}
