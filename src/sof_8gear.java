import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sof_8gear {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8];
        boolean flag = false;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(prev < arr[i]){
                flag = true;
                prev = arr[i];
            } else if(prev > arr[i] && flag){
                System.out.println("mixed");
                return;
            } else
                flag = false;
        }
        if(flag) System.out.println("ascending");
        else System.out.println("descending");
    }
}
