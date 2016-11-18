package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class test {
    public static void main(String[] args) {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int T = Integer.parseInt(br.readLine());
            System.out.println();
            for(int t=0 ; t<T ; t++) {
                int M = Integer.parseInt(br.readLine());
                int[] arr = new int[M];
                int im = 0;
                for(int m=0; m<=M/10 ; m++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    while(true) {
                        arr[im++] = Integer.parseInt(st.nextToken());
                        if(im%10 == 0 || im == M){
                            break;
                        }
                    }
                }
                 
                int cnt = (M+1)/2;
                System.out.println(cnt);
                 
                //StringBuffer sb = new StringBuffer();
                for(int i=0; i<cnt ; i++) {
                    if(i == 0) System.out.print(arr[0]);
                    else {
                        if(i%10==0) {
                            //System.out.println(sb.toString());
                            //sb.delete(0, sb.length());
                            System.out.println();
                        }
                        int[] sorted = quickSort(Arrays.copyOf(arr, i*2+1), 0, i*2);
                        //sb.append(sorted[i]).append(" ");
                        System.out.print(sorted[i]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
                 
                /*if(sb.length()>0) {
                    System.out.println(sb.toString());
                }*/
            }
             
        } catch (IOException e) {
            e.printStackTrace();
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