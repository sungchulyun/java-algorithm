import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj17219 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String password = st.nextToken();
            map.put(url, password);
        }

        for(int i = 0; i < m; i++){
            String url = br.readLine();
            sb.append(map.get(url)).append("\n");
        }
        System.out.println(sb);
    }
}
