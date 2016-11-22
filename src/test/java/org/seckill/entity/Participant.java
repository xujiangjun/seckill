package org.seckill.entity;

import java.util.concurrent.TimeUnit;

/**
 * @author xujiangjun
 * @version 1.0
 * @date 2016-10-28 11:37
 */
public class Participant implements Runnable {
    private Videoconference conference;
    private String name;

    public Participant(Videoconference conference,String name){
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {

        long duration = (long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        conference.arrive(name);
    }
}
