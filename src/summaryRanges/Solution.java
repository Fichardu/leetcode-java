// Given a sorted integer array without duplicates, return the summary of its ranges.
//
// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        while (i < nums.length) {
            String item = String.valueOf(nums[i]);
            int j=i;
            while (j<nums.length && nums[j]-nums[i] == (j-i)) {
                ++j;
            }
            if ((j-1) != i) {
                item = item + "->" + nums[j-1];
                i = j;
            } else {
                ++i;
            }
            res.add(item);
        }

        return res;
    }
}
