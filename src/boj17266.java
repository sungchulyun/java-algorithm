import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17266 {
    static int[] lights;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        lights = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n;
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(possible(mid)){
                result = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        System.out.println(result);
    }
    static boolean possible(int target){
        int prev = 0;
        for(int i = 0; i < lights.length; i++){
            if(lights[i] - target <= prev){
                prev = lights[i] + target;
            } else {
                return false;
            }
        }
        return n - prev <= 0;
    }
}