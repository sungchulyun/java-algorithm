import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj1620 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> namemap = new HashMap<>();
        HashMap<String, String> nummap = new HashMap<>();
        for(int i = 1; i <= n ; i++){
            String s = br.readLine();
            namemap.put(s, String.valueOf(i));
            nummap.put(String.valueOf(i), s);
        }
        for(int i = 0; i < m; i++){
            String question = br.readLine();
            if(namemap.containsKey(question)){
                sb.append(namemap.get(question)).append("\n");
            } else
                sb.append(nummap.get(question)).append("\n");
        }
        System.out.print(sb);
    }
}
