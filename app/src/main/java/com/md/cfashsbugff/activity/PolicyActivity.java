package com.md.cfashsbugff.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.md.cfashsbugff.R;
import com.md.cfashsbugff.base.BaseActivity;

public class PolicyActivity extends BaseActivity {

    private ImageView clickFinish;
    private TextView tvXy;
    private String xy = "Welcome to Songs of Music and start your music journey When you use our services, we may use your mobile phone and information about you. We hope to protect the privacy of users (\"users\" or \"you\") through this solemn commitment of this Privacy Policy. Welcome to Songs of Music and start your music journey When you use our services, we may use your mobile phone and information about you. We hope to protect the privacy of users (\"users\" or \"you\") through this solemn commitment of this Privacy Policy.";


    @Override
    public int getLayout() {
        return R.layout.activity_policy;
    }

    @Override
    public void initView() {
        BlueStatusBarDarkFont();
        clickFinish = (ImageView) findViewById(R.id.click_finish);

        tvXy = (TextView) findViewById(R.id.tv_xy);
        tvXy.setText(xy);
    }

    @Override
    public void iniData() {

    }

    @Override
    public void initListen() {
        clickFinish.setOnClickListener(v -> finish());
    }
}