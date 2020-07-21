package com.huo.androidbasicstudy.arithmetic.sort;

public class Sort {
    public static int[] arr = new int[]{2,1,4,10,9,8,4};

    public static void main(String[] arg){
        bubble(arr);
    }

    public static void printAll(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //也是分为两部分一部分是有序的，一部分是无序的，遍历length次，将无序部分相同的两个数比较，满足条件的交换位置，直到最后
    public static int[] bubble(int[] arr){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int lengthJ = length - i -1;
            boolean sort = true;
            for (int j = 0; j < lengthJ; j++) {
                if (arr[j] < arr[j +1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+ 1] = tmp;
                    sort = false;
                }
            }
            if(sort){
               break;
            }
        }
        return arr;
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     */
    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) return;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;    // 没有数据交换，提前退出
        }
    }


    //插入数据，思想是分成两部分一部分是有序的，一部分是无序的，在无序的部分那出一个和有序部分比较，
    // 满足条件移动有序的位置一直到不满足条件，几率这个位置，将这个值赋值到这里。
    public static int[] insert(int[] arr){
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int p = arr[i];
            int j = i - 1;
            for (; j >=0; j--) {
                if(p<arr[j]){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = p;
        }
        return arr;
    }

    // 选择排序，a表示数组，n表示数组大小
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }


    public static void mergeSort(int[] arr,int p,int q){
        if(p >= q){
            return;
        }
        int center = (p + q)/2;
        mergeSort(arr,p,center);
        mergeSort(arr,center + 1,q);
    }

    public static int[] quickSort(int[] arr){


        return arr;
    }

}
