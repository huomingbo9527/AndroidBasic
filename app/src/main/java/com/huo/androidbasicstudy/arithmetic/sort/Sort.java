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



}
