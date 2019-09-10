import java.util.Comparator;
import java.util.List;

class Commands{
    public static <T> void sort(List<T> list, Comparator<T> comparator, SortStrategy<T> strategy){
        strategy.sort(list, comparator);
    }

    public static <T> int indexOf(List<T> list, Comparator<T> comparator, SearchStrategy<T> strategy, T elem){
        return strategy.indexOf(list, comparator, elem);
    }

    public static <T> T searchOf(List<T> list, Comparator<T> comparator, SearchStrategy<T> strategy, T elem){
        return strategy.searchOf(list, comparator,elem);
    }

    public static <T> String moveInfo(List<T> list, int indexFrom, int indexTo){
        return list.get(indexFrom) + ": " + indexFrom + "->" + indexTo;
    }

    public static <T> String moveInfo(List<T> list, int indexFrom, int indexTo, T elem){
        return elem + ": " + indexFrom + "->" + indexTo;
    }
}
