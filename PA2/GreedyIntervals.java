
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class IntegerComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer arg1, Integer arg2) {
		return arg1 - arg2;
	}
}

public class GreedyIntervals {

	private static void sortIntervalsByStartTime(List<Interval> intervals) {
		Collections.sort(intervals, (arg1, arg2) -> arg1.start - arg2.start);
	}

	private static void sortIntervalsByEndTime(List<Interval> intervals) {
		Collections.sort(intervals, (arg1, arg2) -> arg1.end - arg2.end);
	}

	public static ArrayList<Interval> schedule(List<Interval> intervals) { // complete this method
		sortIntervalsByEndTime(intervals);
		ArrayList<Interval> optimal = new ArrayList<>();
		Interval nextInterval = optimal.get(0);
		optimal.add(nextInterval);
		for (int i = 0; i < intervals.size(); i++) {
			if (intervals.start > nextInterval.end) {
				
			}
		}
		return optimal;
	}

	public static int color(List<Interval> intervals) { // complete this method
		sortIntervalsByStartTime(intervals);
		PriorityQueue<Integer> pq = new PriorityQueue<>(new IntegerComparator());
		Interval x = intervals.get(0);
		pq.add(x.end);
		int counter = 0;
		for (int i = 0; i < intervals.size(); i++) {
			if (intervals[i].start > x.end) {
				
			}
		}
	}
}
