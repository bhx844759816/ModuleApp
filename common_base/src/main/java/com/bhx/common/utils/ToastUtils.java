package com.bhx.common.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.bhx.common.BaseApplication;

/**
 * 显示toast的工具类
 */
public class ToastUtils {

    //获取主线程的Handler
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static Toast sToast;
    private static boolean isJumpWhenMore;

    /**
     * 子线程弹出土司
     */
    public static void ioToastShort(final String msg) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                showToast(msg, Toast.LENGTH_SHORT);
            }
        });
    }

    /**
     * 子线程弹出土司
     *
     * @param resID 文本的资源ID
     */
    public static void ioToastShort(final int resID) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                showToast(resID, Toast.LENGTH_SHORT);
            }
        });
    }

    /**
     * 子线程弹出土司
     */
    public static void ioToastLong(final String msg) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                showToast(msg, Toast.LENGTH_LONG);
            }
        });
    }

    /**
     * 子线程弹出土司
     */
    public static void ioToastLong(final int resId) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                showToast(resId, Toast.LENGTH_LONG);
            }
        });
    }

    /**
     * 主线程弹出toast
     */
    public static void toastShort(String msg) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            showToast(msg, Toast.LENGTH_SHORT);
        }
    }

    /**
     * 主线程弹出toast
     */
    public static void toastShort(int  resId) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            showToast(resId, Toast.LENGTH_SHORT);
        }
    }


    /**
     * 主线程弹出长toast
     */
    public static void toastLong(String msg) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            showToast(msg, Toast.LENGTH_LONG);
        }
    }

    /**
     * 主线程弹出长toast
     */
    public static void toastLong(int resId) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            showToast(resId, Toast.LENGTH_LONG);
        }
    }

    /**
     * 展示resId文本的toast
     *
     * @param resId
     * @param duration
     */
    private static void showToast(@StringRes int resId, int duration) {
        showToast(BaseApplication.getContext().getResources().getText(resId).toString(), duration);
    }

    /**
     * 显示吐司
     *
     * @param text     文本
     * @param duration 显示时长
     */
    @SuppressLint("ShowToast")
    private static void showToast(CharSequence text, int duration) {
        if (isJumpWhenMore)
            cancelToast();
        if (sToast == null) {
            sToast = Toast.makeText(BaseApplication.getContext(), text, duration);
            TextView tv = sToast.getView().findViewById(android.R.id.message);
            tv.setTextSize(18);
            sToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            sToast.setText(text);
            sToast.setDuration(duration);
        }
        sToast.show();
    }

    /**
     * 取消吐司显示
     */
    public static void cancelToast() {
        if (sToast != null) {
            sToast.cancel();
            sToast = null;
        }
    }
}
