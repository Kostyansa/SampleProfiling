package org.udsu.performance;


import java.util.Random;

import static java.lang.Math.pow;

public class ComputionalyHeavy {

    private final static int A_LOT = 1000000000;

    private volatile Double blackhole = 1.0;

    private double compute(double a, double b){
        return pow(a, pow(a, b));
    }

    public void start(){
        Random random = new Random();
        for (int i = 0; i < A_LOT; i++){
            blackhole *= compute(random.nextDouble(), random.nextDouble());
        }
    }
}
