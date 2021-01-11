package org.udsu.memory;

import java.util.ArrayList;
import java.util.Random;

public class BimodalDistribution {
    private final static int A_LOT = 1000000000;

    private volatile Integer blackhole = 0;

    private ArrayList<ArrayList<Integer>> olds = new ArrayList<>();

    //A lot of small shortlived objects
    //And increasing set of "Old" objects
    public void start(){
        Random random = new Random();
        for (int i = 0; i < A_LOT; i++){
            ArrayList<Integer> list = new ArrayList<>(128);
            Integer a = new Integer(random.nextInt());
            Integer b = new Integer(random.nextInt());
            list.add(a);
            list.add(b);
            b += (b == 0) ? 1 : 0;
            blackhole *= (a/b);

            if ((random.nextInt() % 1000) == 0){
                olds.add(list);
            }
        }
    }
}
