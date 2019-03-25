package com.bhx.common_downland;

import com.bhx.common_downland.callback.DownlandCallBack;
import com.bhx.common_downland.callback.OnResponseHeaderCallBack;
import com.bhx.common_downland.client.IHttpRequest;
import com.bhx.common_downland.client.OkHttpRequest;
import com.bhx.common_downland.task.DownlandTask;
import com.bhx.common_downland.utils.DownlandConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 下载管理类
 */
public class DownlandManager {


    private static volatile DownlandManager INSTANCE;
    private DownlandConfig mDownlanConfig; // 下载配置类
    private IHttpRequest mRequest; //默认OkHttp为下载引擎

    public static DownlandManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DownlandManager.class) {
                if (INSTANCE == null)
                    INSTANCE = new DownlandManager();
            }
        }
        return INSTANCE;
    }

    private DownlandManager() {
        mRequest = new OkHttpRequest();
    }

    /**
     * 配置用户参数
     * @param config
     */
    public void init(DownlandConfig config) {
        this.mDownlanConfig = config;
    }

    /**
     * 开始下载
     *
     * @param url      下载得地址
     * @param filePath 文件保存得地址
     * @param fileName 文件得名称
     * @param callBack 下载得回调
     */
    public void startDownland(String url, String filePath, String fileName, DownlandCallBack callBack) {
        //首先判断是否正在下载，如果正在下载就不处理

//        DownlandTask task = new DownlandTask(url, filePath, fileName);

    }


}
