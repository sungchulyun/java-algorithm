import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3273 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);   //1 2 3 5 7 9 10 11 12
        int cnt = 0;

        for(int i = 0; i < N; i++){
            int prev = arr[i];
            int next = i+1;

            while(next < N){
                int sum = 0;
                sum += arr[next] + prev;
                if(sum == M){
                    cnt++;
                    break;
                }
                next++;
            }
        }
        System.out.println(cnt);
    }
}
