package com.tcl.tikxml_samples

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tcl.tikxml_samples.api.ApiService
import com.tcl.tikxml_samples.xstream.XStreamConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var api: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        api = Retrofit.Builder().baseUrl("https://www.tcl.com/")
            .addConverterFactory(XStreamConverterFactory.create()).build()
            .create(ApiService::class.java)

        findViewById<Button>(R.id.btn_mobile_info).setOnClickListener {
            api.mobileInfo("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode=18368865748&userID=")
                .enqueue(object : Callback<String> {
                    override fun onResponse(
                        call: Call<String>,
                        response: Response<String>
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            response.body(),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}