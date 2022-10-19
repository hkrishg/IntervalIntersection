import java.util.*;

// Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.

// Example 1:

// Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
// Output: [2, 3], [5, 6], [7, 7]
// Explanation: The output list contains the common intervals between the two lists.
// Example 2:

// Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
// Output: [5, 7], [9, 10]
// Explanation: The output list contains the common intervals between the two lists.

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

class Main {

  public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
    int i = 0, j = 0;
    List<Interval> result = new ArrayList<>();

    while (i < arr1.length && j < arr2.length) {
      // check if arr1[i] intersects arr2[j];
      if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
          || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
        // store intersection
        result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
      }
      if (arr1[i].end < arr2[j].end)
        i++;
      else
        j++;
    }
    return result.toArray(new Interval[result.size()]);
  }

  public static void main(String[] args) {
    Interval[] interval = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
    Interval[] interval2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };

    Interval[] result = Main.merge(interval, interval2);
    System.out.println("Merging Intervals");

    for (Interval interval3 : result) {
      System.out.println("[" + interval3.start + ", " + interval3.end + " ] ");
      System.out.println();
    }
  }
}