public class BufferedReader {
	private String rec;
	private int cur;

	public String read(int k) {
		if (k < 0) {
			throw new IllegalArgumentException();
		}
		
		String result = "";
		
		while (k > 0) {
			if (cur == rec.length()) {
				rec = read4k();
				cur = 0;
				
				if (rec.length() == 0) {
					break;
				}
			}
			else {
				int remain = rec.length() - cur;
				
				if (k <= remain) {
					result += rec.substring(cur, k);
					cur += k;
					k = 0;
				}
				else {
					result += rec.substring(cur);
					cur = rec.length();
					k -= remain;
				}
			}
		}
		
		return result;
	}
    
	public String readLine() {		
		String result = "";
		
		while (!result.endsWith("\n")) {
			if (cur == rec.length()) {
				rec = read4k();
				cur = 0;
				
				if (rec.length() == 0) {
					break;
				}
			}
			else {
				result += rec.charAt(cur);
				cur++;
			}
		}
		
		return result;
	}
}