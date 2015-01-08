public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new LinkedList<Integer>();
        for (int i=0; i<=rowIndex; ++i) {
            if (i <= 1) {
                row.add(1);
                continue;
            }
            row.add(1, row.get(1) + row.get(0));
            for (int j=2; j<i; ++j) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            
        }
        return row;
    }
}