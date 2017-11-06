package com.dekotlinapp.Utils

import android.content.Context
import android.net.ConnectivityManager
import com.dekotlinapp.InterfaceClass.InternetConnection

/**
 * Created by AMD21 on 25/5/17.
 */

open class CheckInternet(context: Context) {

    var context: Context = context

    fun isNetwoorkAvilable(callback: InternetConnection) {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo

        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            callback.onInternetConneected()
        } else {
            callback.onInternetDisConnect()
        }
    }

}