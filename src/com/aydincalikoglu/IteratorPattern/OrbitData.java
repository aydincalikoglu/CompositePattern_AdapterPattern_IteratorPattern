package com.aydincalikoglu.IteratorPattern;

import com.aydincalikoglu.Helper.IteratorType;
import com.aydincalikoglu.Helper.MatrixIns;

import java.util.Iterator;

/**
 * Iterator Pattern
 */
public class OrbitData implements SpirallyIterator {
    int data[][];
    int s=0;
    public OrbitData(int data[][])
    {
        this.data=data;
    }

    /**
     * İstenilen Iterator Enum ile belirtilir
     * @param typeIterator
     * @return Iterator
     */
    @Override
    public Iterator getIterator(IteratorType typeIterator){
        Iterator iterator = null;
        switch (typeIterator){
            case CLOCKWISE:
                iterator = new ClockWiseIterator();
                break;
            case ANTICLOCKWISE:
                iterator = new AntiClockWiseIterator();
                break;
        }
        return iterator;
    }

    private class ClockWiseIterator implements Iterator {
        int index=0;
        @Override
        public boolean hasNext() {
            if(index < data.length*data[0].length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return MatrixIns.spiralTravers(data).get(index++);
            }
            return null;
        }
    }

    private class AntiClockWiseIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if(index < data.length*data[0].length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return MatrixIns.spiralTravers(transpose(data)).get(index++);
            }
            return null;
        }

        private int[][] transpose (int[][] array) {
            if (array == null || array.length == 0)//empty or unset array, nothing do to here
                return array;

            int width = array.length;
            int height = array[0].length;

            int[][] array_new = new int[height][width];

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    array_new[y][x] = array[x][y];
                }
            }
            return array_new;
        }
    }
}
