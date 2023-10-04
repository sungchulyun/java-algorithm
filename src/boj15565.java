import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15565 {
    static int[] check;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check = new int[3];
        int start = 0, end = 0;
        int answer =0;

        while(end < arr.length){
            while(end < arr.length && check[arr[end]] < k){
                check[arr[end]]++;
                end++;
            }
            int len = end - start;
            answer = Math.max(answer, len);
            check[arr[start]]--;
            start++;
        }
        if(answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}
