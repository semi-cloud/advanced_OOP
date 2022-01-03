package OOP.week11;

import java.util.Iterator;

public class DynamicArray<T> implements DataCollection<T> {
    final int SIZE = 3;
    private int length;
    private int capacity;
    private Object[] data;  

    public DynamicArray() {
        data = new Object[SIZE];
        length = 0;
        capacity = SIZE;
    }

    public boolean put(T t) {
        if (length >= capacity) {
            boolean b = resizeArray(); // 재할당
            if (b) {
                data[length] = t;
                length++;
            }
            return b;
        }
        else {
            data[length] = t;
            length++;
        }
        return true;
    }

    public T elemAt(int index) {
        if (index >= 0 && index < length) {
            return (T) data[index];
        }
        return null;
    }

    public int length() {
        return length;
    }

    public Iterator createIterator() {     //여기서 iterator 반환
        return new DynamicArrayIterator(this);
    }

    private boolean resizeArray() {
        Object[] newData = new Object[capacity + SIZE];
        if (newData == null) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity += SIZE;
        return true;
    }
}
