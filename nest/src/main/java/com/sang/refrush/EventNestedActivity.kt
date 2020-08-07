package com.sang.refrush

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnFlingListener
import com.sang.refrush.adapter.XAdapter
import com.sang.refrush.holder.BaseHolder
import com.sang.refrush.utils.DividerGridItemDecoration
import com.sang.refrush.utils.FRLog
import java.util.*

class EventNestedActivity : AppCompatActivity() {
    private var recyclerView : RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_nested)
        recyclerView = findViewById(R.id.recyclerView)
        initView()

        recyclerView?.onFlingListener = object : OnFlingListener() {
            override fun onFling(velocityX: Int, velocityY: Int): Boolean {
                FRLog.e("---------onFling---------")
                return false
            }
        }
    }

    private fun initView() {
        val manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.VERTICAL
        recyclerView?.layoutManager = manager
        val date: ArrayList<String> = ArrayList()
        for (i in 0..49) {
            date.add("我是数据$i")
        }
        recyclerView?.adapter = object : XAdapter<String>(this, date) {
            override fun initHolder(parent: ViewGroup, viewType: Int): BaseHolder<String> {
                return object :
                    BaseHolder<String>(context, parent, R.layout.item_single_text) {
                    override fun initView(
                        itemView: View,
                        position: Int,
                        data: String
                    ) {
                        super.initView(itemView, position, data)
                        val tv = itemView.findViewById<TextView>(R.id.tv_text)
                        tv.text = data
                    }
                }
            }
        }
        recyclerView?.addItemDecoration(DividerGridItemDecoration(this))
    }
}