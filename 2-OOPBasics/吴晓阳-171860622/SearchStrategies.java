import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class SearchStrategies {
    public static class BinarySearch<T> implements SearchStrategy<T>{
        List<T> list;

        Comparator<T> comparator;

        T element;

        public BinarySearch(){}

        public BinarySearch(List<T> list, Comparator<T> comparator, T element){
            this.list = list;
            this.comparator = comparator;
            this.element = element;
        }

        public void init(List<T> list, Comparator<T> comparator, T element){
            this.list = list;
            this.comparator = comparator;
            this.element = element;
        }

        @Override
        public int indexOf(List<T> list, Comparator<T> comparator, T element) {
            init(list, comparator, element);
            return searchRange(0, list.size());
        }

        @Override
        public T searchOf(List<T> list, Comparator<T> comparator, T element) {
            init(list, comparator, element);
            return list.get(searchRange(0, list.size()));
        }

        private int searchRange(int indexFrom, int indexTo){
            if(!checkRange(indexFrom, indexTo)){
                return indexTo;
            }

            int indexMid = (indexFrom + indexTo) / 2;
            T elemMid = list.get(indexMid);

            int compRes = comparator.compare(elemMid, element);
            if(compRes == 0){
                return indexMid;
            }
            else if(compRes < 0){
                return searchRange(indexMid + 1, indexTo);
            }
            else{
                return searchRange(indexFrom, indexMid);
            }
        }

        private boolean checkRange(int indexFrom, int indexTo){
            throw new UnsupportedOperationException();
        }
    }
}
