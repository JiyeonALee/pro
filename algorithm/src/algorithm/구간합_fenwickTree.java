package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ±¸°£ÇÕ_fenwickTree {

    static long[] input;
    static long[] BIT; // Binary Indexed Tree

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            input = new long[N+1];
            BIT = new long[N+1];
            for(int i=1;i<=N; i++) {
                input[i] = Integer.parseInt(br.readLine());
                rebuildBIT(i, input[i]);
            }

            for(int i=0 ; i<M+K; i++) {
                st = new StringTokenizer(br.readLine());
                int sc = Integer.parseInt(st.nextToken());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                if(sc == 1) {
                    rebuildBIT(first, second-input[first]);
                    input[first] = second;
                } else if(sc == 2) {
                    System.out.println(sum(second)-sum(first-1));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rebuildBIT(int index, long num) {
        while(index < BIT.length) {
            BIT[index] += num;
            index += (index&-index);
        }
    }

    private static long sum(int index) {
        long ans = 0;
        while(index > 0) {
            ans += BIT[index];
            index -= (index&-index);
        }
        return ans;
    }
}
