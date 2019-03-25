package com.bhx.module_test.ui;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.bhx.common.http.RetrofitManager;
import com.bhx.common.http.upload.UploadManager;
import com.bhx.common.http.upload.UploadParam;
import com.bhx.common.http.upload.UploadProgressObserver;
import com.bhx.module_test.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class TestActivity extends AppCompatActivity {
    private EditText mEditText;
    private EditText mEditText02;
    private EditText mEditText03;
    private static final String SD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mEditText = findViewById(R.id.id_input_text_01);
        mEditText02 = findViewById(R.id.id_input_text_02);
        mEditText03 = findViewById(R.id.id_input_text_03);
        RetrofitManager.getInstance().init();
        findViewById(R.id.id_submit).setOnClickListener(v -> {
            List<UploadParam> list = new ArrayList<>();
            list.add(new UploadParam("file",
                    new File(SD_PATH + "/input.mp3")));
            list.add(new UploadParam("file",
                    new File(SD_PATH + "/input01.mp3")));
            list.add(new UploadParam("file",
                    new File(SD_PATH + "/mix_1.wav")));
//            UploadManager.uploadFile("http://192.168.0.143:8080/Web_Test/servlet/UploadServlet", list,
//                    new UploadProgressObserver<ResponseBody>() {
//                        @Override
//                        public void onSuccess(ResponseBody body) {
//                            try {
//                                System.out.println("上传成功:" + body.string());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        public void onFail(Throwable throwable) {
//                            System.out.println("上传失败:" + throwable.getLocalizedMessage());
//                        }
//
//                        @Override
//                        public void onProgress(UploadParam params, int percent) {
//                            //
//                            System.out.println(params.getFile().getAbsolutePath() + "上传进度：" + percent);
//                        }
//                    });


            UploadManager.uploadFile("http://192.168.0.143:8080/Web_Test/servlet/UploadServlet", list,
                    new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {
                            try {
                                System.out.println("上传成功:" + responseBody.string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            System.out.println("上传失败:" + throwable.getLocalizedMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        });
    }
}
