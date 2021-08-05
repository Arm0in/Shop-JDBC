package ir.maktab.partone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuitablePair {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 7, 9, 2, 5, 5, 8, 5, 6, 3, 4, 7, 3, 1, 2));
        if (list.size() % 2 != 0)
            list.remove(list.size() - 1);
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i = i + 2) {
            if (list.get(i) > list.get(i + 1)) {
                indexes.add(i);
                indexes.add(i + 1);
            }
        }
        System.out.println("indexes that should removed: " + indexes);
        for (int i = indexes.size() - 1; i >= 0; i--) {
            int index = indexes.get(i);
            list.remove(index);
        }
        System.out.println("final list: " + list);
    }
}
