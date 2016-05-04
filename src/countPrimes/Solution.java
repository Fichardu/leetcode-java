// Description:
//
// Count the number of prime numbers less than a non-negative number, n.

public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i=2; i<n; ++i) {
            if (!notPrimes[i]) {
                ++count;
                for (int j=2; i*j<n; ++j) {
                    notPrimes[i*j] = true;
                }
            }
        }
        return count;
    }
}
