import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1235 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = new String[n];
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            nums[i] = br.readLine();

        }
        int len = nums[0].length();
        for(int k = 1; k <=len; k++){
            for(int i = 0; i < n; i++){
                set.add(nums[i].substring(len - k));
            }
            if(set.size() == n){
                System.out.println(k);
                return;
            }
            set.clear();
        }
    }
}
