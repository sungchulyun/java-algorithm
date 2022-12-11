package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj1260 {
	static int arr[][];
	static boolean visited[];
	static int N,M,V;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 0; i<M; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		dfs(V);
		System.out.println();
		for(int i = 0; i<visited.length; i++) {
			visited[i] = false;
		}
		bfs(V);
	}
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start);
		for(int j = 1; j<= N; j++) {
			if(arr[start][j] == 0 || visited[j]) {
				continue;
			}
			dfs(j);
		}
	}
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp);
			for(int i = 1; i<=N; i++) {
			if(visited[i] == true || arr[temp][i] == 0) {
				continue;
				}
			q.add(i);
			visited[i] = true;
			}
		}
	}
}
