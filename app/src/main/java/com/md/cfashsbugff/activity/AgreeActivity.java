package com.md.cfashsbugff.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.md.cfashsbugff.MainActivity;
import com.md.cfashsbugff.R;
import com.md.cfashsbugff.base.BaseActivity;

public class AgreeActivity extends BaseActivity implements View.OnClickListener {


    private String xy = "Welcome to Songs of Music and start your music journey When you use our services, we may use your mobile phone and information about you. We hope to protect the privacy of users (\"users\" or \"you\") through this solemn commitment of this Privacy Policy. Welcome to Songs of Music and start your music journey When you use our services, we may use your mobile phone and information about you. We hope to protect the privacy of users (\"users\" or \"you\") through this solemn commitment of this Privacy Policy.";
    private TextView tvXy;
    private ImageView clickImg;
    private TextView clickTv;
    private TextView clickOk;

    private boolean isSelect = false;

    @Override
    public int getLayout() {
        return R.layout.activity_agree;
    }

    @Override
    public void initView() {
        BlueStatusBarDarkFont();
        tvXy = (TextView) findViewById(R.id.tv_xy);
        clickImg = (ImageView) findViewById(R.id.click_img);
        clickTv = (TextView) findViewById(R.id.click_tv);
        clickOk = (TextView) findViewById(R.id.click_ok);
    }

    @Override
    public void iniData() {
        tvXy.setText(xy);
    }

    @Override
    public void initListen() {
        clickImg.setOnClickListener(this);
        clickTv.setOnClickListener(this);
        clickOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_img:
            case R.id.click_tv:
                if (isSelect) {
                    isSelect = false;
                    clickOk.setBackgroundColor(Color.parseColor("#A3C9F9"));
                    clickImg.setImageResource(R.mipmap.icon_select_false);
                } else {
                    isSelect = true;
                    clickOk.setBackgroundColor(Color.parseColor("#3A87E9"));
                    clickImg.setImageResource(R.mipmap.icon_select_true);
                }
                break;
            case R.id.click_ok:
                if (!isSelect) {
                    ToastUtils.showShort("Please read carefully and agree to the agreement");
                    return;
                } else {
                    SPUtils.getInstance().put("first", "0");
                    openActivity(MainActivity.class);
                }
                break;

        }
    }
}