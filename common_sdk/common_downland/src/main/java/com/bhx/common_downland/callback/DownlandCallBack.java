package com.bhx.common_downland.callback;

import java.io.File;

/**
 * 下载结果得回调
 */
public interface DownlandCallBack {
    /**
     * 下载成功
     *
     * @param file
     */
    void success(File file);

    /**
     * 下载失败
     *
     * @param t
     */
    void error(Throwable t);

    /**
     * 下载进度回调
     *
     * @param progress
     */
    void progress(long progress);
}
