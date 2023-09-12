import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2668 {
    static int[] arr;
    static boolean[] visited;

    static ArrayList<Integer> list;
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
    public static void dfs(int start, int target){
        if(visited[arr[start]] == false){
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }
        if(arr[start] == target) list.get(target);
    }
}
