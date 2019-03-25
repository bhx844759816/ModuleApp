package com.bhx.common_downland.client;


import com.bhx.common_downland.callback.OnResponseHeaderCallBack;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

/**
 * 通过HttpClient去获取请求头
 */
public class OkHttpRequest implements IHttpRequest {
    @Override
    public InputStream startDownland(String url, long start, long end) {
        return null;
    }

    @Override
    public void getResponseHeaders(String url, final OnResponseHeaderCallBack callBack) {
        Call call = OkHttpManager.getInstance().asyncCall(url);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.errorHeader(e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Headers headers = response.headers();
                    Map<String, String> headerMap = new HashMap<>();
                    for (int i = 0; i < headers.size(); i++) {
                        String name = headers.name(i);
                        String value = headers.value(i);
                        if (name.equalsIgnoreCase("content-length") ||
                                name.equalsIgnoreCase("accept-rang")) {
                            headerMap.put(name, value);
                        }
                    }
                    callBack.responseHeader(headerMap);
                }
            }
        });
    }
}
