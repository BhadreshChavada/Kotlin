package com.dekotlinapp.Utils


import android.content.Context
import android.util.Log
import android.widget.Toast

import com.dekotlinapp.InterfaceClass.APIService
import com.dekotlinapp.InterfaceClass.ResponseCallback
import com.dekotlinapp.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.security.KeyManagementException
import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
 * Created by AMD21 on 25/5/17.
 */

open class Webservice() {

//    val parameter: HashMap<String, String> = null!!;

//    constructor(parameter: HashMap<String, String>) {
//
//        this.parameter = parameter;
//    }

    var BASE_URL = "https://192.168.0.41:9090/";


    fun setUpRetrofit(url: String): APIService? {
        val mRetrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
        val mAPIService = mRetrofit.create(APIService::class.java)
        return mAPIService
    }

    fun SetupRetrofit(url: String, context: Context): APIService? {

        var apiService: APIService? = null
        val gson = GsonBuilder()
                .setLenient()
                .create()

        try {
            val client = OkHttpClient.Builder()
                    .sslSocketFactory(getSSLSocketFactory(context))
                    .hostnameVerifier(getHostnameVerifier())
                    .build()

            val retrofit = Retrofit.Builder()
                    .client(client)
                    .baseUrl(url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()

            apiService = retrofit.create(APIService::class.java)


        } catch (e: CertificateException) {
            e.printStackTrace()
        } catch (e: KeyStoreException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: KeyManagementException) {
            e.printStackTrace()
        }

        return apiService
    }

    private fun getHostnameVerifier(): HostnameVerifier {
        return HostnameVerifier { hostname, session ->
            true // verify always returns true, which could cause insecure network traffic due to trusting TLS/SSL server certificates for wrong hostnames
            //HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
            //return hv.verify("localhost", session);
        }
    }

    @Throws(CertificateException::class, KeyStoreException::class, IOException::class, NoSuchAlgorithmException::class, KeyManagementException::class)
    private fun getSSLSocketFactory(context: Context): SSLSocketFactory {
        val cf = CertificateFactory.getInstance("X.509")
        val caInput = context.resources.openRawResource(R.raw.emxcel) // File path: app\src\main\res\raw\your_cert.cer
        val ca = cf.generateCertificate(caInput)
        caInput.close()
        val keyStore = KeyStore.getInstance("PKCS12")
        keyStore.load(null, null)
        keyStore.setCertificateEntry("ca", ca)
        val tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm()
        val tmf = TrustManagerFactory.getInstance(tmfAlgorithm)
        tmf.init(keyStore)
        val wrappedTrustManagers = getWrappedTrustManagers(tmf.trustManagers)
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, wrappedTrustManagers, null)
        return sslContext.socketFactory
    }

    private fun getWrappedTrustManagers(trustManagers: Array<TrustManager>): Array<TrustManager> {
        val originalTrustManager = trustManagers[0] as X509TrustManager
        return arrayOf(object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return originalTrustManager.acceptedIssuers
            }

            override fun checkClientTrusted(certs: Array<X509Certificate>?, authType: String) {
                try {
                    if (certs != null && certs.size > 0) {
                        certs[0].checkValidity()
                    } else {
                        originalTrustManager.checkClientTrusted(certs, authType)
                    }
                } catch (e: CertificateException) {
                    Log.w("checkClientTrusted", e.toString())
                }

            }

            override fun checkServerTrusted(certs: Array<X509Certificate>?, authType: String) {
                try {
                    if (certs != null && certs.size > 0) {
                        certs[0].checkValidity()
                    } else {
                        originalTrustManager.checkServerTrusted(certs, authType)
                    }
                } catch (e: CertificateException) {
                    Log.w("checkServerTrusted", e.toString())
                }

            }
        })
    }


    fun callLogin(parameter: HashMap<String, String>, subUrl: String, context: Context, callback: ResponseCallback) {


        val loginService = SetupRetrofit(BASE_URL, context)

        var loginCall: Call<String>? = null

        loginCall = loginService?.webServiceCall(subUrl,parameter)
        Log.d("url", loginCall?.request()?.url().toString())

        loginCall?.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {

//                Toast.makeText(context,response.body().message,Toast.LENGTH_SHORT).show()
                callback.onSuccess(response.body())


            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show()
                callback.onFailure(t.message)
            }
        })
//        return loginModel;

    }


}