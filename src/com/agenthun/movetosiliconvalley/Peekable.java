package com.agenthun.movetosiliconvalley;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by agenthun on 15/10/21.
 */
public class Peekable<T> {
    private T _top;
    private Iterator<T> _iterator;

    public Peekable(Iterator<T> iterator) {
        _iterator = iterator;
        getTop();
    }

    private void getTop() {
        _top = null;
        if (_iterator.hasNext()) {
            _top = _iterator.next();
        }
    }

    public boolean hasNext() {
        return _top != null;
    }

    public T next() {
        if (_top == null) throw new NoSuchElementException();
        T currentTop = _top;
        getTop();
        return currentTop;
    }

    public T peek() {
        return _top;
    }
}
