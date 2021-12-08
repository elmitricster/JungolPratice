import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1037_errorCorrection {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		int check = 0; // 홀수 행or열 갯수 확인
		int r = 0; // 행
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j]; // 가로 행 부터 확인
			}
			
			if (sum % 2 != 0) {
				r = i; // 행 저장
				check += 1;
			}
		}
		
		if(check > 1) {
			System.out.println("Corrupt");
			return;
		} else {
			check = 0;
			int c = 0; // 열
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += arr[j][i]; // 세로 열 확인
				}
				if (sum % 2 != 0) {
					c = i; // 열 저장
					check += 1;
				}
			}
			
			if (check > 1) {
				System.out.println("Corrupt");
				return;
			} else if(check == 1) {
				System.out.println("Change bit (" + (r+1) + "," + (c+1) + ")");
			} else {
				System.out.println("OK");
			}
		}
	}

}
