package com.huo.androidbasicstudy.arithmetic.link

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 */

class SinglyStudyLinkedList {

    private var head: Node? = null

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

//            val link = SinglyStudyLinkedList()
//            println("hello")
//            val data = intArrayOf(1, 2, 5, 2, 1,0)
//            for (i in data.indices) {
//                //link.insertToHead(data[i]);
//                link.insertTail(data[i])
//            }
//            link.mergeSortLink
////            link.insertBefore(link.head!!.next, 10)
////            link.deleteByValue(10)
////            link.inverseLinkList(link.head?.next?.next?.next?.next)
//            link.deleteN(6)
            val link = mergeLinkedListTest()

            println("打印原始:")
            link.printAll()
            if (link.palindrome()) {
                println("回文")
            } else {
                println("不是回文")
            }
        }

        private fun mergeLinkedListTest(): SinglyStudyLinkedList {
            val link = SinglyStudyLinkedList()
            val link2 = SinglyStudyLinkedList()
            val data = intArrayOf(1, 2, 3, 4, 6, 10)
            val data2 = intArrayOf(1, 7, 8, 9, 11, 13)

            for (i in data.indices) {
                //link.insertToHead(data[i]);
                link.insertTail(data[i])
            }
            for (i in data2.indices) {
                //link.insertToHead(data[i]);
                link2.insertTail(data2[i])
            }
            link.mergeSortLink(link.head, link2.head)
            return link
        }
    }

    fun findByValue(value: Int): Node? {
//        if(head == null) return null
//        var next :Node? = head!!
//        while (next?.next != null){
//            next = next.next!!
//            if(next.data == value)
//                return next
//            next = next.next!!.next
//        }
//        return null
        var p = head
        while (p != null && p.data != value) {
            p = p.next
        }
        return p
    }

    fun findByIndex(index: Int): Node? {
        var p = head
        var pos = -1
        while (p != null && pos != index) {
            p = p.next
            pos++
        }
        return p

    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    fun insertToHead(value: Int) {
        val newNode = Node(value, null)
        insertToHead(newNode)
    }

    fun insertToHead(newNode: Node) {
        if (head == null) {
            head = newNode
        } else {
            newNode.next = head
            head = newNode

//            val temp = head
//            newNode.next = temp
//            head = newNode
        }
    }

    //顺序插入
    //链表尾部插入
    fun insertTail(value: Int) {
        if (head == null) {
            insertToHead(value)
        } else {
            var p = head
            while (p?.next != null) {
                p = p.next
            }
            p?.next = Node(value, null)
        }
    }

    fun insertAfter(p: Node?, value: Int) {
        val newNode = Node(value, null)
        insertAfter(p, newNode)
    }

    fun insertAfter(p: Node?, newNode: Node) {
        if (p == null)
            return
        newNode.next = p.next
        p.next = newNode
//        if(head == null)
//            return
//
//        var cur = head!!.next
//        while (cur != null){
//            if(cur.data == p.data){
//                newNode.next = cur.next
//                cur.next = newNode
//                break
//            }
//            cur = cur.next
//        }
    }

    fun insertBefore(p: Node?, value: Int) {
        if (p == null)
            return
        insertBefore(p, Node(value, null))
    }

    fun insertBefore(p: Node?, newNode: Node) {
        if (p == null)
            return
        if (head == null)
            return
        if (p === head) {
            insertToHead(newNode)
        }
        var cur = head
        while (cur != null && cur.next !== p) {
            cur = cur.next
        }

        if (cur != null) {
            newNode.next = cur.next
            cur.next = newNode
        }
//        if (p == null) return
//        if (head === p) {
//            insertToHead(newNode)
//            return
//        }
//
//        var q = head
//        while (q != null && q.next !== p) {
//            q = q.next
//        }
//
//        if (q == null) {
//            return
//        }
//
//        newNode.next = p
//        q.next = newNode

    }

    fun deleteByNode(p: Node?) {
        if (p == null)
            return
        if (head == null)
            return
        if (head === p) {
            head = head!!.next
        }

        var q = head
        while (q != null && q.next !== p) {
            q = q.next
        }
        if (q == null) {
            return
        }
        q.next = q.next?.next
    }

    fun deleteByValue(value: Int) {
        if (head == null)
            return
        if (head?.data == value) {
            head = head?.next

        }
        var p = head
        var q = p?.next
        while (p != null && q != null && q.data != value) {
            p = q
            q = q.next
        }
        if (q == null)
            return
        p?.next = q.next

//        var p = head
//        var q :Node?= null
//        while (p != null && p.data != value){
//            q = p
//            p = p.next
//        }
//
//        if (p == null)
//            return
//
//        if(q == null){
//            head = head?.next
//        }else{
//            q.next = p.next
//        }
    }

    fun printAll() {
        var p = head
        while (p != null) {
            print("${p.data} ")
            p = p.next
        }
        println()
    }

    //判断true or false  判断两个链表是否一样
    private fun TFResult(left: Node?, right: Node?): Boolean {
        var l = left
        var r = right
        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next
                r = r.next
                continue
            } else {
                break
            }
        }

        return l == null && r == null


