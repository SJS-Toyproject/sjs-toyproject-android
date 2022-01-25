package com.cookandroid.myapplication

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "6d71e1bff2d735ecb9f815ce6a40d68c")
    }
}