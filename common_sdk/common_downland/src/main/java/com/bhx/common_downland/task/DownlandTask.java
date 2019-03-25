package com.bhx.common_downland.task;

import com.bhx.common_downland.callback.DownlandCallBack;

import java.util.List;

/**
 * 下载得任务类
 */
public class DownlandTask {
    private String url; //下载得URL
    private String filePath; // 文件保存得路径
    private String fileName; // 文件保存得名称
    private long contentLength;//文件得总长度
    private int threadSizes;//开启多少个线程下载
    private int successNums;//成功下载得个数
    private int progress;//当前下载得百分比
    private List<Task> taskList; //所有下载得线程
    private String fileMd5;//文件得MD5
    private DownlandCallBack callBack;//下载结果得回调
    private boolean isTaskFinish; //是否下载完成


    public DownlandTask(String url, String filePath, String fileName, DownlandCallBack callBack) {
        this.url = url;
        this.fileName = fileName;
        this.callBack = callBack;
        this.filePath = filePath;
    }

    /**
     * 通过url获取支持得下载模式 多线程 还是 单线程下载
     */
    public void startTask() {
         // 获取下载请求头

    }

    /**
     * 暂停下载
     */
    public void stopTask() {

    }

    /**
     * 取消下载任务
     */
    public void cancelTask() {

    }

    /**
     * 是否正在下载
     *
     * @return
     */
    public boolean isTaskRunning() {
        return false;
    }

    /**
     * 是否任务执行完成
     *
     * @return
     */
    public boolean isTaskFinish() {
        return isTaskFinish;
    }


}
