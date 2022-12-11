package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class boj11724 {
	static int N,M;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[1001][1001];
		visited = new boolean[1001];
		for(int i = 0; i < M; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		int count = 0;
		for(int k = 1; k <= N; k++	) {
			if(!visited[k]) {
				dfs(k);
				count++;
			}
		}
		System.out.println(count);
	}
	public static void dfs(int start) {
		visited[start] = true;
		for(int i = 1; i <= N; i++) {
			if(visited[i] == false && arr[start][i] == 1) {
				dfs(i);
			}
		}
		
	}
}
