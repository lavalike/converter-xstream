package com.tcl.tikxml_samples

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tcl.tikxml_samples.api.ApiService
import com.tcl.tikxml_samples.databinding.ActivityMainBinding
import com.tcl.tikxml_samples.entity.RandomFontsResp
import com.tcl.tikxml_samples.xstream.XStreamConfig
import com.tcl.tikxml_samples.xstream.XStreamConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var api: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).apply {
            binding = this
        }.root)

        api = Retrofit.Builder().baseUrl("https://www.tcl.com/")
            .addConverterFactory(XStreamConverterFactory.create()).build()
            .create(ApiService::class.java)

        with(binding) {
            btnMobileInfo.setOnClickListener {
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

            btnTraditionalChinese.setOnClickListener {
                api.traditionalChinese(
                    "http://ws.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx/toTraditionalChinese",
                    "快乐"
                ).enqueue(object : Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
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

            XStreamConfig.getInstance().registerTypes(RandomFontsResp::class.java)

            btnRandomChinese.setOnClickListener {
                api.randomChineseFonts(
                    "http://ws.webxml.com.cn/WebServices/RandomFontsWebService.asmx/getChineseFonts",
                    5
                ).enqueue(object : Callback<RandomFontsResp> {
                    override fun onResponse(
                        call: Call<RandomFontsResp>,
                        response: Response<RandomFontsResp>
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            response.body().toString(),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                    override fun onFailure(call: Call<RandomFontsResp>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}