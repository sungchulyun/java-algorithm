package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class boj2231 {
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int m = Integer.parseInt(n);
		int sum = 0;
		int[] arr = new int[n.length()];
		List<Integer> sol = new ArrayList<>();
		
		for(int i = m; i> 0; i--) {
			sum = 0;
			String x = Integer.toString(i);
			
			for(int j = 0; j<x.length(); j++) {
				arr[j] = x.charAt(j) - '0';									//여기가 문제임
			}
			for(int t = 0; t<x.length(); t++) {
				sum += arr[t];
			}
			sum += i;
			if(sum == m) {
				sol.add(i);
			}
		}
		Collections.sort(sol);
		if(!sol.isEmpty()) {
			System.out.println(sol.get(0));
		}
		else
			System.out.print(0);
	}
}
