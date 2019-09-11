public class Main {
    /* Main class */
    public static void main(String[] args) {
        CalabashBrotherSorter sorter = new CalabashBrotherSorter();
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
