package com.bhx.common_downland.task;

/**
 * 具体得任务类
 */
public class Task {


    private long start; //下载得开始位置
    private long end; //下载得结束位置
    private String url; // 下载得url
    private DownlandRunnable runnable; //下载得线程类
    private String filePath; // 文件存储路径
    private String fileName; // 文件存储名称

    public Task(String url, long start, long end, String filePath, String fileName) {
        this.url = url;
        this.start = start;
        this.end = end;
        this.filePath = filePath;
        this.fileName = fileName;
        this.runnable = new DownlandRunnable();
    }


}
