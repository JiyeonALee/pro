package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

[�Է�]
�Է��� �� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����.
�׽�Ʈ���̽��� ù �ٿ��� ���� ���� N(3 �� N �� 10)�� �����ϼ� M(2 �� M �� N �� 10), 
���ð� �̵� Ȯ���� ���� K(3�� N �� K �� 30)�� �־�����. �� ���� �ٺ��� K�� �̵� Ȯ���� �־�����. ��, �ѵ��ÿ��� �ٸ� ���÷� �̵��� Ȯ���� ������ 3���� �����̴�..

[���]
�� ���� ��#x���� �����ϰ�(x�� �׽�Ʈ ���̽� ��ȣ) ������ �ϳ� �� ����, N���� ���ø� M�� ���� �����ؼ� �ٸ��� ��ư� ���� Ȯ���� ���Ͽ���. ���� �Ҽ��� 4��° �ڸ����� �ݿø��Ͽ� ����Ѵ�.

[����� ��]
(�Է�)
3
4 3 7
1 2 0.6
1 3 0.4
2 3 1.0
3 2 0.5
3 4 0.5
4 2 0.7
4 4 0.3
5 4 12
1 1 0.3
1 2 0.4
1 3 0.3
2 3 0.4
2 4 0.6
3 2 0.5
3 4 0.5
4 2 0.6
4 4 0.2
4 5 0.2
5 4 0.7
5 5 0.3
7 5 17
1 2 0.4
1 3 0.3
1 4 0.3
2 1 0.3
2 3 0.4
2 5 0.3
3 2 0.5
3 5 0.5
4 3 0.3
4 6 0.7
5 2 0.8
5 7 0.2
6 3 0.4
6 5 0.2
6 7 0.4
7 5 0.7
7 7 0.3

*
*/
public class Q_pro_�������� {
	
	static int N, M, K;
	static double[][] L;
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int T = Integer.parseInt(br.readLine());
			
			for(int t=0 ; t<T ; t++) {
			
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				
				double sum = 0.0;
				N = Integer.parseInt(st.nextToken()); // ���ð���
				M = Integer.parseInt(st.nextToken()); // �����ϼ�
				K = Integer.parseInt(st.nextToken()); // Ȯ������
				
				L = new double[N+1][N+1];
				double[][] S = new double[N+1][N+1];
				
				for(int k=0; k<K ; k++) {
					st = new StringTokenizer(br.readLine());
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());
					double p = Double.parseDouble(st.nextToken());
					L[from][to] = p;
				}
				
				double tilYesterday[][] = new double[N+1][N+1];
				System.arraycopy(L, 0, tilYesterday, 0, N+1);
				
				for(int i=1;i<=N;i++) {
					if(L[1][i]>0 && L[N][i]>0) {
						sum += tilYesterday[1][i] * tilYesterday[N][i];
					}
				}
				
				int day = 2;
				
				while(day <= M) {
					
					double[][] tmp = new double[N+1][N+1];
					 
					for(int a=1; a<=N; a++) {
						for(int b=1; b<=N; b++) {
							for(int c=1; c<=N ; c++) {
								tmp[a][b] += tilYesterday[a][c]*L[c][b];
							}
						}
					}
					
					for(int i=1; i<=N; i++) {
						// day�� ���� ���� i���� ���� �� �ִ� Ȯ��
						S[day][i] = tilYesterday[1][i] * tilYesterday[N][i];
						if(S[day][i] > 0) {
							for(int j=1; j<=N; j++) {
								if(L[j][i] > 0) 
									S[day][i] -= S[day-1][j];
							}
						}
					}
					
					
					for(int i=0; i<=N; i++) {
						System.out.println(Arrays.toString(S[i]));
					}
					System.out.println();
					
					tilYesterday = tmp;
					day++;
				}
				
				System.out.println("#"+(t+1)+" "+sum);
			}
			
		} catch (IOException e) {
		}
		
	}

}
