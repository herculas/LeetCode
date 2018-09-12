package cn.herculas.leetCode.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e)
    {
        start = s;
        end = e;
    }
}


public class MergeIntervals_56 {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        
        List<Interval> result = new ArrayList<>();

        for (Interval interval: intervals) {
            if (result.size() == 0) {
                result.add(interval);
            } else {
                Interval tempInterval = result.get(result.size() - 1);

                if (interval.start <= tempInterval.end) {
                    Interval newInterval;
                    if (interval.end < tempInterval.end) {
                        newInterval = new Interval(tempInterval.start, tempInterval.end);
                    } else {
                        newInterval = new Interval(tempInterval.start, interval.end);
                    }

                    result.set(result.size() - 1, newInterval);

                } else {
                    result.add(interval);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(i1);
        intervalList.add(i2);
        intervalList.add(i3);
        intervalList.add(i4);

        MergeIntervals_56 mergeIntervals_56 = new MergeIntervals_56();
        List<Interval> res = mergeIntervals_56.merge(intervalList);

        for (Interval i: res) {
            System.out.println("Start: " + i.start + ", end: " + i.end);
        }
    }
}

