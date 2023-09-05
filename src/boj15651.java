import java.util.Scanner;

public class boj15651 {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visit = new boolean[N];

        dfs(0);
        System.out.print(sb);
    }
    public static void dfs(int depth){
        if(depth == M){
            for(int val : arr){
               sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            arr[depth] = i;
            dfs(depth+1);
        }
    }
}
