

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL1733_Omoke {
	static int[] dr = {-1, 0, 1, 1}; 
    static int[] dc = {1, 1, 1, 0}; // 우상, 우, 우하, 하
    static int[][] map = new int[21][21];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 19; i++) {
			String line = br.readLine();
			for (int j = 1, index = 0; j <= 19; j++, index += 2) {
				map[i][j] = line.charAt(index) - '0';
			}
		}
		
		for (int r = 1; r <= 19; r++) { // 행
			for (int c = 1; c <= 19; c++) { // 열
				if (map[r][c] == 0) // 돌이 놓여있지 않으면 다음칸으로
					continue;
				int answer = complete(r, c); // 오목이면 돌 색상을 리턴
				if (answer > 0) { // 오목이면
					System.out.println(answer);
					System.out.println(r + " " +c);
					return; // 프로그램 종료
				}
			}
		}
		System.out.println(0);
	}
	
	public static int complete(int r, int c) {
		int color = map[r][c];
		
		for (int k = 0; k < 4; k++) { // 4가지 오목 방향
			if (map[r-dr[k]][c-dc[k]] == color) // 이전 칸이 나랑 다른색이어야함
				continue;
			
			if (map[r+dr[k]][c+dc[k]] != color
					|| map[r+dr[k]*2][c+dc[k]*2] != color
					|| map[r+dr[k]*3][c+dc[k]*3] != color
					|| map[r+dr[k]*4][c+dc[k]*4] != color) // 5칸 연속 같은 색인지
				continue;
			
			if (map[r+dr[k]*5][c+dc[k]*5] == color) // 5칸 이후 칸이 다른색이어야함
				continue;

			return color;
		}
		return 0;
	}
}
