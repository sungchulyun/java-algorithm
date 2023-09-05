import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1476 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < n; i++){
            stack = new Stack<>();
            String word = br.readLine();

            for(int j = 0; j < word.length(); j++){

                if(stack.isEmpty()){
                    stack.push(word.charAt(j));
                } else if(stack.peek() == word.charAt(j)){
                    stack.pop();
                } else
                    stack.push(word.charAt(j));
            }
            if(stack.isEmpty())
                count++;
        }
        System.out.print(count);
    }
}
