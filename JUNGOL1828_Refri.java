import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL1828_Refri {
	
	static class Chemical implements Comparable<Chemical> {
		int min, max;
		
		public Chemical(int min, int max) {
			this.min = min;
			this.max = max;
		}
		
		@Override
		public int compareTo(Chemical o) {
			int diff = this.max - o.max;
			return diff != 0 ? diff : this.min - o.min;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Chemical[] chemicals = new Chemical[N];
		int cnt = N;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			chemicals[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(chemicals);
		int maxTemperature = chemicals[0].max;
		
		for (int i = 0; i < N-1; i++) {
			if (maxTemperature >= chemicals[i+1].min)
				cnt--;
			else
				maxTemperature = chemicals[i+1].max;
		}
		
		System.out.println(cnt);
	}

}
