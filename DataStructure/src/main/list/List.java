package main.list;

import java.util.Iterator;

public interface List<I> {
    boolean add(I i);

    void add(int index, I i);

    boolean addAll(List<I>);

    boolean addAll(int index, List<I>);

    void clear();

    boolean contains(I i);

    I get(int index);

    int indexOf(I i);

    boolean isEmpty();

    Iterator<I> iterator();

    int lastIndexOf(I i);

    I remove(int index);

    boolean remove(I i);

    boolean removeAll(List<I>);

    I set(int index, I i);

    int size();

    List<I> sublist(int fromIndex, int toIndex);

    Object[] toArray();


}
