package OOP.week11;

import java.util.Iterator;

public interface DataCollection<T> {   //Target Interface
    boolean put(T t);
    T elemAt(int index);
    int length();
    Iterator createIterator();
}
