package com.huo.androidbasicstudy.arithmetic.link

import com.huo.androidbasicstudy.arithmetic.sort.MergeSort
import com.huo.androidbasicstudy.arithmetic.sort.QuickSort
import com.huo.androidbasicstudy.arithmetic.sort.Sort


//常见的链表操作

//单链表反转
//链表中环的检测
//两个有序的链表合并
//删除链表倒数第n个节点
//求链表的中间节点
class LinkOperation {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            MergeSort.mergeSortHuo(Sort.arr, Sort.arr.size);
//            Sort.mergeSort(Sort.arr, 0, Sort.arr.size)
            QuickSort.quickSort(Sort.arr,Sort.arr.size)
            Sort.printAll(Sort.arr)
//            Sort.printAll(Sort.insert(Sort.arr))
        }
    }


    fun linkLoopCheck():Boolean{
        return false
    }



    fun deleteN(link:SinglyLinkedList,n :Int){
    }


    class Node(var data: Int, var next: Node?)
}