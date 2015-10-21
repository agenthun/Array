package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by agenthun on 15/10/22.
 */
public class ComplexIterator<T> implements Iterator<T> {
    private int currIndex;
    private ArrayList<T> flatColl;

    public ComplexIterator(Collection<Data<T>> c) {
        currIndex = 0;
        flatColl = new ArrayList<>();
        flatElement(c);
    }

    private void flatElement(Collection<Data<T>> c) {
        for (Data<T> item : c) {
            if (item.isCollection()) {
                flatElement(item.getCollection());
            } else {
                flatColl.add(item.getElement());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return null != flatColl && flatColl.size() > 0 && currIndex < flatColl.size();
    }

    @Override
    public T next() {
        if (flatColl == null || currIndex >= flatColl.size()) throw new NoSuchElementException();
        T t = flatColl.get(currIndex);
        currIndex++;
        return t;
    }
}

interface Data<T> {
    public boolean isCollection();

    public Collection<Data<T>> getCollection();

    public T getElement();
}
