package com.vmloft.develop.app.match.app;

import com.tencent.bugly.crashreport.CrashReport;

import com.vmloft.develop.app.match.BuildConfig;
import com.vmloft.develop.app.match.im.AIMManager;
import com.vmloft.develop.library.tools.base.VMApp;
import com.vmloft.develop.library.tools.utils.VMLog;

/**
 * Create by lzan13 on 2019/04/08
 * 程序入口
 */
public class App extends VMApp {

    @Override
    public void onCreate() {
        super.onCreate();
        VMLog.d("是否为 Debug 环境 %b", BuildConfig.isDebug);
        init();
    }

    private void init() {
        // 初始化 Bugly 日志上报功能
        initBugly();

        // 初始化 IM
        AIMManager.getInstance().initIM(context);
    }

    /**
     * 初始化 Bugly 日志上报
     */
    private void initBugly() {
        // 设置是否为开发设备
        CrashReport.setIsDevelopmentDevice(context, BuildConfig.isDebug);
        CrashReport.initCrashReport(context);
    }
}
