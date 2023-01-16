package com.xuannie.hdbcarpark

import android.app.Application
import com.xuannie.hdbcarpark.ui.data.database.DefaultAppContainer
import com.xuannie.hdbcarpark.ui.data.database.HdbAppContainer

class HDBApplication: Application() {
    lateinit var container: HdbAppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}