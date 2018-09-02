package com.aroussi.springproxy.cglib;

public class SingletonBean {

    private PrototypeBean prototypeBean;

    public SingletonBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    public String getDate(){
        return this.prototypeBean.getTime();
    }
}
