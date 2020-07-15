package com.huo.dragger.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.huo.dragger.R
import com.huo.dragger.base.component.ComponentStudyActivity
import com.huo.dragger.base.inject.DaggerComponentTest
import com.huo.dragger.base.inject.PresenterInject
import com.huo.dragger.base.module.ModuleStudyActivity
import com.huo.dragger.showToast
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

open class DaggerActivity : AppCompatActivity() {
    @Inject
    lateinit var presenterImpl: PresenterInject
//    @Inject
//    open lateinit var jetTest :InjectTest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        DaggerComponentTest.builder().build().injectKotlin(this)

        textView.setOnClickListener {
//            showToast(application,presenterImpl.getContent())
//            showToast(presenterImpl.getContent())
//            showToast(jetTest.content)
            startActivity(
                Intent(application,
                    ComponentStudyActivity::class.java)
            )

        }
    }

}