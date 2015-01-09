public class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
		
		while (n > 0) {
			int suff = (n-1) % 26;
			builder.insert(0, (char)('A' + suff));
			n = (n-1) / 26;
		}
		return builder.toString();
        
    }
}