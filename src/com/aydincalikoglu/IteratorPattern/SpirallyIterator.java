package com.aydincalikoglu.IteratorPattern;

import com.aydincalikoglu.Helper.IteratorType;

import java.util.Iterator;

public interface SpirallyIterator {
    Iterator getIterator(IteratorType typeIterator);
}
