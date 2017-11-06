package com.dekotlinapp.InterfaceClass;


/**
 * Created by AMD21 on 29/5/17.
 */

public interface ResponseCallback {

    void onSuccess(String result);

    void onFailure(String message);

}
