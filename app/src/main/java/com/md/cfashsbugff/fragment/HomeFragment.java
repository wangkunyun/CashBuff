package com.md.cfashsbugff.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;

import com.md.cfashsbugff.R;
import com.md.cfashsbugff.adapter.HomeAdapter;
import com.md.cfashsbugff.base.BaseFragment;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {

    private TextView clickApply;
    private RecyclerView reView;
    private HomeAdapter homeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void initView() {
        NoStatusBar();

        clickApply = (TextView) mGroup.findViewById(R.id.click_apply);
        reView = (RecyclerView) mGroup.findViewById(R.id.reView);
        reView.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeAdapter = new HomeAdapter(R.layout.item_apply);
        reView.setHasFixedSize(true);
        reView.setNestedScrollingEnabled(false);
        reView.setAdapter(homeAdapter);
        ArrayList<String> applyData = new ArrayList<>();
        applyData.add("1");
        applyData.add("1");
        applyData.add("1");
        applyData.add("1");
        applyData.add("1");
        applyData.add("1");
        homeAdapter.setNewData(applyData);
    }

    @Override
    public void iniData() {

    }

    @Override
    public void initListen() {

    }
}