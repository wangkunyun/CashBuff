package com.md.cfashsbugff.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.kongzue.baseokhttp.exceptions.TimeOutException;
import com.kongzue.baseokhttp.listener.BeanResponseInterceptListener;
import com.kongzue.baseokhttp.util.BaseOkHttp;
import com.kongzue.baseokhttp.util.Parameter;
import com.md.cfashsbugff.R;
import com.md.cfashsbugff.bean.MsgBean;


public abstract class BaseFragment extends Fragment {
    protected View mGroup;
    protected Context mContext;
    protected LayoutInflater mInflater;

    protected abstract int getLayoutId();

    protected Bundle savedInstanceState;
    protected String TAG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        TAG = this.getClass().getSimpleName();

        mInflater = inflater;
        if (mGroup == null) {
            mGroup = inflater.inflate(getLayoutId(), container, false);
        }

        return mGroup;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        initView();
        initListen();
        iniData();
        setHttp();
    }

    protected void NoStatusBarDarkFont() {
        //沉浸式状态栏 深色字体
        ImmersionBar.with(getActivity())
                .statusBarDarkFont(true)
                .init();
    }
    protected void BlueStatusBarDarkFont() {
        ImmersionBar.with(getActivity())
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

    protected void setHttp() {
        if (SPUtils.getInstance().getString("lang").equals("")) {
            SPUtils.getInstance().put("lang", "en");
        }
        BaseOkHttp.TIME_OUT_DURATION = 120;
        BaseOkHttp.overallHeader = new Parameter()
                .add("Charset", "UTF-8")
                .add("lang", SPUtils.getInstance().getString("lang"))
                .add("uid", SPUtils.getInstance().getString("uid"))
                .add("token", SPUtils.getInstance().getString("token"))
//                .add("token", "$2y$10$QdnO6vsK3ZEFbEBcdG.GXuUC8rrWpVkpNAD4pG4yH0zFVThrbCjLW")
//                .add("uid", "2")
                .add("devnum", DeviceUtils.getUniqueDeviceId());//uniqueDeviceId

//                .add("deviceid", DeviceUtils.getAndroidID())
//                .add("model", DeviceUtils.getManufacturer() + DeviceUtils.getModel())
//                .add("uniqueDeviceId", DeviceUtils.getUniqueDeviceId())
//                .add("AndroidVersion", DeviceUtils.getSDKVersionName());
        BaseOkHttp.responseInterceptListener = new BeanResponseInterceptListener<MsgBean>() {
            @Override
            public boolean onResponse(Context context, String url, MsgBean response, Exception error) {

                if (error == null) {
                    switch (response.getCode()) {
                        case "401":


                            break;
                        case "500":
//                    Toast.makeText(MyApplication.getContext(), jsonObject.getString("msg"), Toast.LENGTH_SHORT).show();
                            ToastUtils.showShort(response.getMsg());
//
                            break;
                        case "501":
                            break;
                        case "502":

                            break;
                        case "503":

                            break;
//                        default:
//                            break;
                    }
                } else {
                    error.printStackTrace();
                    if (error instanceof TimeOutException) {
                        ToastUtils.showShort("Time Out");
                    }
                }
                return true;
            }
        };

    }


    public abstract void initView();

    public abstract void iniData();

    public abstract void initListen();

    protected void WhiteStatusBar() {
        ImmersionBar.with(getActivity())
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

    protected void NoStatusBar() {
        ImmersionBar.with(getActivity())
                .init();
    }

//    // dialog
//    public CustomDialog getDialog(boolean isDismiss) {
//        if (dialog == null) {
//            dialog = CustomDialog.instance(getActivity(),isDismiss);
//            dialog.setCancelable(true);
//        }
//        return dialog;
//    }
//
//    public void hideDialog() {
//        if (dialog != null)
//            dialog.hide();
//    }
//
//    public void showDialog(boolean isDismiss,String progressTip) {
//        getDialog(isDismiss).show();
//        if (progressTip != null) {
//            getDialog(isDismiss).setTvProgress(progressTip);
//        }
//    }
//
//    public void dismissDialog() {
//        if (dialog != null) {
//            dialog.dismiss();
//            dialog = null;
//        }
////        dismissDialog();
//
//    }


    public void openActivity(Class<?> targetActivityClass) {
        openActivity(targetActivityClass, null);
    }

    public void openActivity(Class<?> targetActivityClass, Bundle bundle) {
        Intent intent = new Intent(mContext, targetActivityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


}
