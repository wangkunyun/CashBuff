package com.md.cfashsbugff;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.md.cfashsbugff.base.BaseActivity;
import com.md.cfashsbugff.fragment.HomeFragment;
import com.md.cfashsbugff.fragment.MineFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout container;
    private RelativeLayout rlHome;
    private RelativeLayout rlMine;
    public static final int HOME_POSITION = 0;
    public static final int MINE_POSITION = 1;
    private View mTabs[];
    private int index;//记录当前坐标
    private int currentTabIndex;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment[] mFragments;
    private HomeFragment homeFragment;
    private MineFragment mineFragment;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        container = (RelativeLayout) findViewById(R.id.container);
        rlHome = (RelativeLayout) findViewById(R.id.rl_home);
        rlMine = (RelativeLayout) findViewById(R.id.rl_mine);
        NoStatusBar();


        mFragments = new Fragment[2];
        homeFragment = new HomeFragment();
        mineFragment = new MineFragment();
        mFragments[HOME_POSITION] = homeFragment;
        mFragments[MINE_POSITION] = mineFragment;


        //设置底标
        mTabs = new View[2];
        mTabs[HOME_POSITION] = rlHome;
        mTabs[MINE_POSITION] = rlMine;
        //设置被选中
        mTabs[HOME_POSITION].setSelected(true);
        //初始化 设置当前选中的界面
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        //TODO 此种写法会new两次 因为上面已经new一次了
        //提交对应的角标即可
        transaction.replace(R.id.container, mFragments[HOME_POSITION]);
        transaction.commit();
    }

    @Override
    public void iniData() {
        rlHome.setOnClickListener(this);
        rlMine.setOnClickListener(this);
    }

    @Override
    public void initListen() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                if (!homeFragment.isAdded()) {
//                    getSupportFragmentManager().beginTransaction().remove(homeFragment).commit();
                    transaction = manager.beginTransaction();
                    //记录角标
                    index = HOME_POSITION;
                    //绑定显示那个
                    transaction.replace(R.id.container, mFragments[HOME_POSITION]);
                    transaction.commit();
                    changeTab();
                }
                break;
            case R.id.rl_mine:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
                if (!mineFragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().remove(mineFragment).commit();
                    if (!mineFragment.isAdded()) {
                        transaction = manager.beginTransaction();
                        index = MINE_POSITION;
                        transaction.replace(R.id.container, mFragments[MINE_POSITION]);
                        transaction.commit();
                        changeTab();
                    }
                }
                break;
        }

    }

    /**
     * 定位坐标，处理当前点击焦点
     * currentTabIndex 属于当前坐标，后期可根据不同需求，拿到此坐标进行需求操作
     */
    private void changeTab() {
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(mFragments[currentTabIndex]);
            if (mFragments[index].isAdded()) {
                trx.add(R.id.container, mFragments[index]);
            }
            trx.show(mFragments[index]).commit();
        }
        for (int i = 0; i < mTabs.length; i++) {
            mTabs[i].setSelected(false);
        }
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }

    private long firstPressedTime;

    /**
     * System.currentTimeMillis() 当前系统的时间
     * 必须要将这个页面设为栈顶 不然无效 无法全面退出页面
     */
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - firstPressedTime < 2000) {
            finish();
            ActivityUtils.finishAllActivities();
            System.exit(0);
            AppUtils.exitApp();
        } else {
            ToastUtils.showShort("Press again to exit the application");
            firstPressedTime = System.currentTimeMillis();
        }
    }
}