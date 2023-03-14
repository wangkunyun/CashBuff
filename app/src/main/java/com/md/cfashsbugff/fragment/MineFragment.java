package com.md.cfashsbugff.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.md.cfashsbugff.R;
import com.md.cfashsbugff.activity.FeedbackActivity;
import com.md.cfashsbugff.activity.PolicyActivity;
import com.md.cfashsbugff.base.BaseFragment;

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout clickA;
    private RelativeLayout clickB;
    private TextView clickExit;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }


    @Override
    public void initView() {
        BlueStatusBarDarkFont();


        clickA = (RelativeLayout) mGroup.findViewById(R.id.click_a);
        clickB = (RelativeLayout) mGroup.findViewById(R.id.click_b);
        clickExit = (TextView) mGroup.findViewById(R.id.click_exit);
        clickA.setOnClickListener(this);
        clickB.setOnClickListener(this);
        clickExit.setOnClickListener(this);
    }

    @Override
    public void iniData() {

    }

    @Override
    public void initListen() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_a:
                openActivity(PolicyActivity.class);

                break;
            case R.id.click_b:
                openActivity(FeedbackActivity.class);
                break;

            case R.id.click_exit:
                AppUtils.exitApp();
                break;
        }
    }
}