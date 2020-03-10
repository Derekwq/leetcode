package com.ximu.leetcode.first.thread;

import java.util.concurrent.Semaphore;

/**
 * @author derek.wu
 * @date 2020-03-06
 * @since v1.0.0
 */
public class TrafficLightControlledIntersection {
}

class TrafficLight {

    private Semaphore greenSemap = new Semaphore(1, true);
    private boolean   canRoad1Go = true;
    private boolean   canRoad2Go;

    public TrafficLight() {

    }

    public void carArrived(int carId, // ID of the car
                           int roadId, // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
                           int direction, // Direction of the car
                           Runnable turnGreen, // Use turnGreen.run() to turn light to green on current road
                           Runnable crossCar // Use crossCar.run() to make car cross the intersection
    ) {
        try {
            greenSemap.acquire();
            if ((roadId == 1 && canRoad1Go) || (roadId == 2 && canRoad2Go)) {
                crossCar.run();
            } else if (roadId == 1 && !canRoad1Go) {
                turnGreen.run();
                canRoad1Go = true;
                canRoad2Go = false;
                crossCar.run();
            } else {
                turnGreen.run();
                canRoad2Go = true;
                canRoad1Go = false;
                crossCar.run();
            }
            greenSemap.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
