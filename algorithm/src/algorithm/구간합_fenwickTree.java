package algorithm;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
[���� ]
� N���� ���� �־��� �ִ�. �׷��� �߰��� ���� ������ ����� �Ͼ�� �� �߰��� � �κ��� ���� ���Ϸ� �Ѵ�. ���࿡ 1,2,3,4,5 ��� ���� �ְ�, 
3��° ���� 6���� �ٲٰ� 2��°���� 5��°���� ���� ���϶�� �Ѵٸ� 17�� ����ϸ� �Ǵ� ���̴�. �׸��� �� ���¿��� �ټ� ��° ���� 2�� �ٲٰ� 3��°���� 5��°���� ���� ���϶�� �Ѵٸ� 12�� �� ���̴�.

[�Է� ]
ù° �ٿ� ���� ���� N(1<=N<=1,000,000)�� M(1<=M<=10,000), K(1<=k<=10,000) �� �־�����. M�� ���� ������ �Ͼ�� ȸ���̰�, K�� ������ ���� ���ϴ� ȸ���̴�. 
�׸��� ��° �ٺ��� N+1��° �ٱ��� N���� ���� �־�����. 
�׸��� N+2��° �ٺ��� N+M+K+1��° �ٱ��� �� ���� ���� a,b,c�� �־����µ�, a�� 1�� ��� b��° ���� c�� �ٲٰ� a�� 2�� ��쿡�� b���� c������ ���� ���Ͽ� ����ϸ� �ȴ�.

[���] 
ù° �ٺ��� K�ٿ� ���� ���� ������ ���� ����Ѵ�. (�� ������ long long ������ ���� �ʴ´�)

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


public class ������_fenwickTree {

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
    	// num�� ���� BIT[index]�־��� ���ڿ� ���� ���� �ٲ��� ���ڿ��� ����
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
