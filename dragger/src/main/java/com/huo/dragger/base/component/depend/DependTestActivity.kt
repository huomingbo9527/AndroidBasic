package com.huo.dragger.base.component.depend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class DependTestActivity  : AppCompatActivity() {
    @DependScope
    @Inject
    lateinit var dependModule: ModuleBean
    @DependScope
    @Inject
    lateinit var dependName: String
    @DependScope
    @Inject
    lateinit var dependArray: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sonBuild = DaggerComponentSon.builder().build()
        val sonSonBuild = DaggerComponentSonSon.builder().build()

//        val build = DaggerComponentMain.builder().appDependencies(sonBuild).appDependencies(sonSonBuild).build()
//        build.inject(this)
//        val dependContent = build.getDependContent()

    }
}