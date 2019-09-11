public class Main {
    private static final int N = 7; /* There are seven calabash brothers */
    /* Main class */
    public static void main(String[] args) {
        /* Make seven calabash brothers */
        CalabashBrother[] brothers = new CalabashBrother[N];
        for (int i = 0; i < N; i++) {
            brothers[i] = new CalabashBrother(i);
        }

        CalabashBrotherSorter sorter = new CalabashBrotherSorter(brothers);
        System.out.println("Bubble Sort Begin");
        /* Bubble Sort */
        sorter.bubbleSort();
        System.out.println("Bubble Sort End");
        System.out.println("Binary Sort Begin");
        /* Binary Sort */
        sorter.binarySort();
        System.out.println("Binary Sort End");
    }
}
