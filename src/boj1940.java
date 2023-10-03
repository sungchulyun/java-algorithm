import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1940 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            int now = i;
            int next = i+1;
            while(next <= n-1){
                int sum = arr[now] + arr[next++];
                if(sum == m)
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
