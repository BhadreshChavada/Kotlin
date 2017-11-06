package com.dekotlinapp.InterfaceClass;

import android.view.View;

/**
 * Created by AMD21 on 31/5/17.
 */

public interface Validation {

    void onValid(String value,View v);

    void inValid(String value,View v);
}
