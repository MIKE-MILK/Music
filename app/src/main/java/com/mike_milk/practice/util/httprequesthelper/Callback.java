package com.mike_milk.practice.util.httprequesthelper;

public interface Callback {
    void onResponse(String response);
    void onFailed(Throwable t);
}
