package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2606 {
	static int[][] arr;
	static boolean[] visited;
	static int C, N;
	static int count;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		arr = new int[C+1][C+1];
		visited = new boolean[C+1];
		visited[0] = true;
		for(int i = 0; i<N; i++	) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		count = 0;
		dfs(1);
		System.out.print(count - 1);
	}
	public static void dfs(int start) {
		visited[start] = true;
		count++;
		for(int i = 0; i<=C; i++) {
			if(visited[i] == true || arr[start][i] == 0) {
				continue;
			}
			dfs(i);
		}
	}
}
