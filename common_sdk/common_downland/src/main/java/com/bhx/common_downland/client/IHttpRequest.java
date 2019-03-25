package com.bhx.common_downland.client;

import com.bhx.common_downland.callback.OnResponseHeaderCallBack;

import java.io.InputStream;
import java.util.Map;

/**
 * http请求得抽象类
 */
public interface IHttpRequest {

    /**
     * 通过url去获取输入流
     *
     * @param url
     * @return
     */
    InputStream startDownland(String url, long start, long end);

    /**
     * 通过url获取返回头 例如Content-length Accept-Ranges
     *
     * @param url 服务器文件地址
     * @return
     */
    void getResponseHeaders(String url, OnResponseHeaderCallBack callBack);
}
