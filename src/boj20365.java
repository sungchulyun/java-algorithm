import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj20365 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        boolean flag = true;
        int cnt1 = 1;
        int cnt2 = 1;
        char prev = '\0';

        for(int i = 0; i < arr.length; i++){
            if(prev != arr[i]){
                if(arr[i] == 'B'){
                    cnt1++;
                } else {
                    cnt2++;
                }
                prev = arr[i];
            }
        }
        System.out.println(Math.min(cnt1, cnt2));
    }
}
