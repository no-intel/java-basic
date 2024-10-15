package java_adv.thread.collection.simple.list;

import java.util.Arrays;

import static java_adv.util.ThreadUtils.sleep;

public class SyncList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public SyncList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object e) {
        elementData[size] = e;
        sleep(100);
        size++;
    }

    @Override
    public synchronized Object get(int index) {
        return elementData[index];
    }

    @Override
    public String toString() {
        return "List= " + Arrays.toString(Arrays.copyOf(elementData, size))
                + " size= " + size + ", capacity= " + elementData.length;
    }
}
