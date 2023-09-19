package main.list;

import java.util.Iterator;

public interface List<I> {
    boolean add(I i);

    void add(int index, I i);

    boolean addAll(List<I> i);

    boolean addAll(int index, List<I> i);


    boolean contains(I i);

    boolean containsAll(List<I> i);

    boolean retainAll(List<I> i);

    I get(int index);

    int indexOf(I i);

    int lastIndexOf(I i);

    Iterator<I> iterator();

    boolean remove(I i);

    I removeAtIndex(int index);

    boolean removeAll(List<I> i);

    I set(int index, I i);

    int size();

    void clear();

    boolean isEmpty();

    List<I> sublist(int fromIndex, int toIndex);

    Object[] toArray();


}
