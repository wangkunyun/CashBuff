package com.md.cfashsbugff.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.md.cfashsbugff.R;


public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG;
//    private CustomDialog dialog;//进度条

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        TAG = this.getClass().getSimpleName();


        setHttp();
        NoStatusBarDarkFont();
        initView();
        initListen();
        iniData();
    }

    protected void setHttp() {
//        if (SPUtils.getInstance().getString("lang").equals("")) {
//            SPUtils.getInstance().put("lang", "en");
//        }
//        BaseOkHttp.TIME_OUT_DURATION = 120;
//        BaseOkHttp.overallHeader = new Parameter()
//                .add("Charset", "UTF-8")
//                .add("lang", SPUtils.getInstance().getString("lang"))
//                .add("uid", SPUtils.getInstance().getString("uid"))
//                .add("token", SPUtils.getInstance().getString("token"))
////                .add("token", "$2y$10$QdnO6vsK3ZEFbEBcdG.GXuUC8rrWpVkpNAD4pG4yH0zFVThrbCjLW")
////                .add("uid", "2")
//                .add("devnum", DeviceUtils.getUniqueDeviceId());//uniqueDeviceId
//
////                .add("deviceid", DeviceUtils.getAndroidID())
////                .add("model", DeviceUtils.getManufacturer() + DeviceUtils.getModel())
////                .add("uniqueDeviceId", DeviceUtils.getUniqueDeviceId())
////                .add("AndroidVersion", DeviceUtils.getSDKVersionName());
//        BaseOkHttp.responseInterceptListener = new BeanResponseInterceptListener<MsgBean>() {
//            @Override
//            public boolean onResponse(Context context, String url, MsgBean response, Exception error) {
//
//                if (error == null) {
//                    switch (response.getCode()) {
//                        case "401":
//                            break;
//                        case "500":
//                            ToastUtils.showShort(response.getMsg());
////
//                            break;
//                        case "501":
//
//                            break;
//                        case "502":
//
//                            break;
//                        case "503":
//
//                            break;
////                        default:
////                            break;
//                    }
//                } else {
//                    error.printStackTrace();
//                    if (error instanceof TimeOutException) {
//                        ToastUtils.showShort("Time Out");
//                    }
//                }
//                return true;
//            }
//        };

    }

    protected void WhiteStatusBar() {
        ImmersionBar.with(BaseActivity.this)
                //状态栏颜色，不写默认透明色
                .statusBarColor(R.color.white)
                //导航栏颜色，不写默认黑色
//                .navigationBarColor(R.color.While)
                //解决状态栏和布局重叠问题
                .fitsSystemWindows(true)
                //状态栏字体是深色，不写默认为亮色
                .statusBarDarkFont(true)
                .init();
    }

    protected void NoStatusBarDarkFont() {
        //沉浸式状态栏 深色字体
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .init();
    }

    protected void BlueStatusBarDarkFont() {
        ImmersionBar.with(this)
                //状态栏颜色，不写默认透明色
                .statusBarColor(R.color.blue)
                //导航栏颜色，不写默认黑色
//                .navigationBarColor(R.color.While)
                //解决状态栏和布局重叠问题
                .fitsSystemWindows(true)
                //状态栏字体是深色，不写默认为亮色
                .statusBarDarkFont(false)
                .init();
    }

    protected void NoStatusBar() {
        ImmersionBar.with(this)
                .init();
    }

//    // dialog
//    public CustomDialog getDialog(boolean isDismiss) {
//        if (dialog == null) {
//            dialog = CustomDialog.instance(this, isDismiss);
//            dialog.setCancelable(true);
//        }
//        return dialog;
//    }
//
//    public void hideDialog() {
//        if (dialog != null)
//            dialog.hide();
//    }

//    public void showDialog(boolean isDismiss, String progressTip) {
//        getDialog(isDismiss).show();
//        if (progressTip != null) {
//            getDialog(isDismiss).setTvProgress(progressTip);
//        }
//    }

//    public void dismissDialog() {
//        if (dialog != null) {
//            dialog.dismiss();
//            dialog = null;
//        }
//        dismissDialog();

//    }

    public void openActivity(Class<?> targetActivityClass) {
        openActivity(targetActivityClass, null);
    }

    public void openActivity(Class<?> targetActivityClass, Bundle bundle) {
        Intent intent = new Intent(this, targetActivityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public abstract int getLayout();

    public abstract void initView();

    public abstract void iniData();

    public abstract void initListen();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
//    @Override
//    protected void onUserLeaveHint() {
//        super.onUserLeaveHint();
//        ToastUtils.showShort("11");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        ToastUtils.showShort("22");
//    }

//    //国际化
//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(LocalManageUtil.setLocal(newBase));
//    }
}
