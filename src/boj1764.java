import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1764 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String people = br.readLine();
            if(set.contains(people)){
                list.add(people);
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}
