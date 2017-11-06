package com.dekotlinapp.Utils

import android.content.Context
import android.view.View
import com.dekotlinapp.InterfaceClass.Validation
import java.util.regex.Pattern

/**
 * Created by AMD21 on 25/5/17.
 */

open class AppConstant {

    internal var context: Context? = null

    constructor(context: Context) {

        this.context = context
    }

    constructor()

    var SHAREDPREFERENCE = "SHAREDPREFERENCE";

    val USERID = "userId"


    fun SaveSharedpreference(key: String, Value: String) {

        var sharedpreference = context!!.getSharedPreferences(SHAREDPREFERENCE, 0)
        sharedpreference.edit().putString(key, Value).commit()

    }

    fun GetSharepreference(key: String): String? {
        var sharedpreference = context!!.getSharedPreferences(SHAREDPREFERENCE, 0)
        return sharedpreference.getString(key, "")
    }

    fun clearSharedprefernce() {

        var sharedpreference = context!!.getSharedPreferences(SHAREDPREFERENCE, 0)
        sharedpreference.edit().clear()
    }

    fun checkValidation(value: String, type: String, callback: Validation, view: View) {

        if (type.equals("email")) {

            val VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
            val matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value)
            if (matcher.find()) {
                callback.onValid(value, view)
            } else {
                callback.inValid("Email is not Valid", view)
            }

        } else if (type.equals("password")) {

            if (value.length > 5) {
                callback.onValid(value, view)
            } else {
                callback.inValid("Password is not Valid", view)
            }

        } else if (type.equals("null")) {
            if (value.length > 0) {
                callback.onValid(value, view)
            } else {
                callback.inValid("This field can't null", view)
            }

        } else if (type.equals("phone")) {
            if (value.length == 10) {
                callback.onValid(value, view)
            } else {
                callback.inValid("Enter 10 digit Phone no.", view)
            }

        }

    }
}

