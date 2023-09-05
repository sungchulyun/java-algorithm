import java.util.Scanner;

public class boj15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();
        arr= new int[M];

        dfs(1, 0);
        System.out.print(sb);
    }
    public static void dfs(int at, int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = at; i <= N; i++){
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }
}
