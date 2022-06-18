package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

import static java.util.Collections.sort;

public class SortedIntegerList {
    private final LinkedList<Integer> link;
    private boolean value;

    public SortedIntegerList(boolean value) {
        link = new LinkedList<Integer>();
        this.value = value;
    }
    public final void add(int value) {
        int tmpIter;
        ListIterator<Integer> iter = this.link.listIterator();
        if (!iter.hasNext()) {
            this.link.addFirst(value);
        }
        else {
            while (iter.hasNext()) {
                if (iter.next() >= value) {
                    tmpIter = iter.previous();
                    if ((tmpIter == value && this.value) || (tmpIter != value)) {
                        iter.add(value);
                    }
                    break;
                }
                else {
                    if (!iter.hasNext()) {
                        iter.add(value);
                    }
                }
            }
        }
    }

    public LinkedList minus(Object obj) {
        LinkedList<Integer> links = new LinkedList<Integer>();
        SortedIntegerList other = (SortedIntegerList)obj;

        int tmpIter;
        int tmp;

        ListIterator<Integer> iter = this.link.listIterator();
        ListIterator<Integer> iter1 = other.link.listIterator();
        ListIterator<Integer> iter2 = links.listIterator();


        while (iter.hasNext()) {
            tmpIter = iter.next();
            if(!(iter1.hasNext())) {
                tmp = 0;
            }
            else {
                tmp = iter1.next();
            }
            links.add(tmpIter - tmp);
        }
        sort(links);

        return links;
    }


    public final void remove(int value) {
        int tmpIter;
        ListIterator<Integer> iter = this.link.listIterator();
        while (iter.hasNext()) {
            tmpIter = iter.next();
            if (tmpIter == value) {
                iter.remove();
                break;
            }
            if (tmpIter > value) {
                break;
            }
        }
    }

    public boolean equals(Object object){
        if(this == object){//если тот же объект
            return true;
        }
        else if(!(object instanceof SortedIntegerList)){//передали ли объект нужного класса?
            return false;
        }

        SortedIntegerList other = (SortedIntegerList)object;

        if(link.size() != other.link.size()){
            return false;
        }

        for (Integer element : link) {
            if(!other.link.contains(element)){//если элемента в другом листе нет
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return this.link.toString();
    }
}
