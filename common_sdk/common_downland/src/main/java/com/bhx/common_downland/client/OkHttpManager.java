package com.bhx.common_downland.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 默认得Http请求类
 */
public class OkHttpManager {

    //okHttp得请求
    private OkHttpClient mOkHttpClient;
    private static volatile OkHttpManager INSTACE;

    /**
     * 获取OkHttpManager对象
     *
     * @return
     */
    public static OkHttpManager getInstance() {
        if (INSTACE == null) {
            synchronized (OkHttpManager.class) {
                if (INSTACE == null) {
                    INSTACE = new OkHttpManager();
                }
            }
        }
        return INSTACE;
    }

    private OkHttpManager() {
        mOkHttpClient = new okhttp3.OkHttpClient.Builder()
                .build();
    }

    /**
     * 分段下载请求
     *
     * @param url   下载得url
     * @param start 开始得位置
     * @param end   结束得位置
     * @return 请求接口
     */
    public Call asyncCall(String url, long start, long end) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Range", "bytes=" + start + "-" + end)
                .build();
        return mOkHttpClient.newCall(request);
    }

    /**
     * 普通下载请求
     *
     * @param url
     * @return
     */
    public Call asyncCall(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return mOkHttpClient.newCall(request);
    }
}
