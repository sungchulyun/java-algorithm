import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20291 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String file = br.readLine();
            for(int j = 0; j < file.length(); j++){
                if(file.charAt(j) == '.'){
                    file = file.substring(j);
                }
            }
            map.put(file, map.getOrDefault(file , 0) + 1);
        }

        Map<String, Integer> sortMap = new TreeMap<>(map);
        for(String key : sortMap.keySet()){
            System.out.println(key.substring(1)  + " " + sortMap.get(key));
        }
    }
}
