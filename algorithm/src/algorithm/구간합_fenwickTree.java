package algorithm;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
[문제 ]
어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고, 
3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다. 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.

[입력 ]
첫째 줄에 수의 개수 N(1<=N<=1,000,000)과 M(1<=M<=10,000), K(1<=k<=10,000) 가 주어진다. M은 수의 변경이 일어나는 회수이고, K는 구간의 합을 구하는 회수이다. 
그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 
그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a,b,c가 주어지는데, a가 1인 경우 b번째 수를 c로 바꾸고 a가 2인 경우에는 b부터 c까지의 합을 구하여 출력하면 된다.

[출력] 
첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. (단 정답은 long long 범위를 넘지 않는다)

5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5


 */


public class 구간합_fenwickTree {

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
    	// num은 원래 BIT[index]있었던 숫자와 새로 들어와 바꿔질 숫자와의 차이
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
