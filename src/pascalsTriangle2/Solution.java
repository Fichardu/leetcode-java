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

    public List<Integer> getRow2(int rowIndex) {
        Integer[] row = new Integer[rowIndex+1];
        for (int i=0; i<=rowIndex; ++i) {
            row[i] = 1;
            for (int j=i-1; j>0; --j) {
                row[j] = row[j] + row[j-1];
            }
        }
        return Arrays.asList(row);
    }
}