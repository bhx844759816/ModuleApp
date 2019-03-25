package com.bhx.common_downland.utils;

/**
 * 下载得配置类
 */
public class DownlandConfig {

    private int maxThreadNums;//最大线程个数
    private int aliveThreadNums;//活跃线程个数
    private int downlandThreadNums;//分段下载线程得个数

    private boolean isTimeOutRetry;//是否超时重试
    private long timeOut;//默认超时时间
}
