import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj22871 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1;
        int high = 200000000;
        int mid = 0;
        int answer = 0;

        while(low <= high){
            mid = (low + high) / 2;

            if(!cross(arr, N, mid)){
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }

    public static boolean cross(int[] arr, int k, int mid){
        int cnt = 0;

        for(int stone : arr){
            if(stone - mid < 0)
                cnt++;
            else
                cnt = 0;
        }
        if(cnt == k){
            return false;
        }
        return true;
    }
}
