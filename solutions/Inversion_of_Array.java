package main;

import java.util.Arrays;
import java.util.Scanner;

public class Inversion_of_Array
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    static long invCount = 0;
    static void merge(long[] arr, int left, int mid, int right){
        
        long[] leftarr = Arrays.copyOfRange(arr, left, mid+1);
        long[] rightarr = Arrays.copyOfRange(arr, mid+1, right+1);
        
        System.out.println(Arrays.toString(leftarr)+"\n" +Arrays.toString(rightarr));
        
        int i = 0;
        int j = 0;
        int k = left;
        
        while(i<leftarr.length && j<rightarr.length){
            if(leftarr[i] <= rightarr[j]){
                arr[k++] = leftarr[i++];
            }
            else{
                arr[k++] = rightarr[j++];
                invCount += (mid+1)-(left+i);
            }
        }
        
        while(i<leftarr.length){
            arr[k++] = leftarr[i++];
        }
        
        while(j<rightarr.length){
            arr[k++] = rightarr[j++];
        }
        
        System.out.println("invcount:"+invCount);
 
    }
    
    static long mergesort(long[] arr, int left, int right){
        
        int mid;
        if(left<right){
            
            mid = (left+right)/2;
            mergesort(arr, left, mid);
            mergesort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
        
        return invCount;
        
    }
    
    static long inversionCount(long arr[], long n)
    {
        return mergesort(arr, 0, (int)n-1);
    }
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long arr[] = new long[(int)n];
        
        for(long i = 0; i < n; i++)
         arr[(int)i] = sc.nextLong();
         
        System.out.println(inversionCount(arr, n));
        
        System.out.println(Arrays.toString(arr));
            
        sc.close();
    }
}



//class Inversion_of_Array
//{
//    // arr[]: Input Array
//    // N : Size of the Array arr[]
//    
//    static long merge(long[] arr, long[] temp, int left, int mid, int right){
//        
//        int i = left;
//        int j = mid;
//        int k = left;
//        
//        long invCount = 0;
//        
//        while(i<mid && j<=right){
//            if(arr[i]< arr[j]){
//                temp[k++] = arr[i++];
//            }
//            else{
//                temp[k++] = arr[j++];
//                invCount += (mid-i);
//            }
//        }
//        
//        while(i<mid){
//            temp[k++] = arr[i++];
//        }
//        
//        while(j<=right){
//            temp[k++] = arr[j++];
//        }
//        
//        for(i=left; i<=right; i++){
//            arr[i] = temp[i];
//        }
//        
//        return invCount;
//    }
//    
//    static long mergesort(long[] arr, long[] temp, int left, int right){
//        
//        long invCount = 0;
//        int mid;
//        if(left<right){
//            
//            mid = (left+right)/2;
//            invCount+=mergesort(arr, temp, left, mid);
//            invCount+=mergesort(arr, temp, mid+1, right);
//            invCount+=merge(arr, temp, left, mid+1, right);
//        }
//        
//        return invCount;
//        
//    }
//    
//    static long inversionCount(long arr[], long n)
//    {
//        long[] temp = new long[(int)n];
//        
//        return mergesort(arr, temp, 0, (int)n-1);
//    }
//}
