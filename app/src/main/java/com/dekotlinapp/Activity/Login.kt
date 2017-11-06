package com.deapp.activityKotlin


import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.Toast
import com.dekotlinapp.BaseClass.ActivityBaseClass
import com.dekotlinapp.InterfaceClass.Internet
import com.dekotlinapp.InterfaceClass.InternetConnection
import com.dekotlinapp.InterfaceClass.ResponseCallback
import com.dekotlinapp.InterfaceClass.Validation
import com.dekotlinapp.Model.LoginModel
import com.dekotlinapp.R
import com.dekotlinapp.Utils.AppConstant
import com.dekotlinapp.Utils.CheckInternet
import com.dekotlinapp.Utils.Webservice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*


/**
 * Created by AMD21 on 24/5/17.
 */

class Login : ActivityBaseClass(), View.OnClickListener, ResponseCallback, Internet, Validation {


    var str_email: String? = null;
    var str_password: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun init() {

        var pInfo: PackageInfo? = null
        try {
            pInfo = packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        val verCode = pInfo?.versionCode


        tv_buildversion.setText("Version Code  :-  " + verCode)


        btn_login.setOnClickListener(this)


    }

    override fun onClick(v: View) {

        if (v.id == R.id.btn_login) {


            CheckInternet(this).isNetwoorkAvilable(this)

//            CallIntent(menuActivity::class.java)


        }


    }

    override fun onSuccess(result: String?) {

        var model: LoginModel
        model = Gson().fromJson(result, LoginModel::class.java)

        Toast.makeText(this, model.message, Toast.LENGTH_SHORT).show()

    }

    override fun onFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    override fun onInternetConneected() {

        AppConstant().checkValidation(et_user_name.text.toString(), "phone", this, et_user_name)
        AppConstant().checkValidation(et_password.text.toString(), "password", this, et_password)

        if (str_email != null && str_password != null) {

            val str_userToken = Base64.encodeToString((et_user_name.text.toString() + "-" + et_password.text.toString()).toByteArray(), Base64.DEFAULT)
            val loginMap = HashMap<String, String>()
            loginMap.put("userToken", str_userToken)
            loginMap.put("password", et_password.text.toString())
            loginMap.put("contactNo", et_user_name.text.toString())

            Webservice().callLogin(loginMap, "/login/app/de-login-check", this, this)
        }
    }

    override fun onInternetDisConnect() {

        Toast.makeText(this, "No InterNet Connected", Toast.LENGTH_SHORT).show()
    }

    override fun onValid(value: String?, v: View) {

        if (v.id == R.id.et_user_name) {
            str_email = value;


        } else if (v.id == R.id.et_password) {
            str_password = value;


        }

    }

    override fun inValid(value: String?, v: View) {


        if (v.id == R.id.et_user_name) {

            et_user_name.error = value

        } else if (v.id == R.id.et_password) {

            et_password.error = value
        }

//        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()


    }
}