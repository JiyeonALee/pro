package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Q2969_중앙값구하기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T ; t++) {
			
			int M = sc.nextInt();
			int[] arr = new int[M];
			
			for(int m=0; m<M ; m++){
				arr[m] = sc.nextInt();
			}
			
			 int cnt = (M+1)/2;
             System.out.println(cnt);
             
             for(int i=0; i<cnt ; i++) {
                 if(i == 0) System.out.print(arr[0]);
                 else {
                     if(i%10==0) {
                         System.out.println();
                     }
                     int[] sorted = quickSort(Arrays.copyOf(arr, i*2+1), 0, i*2);
                     System.out.print(sorted[i]);
                 }
                 System.out.print(" ");
             }
		}
	}

	static int partition(int arr[], int left, int right){
         int i = left, j = right;
         int tmp;
         int pivot = arr[(left + right) / 2];
         
         while (i <= j) {
               while (arr[i] < pivot)
                     i++;
               while (arr[j] > pivot)
                     j--;
               if (i <= j) {
                     tmp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = tmp;
                     i++;
                     j--;
               }
         };
          
         return i;
   }
     
   static int[] quickSort(int arr[], int left, int right) {
         int index = partition(arr, left, right);
         if (left < index - 1)
               quickSort(arr, left, index - 1);
         if (index < right)
               quickSort(arr, index, right);
         return arr;
   }

}
