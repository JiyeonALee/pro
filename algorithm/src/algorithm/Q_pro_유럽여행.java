package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

[입력]
입력의 맨 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
테스트케이스의 첫 줄에는 도시 개수 N(3 ≤ N ≤ 10)과 여행일수 M(2 ≤ M ≤ N ≤ 10), 
도시간 이동 확률의 개수 K(3≤ N ≤ K ≤ 30)가 주어진다. 그 다음 줄부터 K개 이동 확률이 주어진다. 단, 한도시에서 다른 도시로 이동할 확률의 개수는 3가지 이하이다..

[출력]
각 줄은 ‘#x’로 시작하고(x는 테스트 케이스 번호) 공백을 하나 둔 다음, N개의 도시를 M일 동안 여행해서 앨리와 노아가 만날 확률을 구하여라. 답은 소수점 4번째 자리에서 반올림하여 출력한다.

[입출력 예]
(입력)
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
public class Q_pro_유럽여행 {
	
	static int N, M, K;
	static double[][] L;
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int T = Integer.parseInt(br.readLine());
			
			for(int t=0 ; t<T ; t++) {
			
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				
				double sum = 0.0;
				N = Integer.parseInt(st.nextToken()); // 도시개수
				M = Integer.parseInt(st.nextToken()); // 여행일수
				K = Integer.parseInt(st.nextToken()); // 확률개수
				
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
						// day쨰 날에 도시 i에서 만날 수 있는 확율
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
