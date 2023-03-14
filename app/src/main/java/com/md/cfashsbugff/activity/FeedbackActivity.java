package com.md.cfashsbugff.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.md.cfashsbugff.R;
import com.md.cfashsbugff.base.BaseActivity;

public class FeedbackActivity extends BaseActivity implements View.OnClickListener {
    private ImageView clickFinish;
    private EditText etFeedback;
    private TextView clickSubmit;


    @Override
    public int getLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    public void initView() {
        BlueStatusBarDarkFont();
        clickFinish = (ImageView) findViewById(R.id.click_finish);
        etFeedback = (EditText) findViewById(R.id.et_feedback);
        clickSubmit = (TextView) findViewById(R.id.click_submit);
        clickFinish.setOnClickListener(this);
        clickSubmit.setOnClickListener(this);
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
            case R.id.click_finish:
                finish();
                break;
            case R.id.click_submit:
                if (etFeedback.getText().toString().equals("")){
                    ToastUtils.showShort("Please fill in the content");
                    return;
                }
                ToastUtils.showShort("success");
                etFeedback.setText("");
                break;
        }
    }
}