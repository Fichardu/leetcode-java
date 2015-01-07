public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(numRows);
        for (int i=0; i<numRows; ++i) {
            List<Integer> line = new ArrayList<Integer>(i+1);
            if (i == 0) {
                line.add(1);
            } else {
                line.add(1);
                List<Integer> upLine = res.get(i-1);
                for (int j=0, len=upLine.size()-1; j<len; ++j) {
                    line.add(upLine.get(j) + upLine.get(j+1));
                }
                line.add(1);
            }
            res.add(line);
        }
        return res;
    }
}