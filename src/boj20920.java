import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class boj20920 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String word = br.readLine();
            if(word.length() >= m){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = map.keySet().stream().collect(Collectors.toList());

        words.sort((o1, o2) -> {
            int c1 = map.get(o1);
            int c2 = map.get(o2);

            if(c1 == c2){
               if(o1.length() == o2.length()){
                   return o1.compareTo(o2);
               } else {
                   return o2.length() - o1.length();
               }
            }
            return c2 - c1;
        });

        for(int i = 0; i < words.size(); i++){
           sb.append(words.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}
