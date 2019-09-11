import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CalabashBrotherSorter {
    private CalabashBrother[] brothers;

    private class CalabashComparator implements Comparator<CalabashBrother> {
        @Override
        public int compare(CalabashBrother brotherOne, CalabashBrother brotherTwo) {
            return brotherOne.getRank() - brotherTwo.getRank();
        }
    }

    public CalabashBrotherSorter(CalabashBrother[] brothers) {
        this.brothers = brothers;
    }

    private void shuffle() {
        ArrayList<CalabashBrother> tempList = new ArrayList<>(Arrays.asList(brothers));
        Collections.shuffle(tempList);
        brothers = tempList.toArray(new CalabashBrother[brothers.length]);
    }

    private void yield(int from, int to) {
        /* Yield out when two calabash brothers change their position */
        System.out.println(brothers[from].getName() + ": " + from + "->" + to);
    }

    private int partition(int start, int end) {
        CalabashComparator comparator = new CalabashComparator();
        CalabashBrother pivot = brothers[start];
        int firstLess = start;
        for (int i = start + 1; i <= end; i++) {
            if (comparator.compare(brothers[i], pivot) < 0) {
                firstLess++;
                yield(i, firstLess);
                yield(firstLess, i);
                CalabashBrother temp = brothers[firstLess];
                brothers[firstLess] = brothers[i];
                brothers[i] = temp;
            }
        }
        yield(start, firstLess);
        yield(firstLess, start);
        brothers[start] = brothers[firstLess];
        brothers[firstLess] = pivot;
        return firstLess;
    }

    private void quickSort(int start, int end) {
        if (start > end)
            return;
        int pivotIndex = partition(start, end);
        quickSort(start, pivotIndex - 1);
        quickSort(pivotIndex + 1, end);
    }

    public void bubbleSort() {
        shuffle();
        /* Sort according to their order */
        int num = brothers.length;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (brothers[j].getRank() > brothers[j + 1].getRank()) {
                    yield(j, j + 1);
                    yield(j + 1, j);
                    CalabashBrother temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
        }

        /* Sort finish */
        for (CalabashBrother brother : brothers) {
            System.out.print(brother.getName() + " ");
        }
        System.out.println();
    }

    public void binarySort() {
        shuffle();
        /* Use binary QuickSort */
        /* Sort according to their color */
        quickSort(0, brothers.length - 1);
        for (CalabashBrother brother : brothers) {
            System.out.print(brother.getColor() + " ");
        }
        System.out.println();
    }
}
