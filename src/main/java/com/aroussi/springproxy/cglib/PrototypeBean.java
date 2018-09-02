package com.aroussi.springproxy.cglib;

import java.time.LocalDateTime;

public class PrototypeBean {

    private LocalDateTime localDateTime = LocalDateTime.now();

    public String getTime(){
        return this.localDateTime.toString();
    }
}