//        var l: Node? = left
//        var r: Node? = right
//
//        println("left_:${l?.data}")
//        println("right_:${r?.data}")
//        while (l != null && r != null) {
//            if (l.data == r.data) {
//                l = l.next
//                r = r.next
//                continue
//            } else {
//                break
//            }
//
//        }
//
//        println("什么结果")
//        return l == null && r == null
    }

    //
    //　判断是否为回文
    fun palindrome(): Boolean {
        if (head == null)
            return false
        if (head?.next == null) {
            return true
        }
        var p = head
        var q = head
        //判断 q能不能移动两位，如果能就一定 p只移动一位，当q移动到最后的时候，p正好移动中间
        while (q?.next != null && q.next?.next != null){
            p = p?.next
            q = q.next?.next
        }
        var l:Node? = null
        var r:Node? = null

        if (q != null){
            //正中间  并且是奇数位置
            r = p?.next
            l = inverseLinkList(p)?.next
        }else{
            r = p?.next
            l = inverseLinkList(p)
        }
        return TFResult(l,r)
    }

    //
//    //带结点的链表翻转
//    fun inverseLinkList_head(p: Node): Node {
//    }
//
//无头结点的链表翻转  返回的是头结点到当前节点的反转链表
    fun inverseLinkList(end: Node?): Node? {
        var preNode: Node? = null
        var curNode: Node? = head
        var nextNode: Node? = null
        while (curNode !== end) {
            nextNode = curNode?.next
            curNode?.next = preNode
            preNode = curNode
            curNode = nextNode
        }
        curNode?.next = preNode
        return curNode


//    var pre: Node? = null
//    var r = head
//    println("z---${r?.data}")
//    var next: Node?
//    while (r !== p) {
//        next = r?.next
//        r?.next = pre
//        pre = r
//        r = next
//    }
//    r?.next = pre
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
//    return r


        //下面自己实现 默认传入的是链表头 这个链表的反转
//        var next = p?.next
//        var q:Node? = p //设置
//        p?.next = null//当前节点为尾结点 要把他的next设置为null
//        while (next != null){
//            val temp = next.next
//            next.next = q
//            q = next
//            next = temp
//        }
//        head = q
//        return head
    }

    fun createNode(value: Int): Node = Node(value, null)

    //删除链表倒数第n个节点
    fun deleteN(lastN :Int){
        //网上标准答案
        var indexNode = head
        var deleteNode = head
        var tempLastN = lastN
        var position = 0;
        while (indexNode != null && --tempLastN>=0){
            indexNode = indexNode.next
            position ++
        }
        if (indexNode == null){//倒数K大于等于链表总长度
            if(position == lastN)//倒数正好等于链表的长度时候 删掉头结点
                head = head?.next
            return
        }
        while (indexNode?.next != null){
            indexNode = indexNode.next
            deleteNode = deleteNode?.next
        }
        deleteNode?.next = deleteNode?.next?.next
    }

    //链表中环的检测   1,遍历节点标记 2,HashMap存储 2,快慢指针检索：两个指针相撞就是环
    fun linkLoopCheck(node:Node?):Boolean{
        if (node == null)
            return false
        if (node.next == node)
            return true

        //声明两个指针，一个快指针和一个慢指针，快指针==null 肯定不是环，如果慢指针===快指针了就肯定是环
        var p = node
        var q = node.next
        while (p != null && q != null){
            if(p == q){
                return true
            }
            p = p.next
            q = q.next?.next
        }
        return false
    }

    //求链表的中间节点
    fun centerNode(node :Node?):Node{
        var p = node
        var q  = node
        //这个要注意  不能用默认链表中间节点通过q不等于null来判断，一定是q的下一个节点和下下个节点是否等于null
        while (q?.next!= null && q.next?.next != null){
            q = q.next?.next
            p = p?.next
        }
        return p!!
    }

    //两个有序的链表合并
    fun mergeSortLink(left:Node?,right:Node?):Node?{
        if (left == null && right == null)
            return null
        if (left == null)
            return right
        if(right == null)
            return left
        var p = right;
        var q = left
        val new : Node
        var curNode : Node
        if(p.data > q.data){
            new = q
            curNode = new
            q = q.next
        } else{
            new =p
            curNode = new
            p = p.next
        }
        while (p!= null && q!=null){
            if(p.data > q.data){
                curNode.next = q
                curNode = q
                q = q.next
            }else{
                curNode.next = p
                curNode = p
                p = p.next

            }
        }
        if (p != null){
            curNode.next = p
        }
        if (q != null)
            curNode.next = q
        return new

    }


    class Node(var data: Int, var next: Node?)
}