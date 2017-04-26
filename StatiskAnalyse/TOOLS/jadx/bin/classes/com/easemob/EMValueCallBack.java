package com.easemob;

public interface EMValueCallBack<T> {
    void onError(int i, String str);

    void onSuccess(T t);
}
