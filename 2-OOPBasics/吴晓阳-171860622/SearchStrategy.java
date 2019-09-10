import java.util.Comparator;
import java.util.List;

public interface SearchStrategy<T> {
    int indexOf(List<T> list, Comparator<T> comparator, T element);
    T searchOf(List<T> list, Comparator<T> comparator, T element);
}
