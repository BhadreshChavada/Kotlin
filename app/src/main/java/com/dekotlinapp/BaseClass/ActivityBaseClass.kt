package com.dekotlinapp.BaseClass

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

/**
 * Created by AMD21 on 24/5/17.
 */

open class ActivityBaseClass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    fun CallIntent(java: Class<*>) {

        val intent = Intent(this, java)
        startActivity(intent)

    }

    fun CallIntentClearFlag(java: Class<*>) {
        val intent = Intent(this, java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }


    fun CallIntentWithfinish(java: Class<*>) {
        val intent = Intent(this, java)
        this.finish()
        startActivity(intent)
    }


    fun CallIntentWithData(secondactivity: Class<*>, bundle: Bundle, key: String) {

        val intent = Intent(this, secondactivity)
        intent.putExtra(key, bundle)
        startActivity(intent)
    }

    fun DisplayToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    fun DisplayLog(Tag: String, Value: String) {
        Log.v(Tag, Value)
    }

    fun getText(edt: EditText): String? {


        return if (edt == null) "" else edt.getText().toString().trim({ it <= ' ' })
    }

    fun nullValidate(edt: EditText): Boolean {
        if (edt.text.length > 0)
            return true
        else
            return false
    }

    fun hideKeyboard() {

        // Check if no view has focus:
        val view = currentFocus
        if (view != null) {

            val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }


}