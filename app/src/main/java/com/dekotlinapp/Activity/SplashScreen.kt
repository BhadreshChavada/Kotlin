package com.deapp.activityKotlin

import android.os.Bundle
import android.os.Handler
import com.dekotlinapp.BaseClass.ActivityBaseClass
import com.dekotlinapp.R

/**
 * Created by AMD21 on 24/5/17.
 */

class SplashScreen : ActivityBaseClass() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var handler = Handler();
        handler.postDelayed(Runnable { CallIntentWithfinish(Login::class.java) }, 3000);
    }


}