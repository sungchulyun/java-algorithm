import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj1544 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];

        for(int i = 0; i < n; i++){
            strs[i] = br.readLine();
        }
        int cnt = n;
        List<String> list = new ArrayList<>();


        for(int i = 0; i < n; i++){
            String str = strs[i]+ strs[i];  //picturepicture
           for(int j = i+1; j < n; j++){

           }
        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
