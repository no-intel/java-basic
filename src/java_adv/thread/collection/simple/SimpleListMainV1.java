package java_adv.thread.collection.simple;

import java_adv.thread.collection.simple.list.BasicList;
import java_adv.thread.collection.simple.list.SimpleList;

public class SimpleListMainV1 {
    public static void main(String[] args) {
        SimpleList list = new BasicList();

        list.add("a");
        list.add("b");
        System.out.println(list);
    }
}
