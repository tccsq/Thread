package com.pera.test.thread07;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by csq on 2015/9/6.
 */
public class Main {

    public static void main(String args[]) {
        ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();

        Thread threads[] = new Thread[25];
        int counter = 0;
        for (char i = 'A'; i < 'Z'; i++) {
            Task task = new Task(map, String.valueOf(i));
            threads[counter] = new Thread(task);
            threads[counter].start();
            counter++;
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the map: %d\n", map.size());

        Map.Entry<String, Contact> element;
        Contact contact;

        element = map.firstEntry();
        contact = element.getValue();
        System.out.printf("Main: First Entry: %s: %s\n", contact.getName(), contact.getPhone());

        element = map.lastEntry();
        contact = element.getValue();
        System.out.printf("Main: Last Entry: %s: %s\n", contact.getName(), contact.getPhone());

        ConcurrentNavigableMap<String, Contact> subMap = map.subMap("A1996", "B1002");
        do {
            element = subMap.pollFirstEntry();
            contact = element.getValue();
            System.out.printf("%s: %s\n", contact.getName(), contact.getPhone());

        } while (element != null);

    }

}
