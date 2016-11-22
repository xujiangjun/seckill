package org.seckill.entity;

import java.util.concurrent.CountDownLatch;

/**
 * @author xujiangjun
 * @version 1.0
 * @date 2016-10-28 11:36
 */
public class Videoconference implements Runnable {
    private final CountDownLatch controller;
    public Videoconference(int number){
        controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.println(name+" has arrived.");
        controller.countDown();
        System.out.println("VideoConference:Waiting for "+controller.getCount());
    }

    @Override
    public void run() {

        System.out.println("VideoConference:Initialization:"+controller.getCount());

        try {
            controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
