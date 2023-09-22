import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1707 {
    public static int V, E;
    public static ArrayList<Integer>[] list;
    public static int[] visited;
    public static boolean result;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            result = false;
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V+1];
            visited = new int[V+1];
            for(int i = 1; i <= V; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            for(int i = 1; i <= V; i++){
                if(visited[i] == 0){
                    dfs(i, 1);
                }
            }
            if(result){
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void dfs(int target, int color){
       visited[target] = color;
       if(result){
           return;
       }

       for(int i : list[target]){
           if(visited[i] == visited[target]){       //ex) 2번 노드랑 친구인 애들 중에서 color가 같으면 이분 그래프가 안된다.
               result = true;
               return;
           }
           if(visited[i] == 0){
               dfs(i, color*-1);
           }
       }
    }
}
