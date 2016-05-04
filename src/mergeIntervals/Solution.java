// Given a collection of intervals, merge all overlapping intervals.
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        Interval last = intervals.get(0);
        for (int i=1; i<intervals.size(); ++i) {
            Interval cur = intervals.get(i);
            if (cur.start <= last.end) {
                if (last.end < cur.end) {
                    last.end = cur.end;
                }

            } else {
                res.add(last);
                last = cur;
            }
        }
        res.add(last);
        return res;
    }
}
