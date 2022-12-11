package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class miro {

    static int N;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1 ,0 ,0};
    static int[][] arr;
    static boolean[][] visited;
    static int buildings[] = new int[25];
    static int buildnum = 0;
    public static void main(String arg[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	visited= new boolean[N][N];
    	arr = new int[N][N];
    	for(int i = 0; i<N; i++) {
    		String s = br.readLine();
    		for(int j = 0; j<s.length(); j++) {
    			arr[i][j] = s.charAt(j) - '0';
    		}
    	}
    	for(int i = 0; i<N; i++) {
    		for(int j = 0; j<N; j++) {
    			if(arr[i][j] == 1 && !visited[i][j]) {
    				buildnum++;
    				bfs(i,j);
    			}
    		}
    	}    
    	Arrays.sort(buildings);
    	System.out.println(buildnum);
    	
    	for(int i = 0; i<buildings.length; i++	) {
    		if(buildings[i] == 0) {
    			continue;
    		}
    		else
    			System.out.println(buildings[i]);
    	}
    }
    public static void bfs(int x, int y) {
    	Queue<spot> q = new LinkedList<>();
    	q.add(new spot(x,y));
    	visited[x][y] = true;
    	buildings[buildnum]++;
    	while(!q.isEmpty()) {
    		spot s = q.poll();
    		for(int i = 0; i<4; i++) {
    			int nextX = s.x + moveX[i];
    			int nextY = s.y + moveY[i];
    			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >=N) {
    				continue;
    			}
    			if(arr[nextX][nextY] == 0 || visited[nextX][nextY]) {
    				continue;
    			}
    			q.add(new spot(nextX, nextY));
    			visited[nextX][nextY] = true;
    			buildings[buildnum]++;
    		}
    	}
    }
}

class spot{
	int x;
	int y;
	spot(int x, int y){
		this.x= x;
		this.y = y;
	}
}
