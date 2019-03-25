package com.bhx.common_downland.callback;

import java.util.Map;

/**
 * 获取请求头得回调事件
 */
public interface OnResponseHeaderCallBack {
    /**
     * 获取请求头
     *
     * @param headers
     */
    void responseHeader(Map<String, String> headers);

    /**
     * 获取请求头失败
     *
     * @param t
     */
    void errorHeader(Throwable t);
}
