import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL1205_joker {
	static int joker, N, answer;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 0)
				joker += 1;
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			if (arr[i] == 0)
				continue;
			func(i, 1, joker);
		}
		
		System.out.println(joker == N ? joker : answer);
	}
	
	public static void func(int idx, int cnt, int x) {
		if (idx == N - 1) {
			answer = Math.max(cnt + x, answer);
		}
		else if (arr[idx + 1] == arr[idx]) {
			func(idx + 1, cnt, x);
		}
		else if (arr[idx + 1] == arr[idx] + 1) {
			func(idx + 1, cnt + 1, x);
		}
		else if (x != 0 && arr[idx+ 1 ] - arr[idx] - 1 <= x) {
			func(idx + 1, cnt + (arr[idx + 1] - arr[idx]), x - (arr[idx + 1] - arr[idx] - 1));
		}
		else if (arr[idx + 1] != arr[idx] + 1) {
			answer = Math.max(cnt + x, answer);
		}

	}

}
