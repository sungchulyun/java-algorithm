import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20922 {
    static int[] check;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0, start = 0, end = 0;
        check = new int[100001];
        while(end < arr.length){
            while(end < arr.length && check[arr[end]] + 1 <= K){
                check[arr[end]]++;
                end++;
            }
            int len = end - start;
            ans = Math.max(ans, len);
            check[arr[start]]--;
            start++;
        }
        System.out.println(ans);
    }
}
