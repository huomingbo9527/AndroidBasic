package com.huo.androidbasicstudy.arithmetic;

public class BinaryFind {
    public static int binarySort(int[] arr,int n,int value){
        return binaryInternalSort(arr,0,n -1,1);
    }

    private static int binaryInternalSort(int[] arr,int start,int end,int value){
        if(start > end)
            return -1;
        int mid = start + (end - start) /2;
        if(arr[mid] == value){
            return mid;
        }else if(arr[mid] < value){
            return binaryInternalSort(arr,mid +1,end,value);
        }else {
            return binaryInternalSort(arr,start,mid -1,value);
        }
    }


    public static int binaryInternalSortWhile(int[] arr,int n,int value){
        int start = 0;
        int end = n - 1;
        while (start <= end){
            int mid = start + (end - start) >> 2;
            if(arr[mid] == value){
                return mid;
            }else if(arr[mid] > value){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return  -1;
    }

}
