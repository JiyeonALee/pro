package algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1916_최소비용구하기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][N];
		Arrays.fill(map, Integer.MAX_VALUE);
		
		for(int m=0;m<M;m++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from][to] = sc.nextInt();
		}
		
		int from = sc.nextInt();
		int to = sc.nextInt();
		
	}
	
	static int go(int[][] map, int from, int start) {
		
		// 우선순위 큐 만들기
		PriorityQueue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.dist - o2.dist;
			}
		});
		
		for(int i=0; i<map[0].length; i++) {
			Node node = new Node();
			node.setStart(from);
			node.setEnd(i);
			node.setDist(map[from][i]);
			q.offer(node);
		}
		
		q.peek(); 
		
	}
	
	private class Node {
		int start;
		int end;
		int dist;

		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public int getDist() {
			return dist;
		}
		public void setDist(int dist) {
			this.dist = dist;
		}
	}
	

}
