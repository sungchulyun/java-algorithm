import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2470 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0;
        int left = 0, right = N-1;

        while(left < right){
            int temp = Math.abs(arr[left] + arr[right]);
            if(temp < min){
                min = temp;
                answer1 = arr[left];
                answer2 = arr[right];
            }

            if(arr[left] + arr[right] > 0){
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}
