import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10025 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[p] = w;
        }

        int sum = 0;
        int max = 0;
        int window = 1 + (2*k);
        boolean flag = false;

        for(int i = 0; i < arr.length; i++){
            if(i == window-1) flag = true;
            if(i >= window){
                sum -= arr[i - window];
            }
            sum += arr[i];
            if(sum > max && flag){
                max = sum;
            }
        }
        System.out.println(max);
    }
}
