//package com.ihealth.chronos.patient.base.base
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.paging.DataSource
//import androidx.paging.LivePagedListBuilder
//import androidx.paging.PagedList
//import androidx.paging.PagedListAdapter
//import androidx.recyclerview.widget.DiffUtil
//import com.ihealth.chronos.patient.base.R
//import java.util.concurrent.CountDownLatch
//
//open abstract class BasePageFragment:BaseFragment(){
//
//    override fun getLayoutID(): Int {
//        loadDataNow()
//        return R.layout.fragment_page_default
//    }
//    private fun makePageList() {
//        if(isAdded)
//            LivePagedListBuilder(MyDataSourceFactory(), getPageConfig()).build().observe(this, Observer {
//                println("base 34==================observer====${it?.size}")
//                getAdapter().submitList(it)
//            })
//        RxPagedListBuilder
//    }
//    inner class MyDataSourceFactory:DataSource.Factory<Int,Student>(){
//        override fun create(): DataSource<Int, Student> {
//            return  getDataSource()
//        }
//    }
//    public fun getPageConfig(): PagedList.Config{
//        return PagedList.Config.Builder()
//                .setPageSize(8) //分页数据的数量。在后面的DataSource之loadRange中，count即为每次加载的这个设定值。
//                .setPrefetchDistance(8) //提前多少数据开始继续加载数据。如果是上滑的话对应的就是离最后个item还有2个位置的时候开始记载更多数据。下拉一样的道理
//                .setInitialLoadSizeHint(8)
//                .setEnablePlaceholders(false)
//                .build()
//    }
//    private fun getAdapter(): MyPagingAdapter {
//        return  rv_default.adapter as MyPagingAdapter
//    }
//    public abstract fun getDataSource():DataSource<Int,Student>
//    var countDownLatch: CountDownLatch?=CountDownLatch(2)
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        countDownLatch?.countDown()
//        rv_default.apply {
//            layoutManager= LinearLayoutManager(activity)
//            //弄一条灰色的间隔线
//            addItemDecoration(object : RecyclerView.ItemDecoration(){
//                var paint= Paint()
//                override fun getItemOffsets(outRect: Rect, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
//                    super.getItemOffsets(outRect, view, parent, state)
//                    outRect.bottom=3
//                }
//
//                override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
//                    super.onDraw(c, parent, state)
//                    paint.color= Color.LTGRAY
//                    var childCount=parent.childCount
//                    repeat(childCount){
//                        var child=parent.getChildAt(it)
//                        if(child!=null){
//                            c.drawRect(parent.paddingLeft.toFloat(),child.bottom.toFloat(),parent.width.toFloat()-parent.paddingRight,child.bottom+3f,paint)
//                        }
//                    }
//                }
//            })
//            adapter=MyPagingAdapter(callback)
//
//        }
//    }
//    fun loadDataNow(){
//        Thread{
//            countDownLatch?.await()
//            makePageList()
//            countDownLatch=null
//        }.start()
//
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        countDownLatch?.run {
//            repeat(this.count.toInt()){
//                this.countDown()
//            }
//        }
//    }
//
//    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
//        println("${javaClass.name} setUserVisibleHint=============$isVisibleToUser")
//        if(isVisibleToUser){
//            countDownLatch?.countDown()
//        }
//        super.setUserVisibleHint(isVisibleToUser)
//    }
//    open inner  class  MyPagingAdapter : PagedListAdapter<Student, BaseRvHolder> {
//        constructor(diffCallback: DiffUtil.ItemCallback<Student>) : super(diffCallback)
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRvHolder {
//
//            return BaseRvHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_paging,parent,false))
//        }
//
//        override fun onBindViewHolder(holder: BaseRvHolder, position: Int) {
//            getItem(position)?.apply {
//                holder.setText(R.id.tv_name,name)
//                holder.setText(R.id.tv_age,"${age}")
//            }
//            println("onBindViewHolder=============$position//${itemCount} ===${getItem(position)}")
//        }
//
//    }
//
//    val callback=object : DiffUtil.ItemCallback<Student>(){
//        override fun areItemsTheSame(oldItem: Student?, newItem: Student?): Boolean {
//            return  oldItem?.id==newItem?.id
//        }
//
//        override fun areContentsTheSame(oldItem: Student?, newItem: Student?): Boolean {
//            return  oldItem?.age==newItem?.age
//        }
//    }
//}