package com.aroussi.springproxy.cglib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class ProxyConfig {

    @Bean
    @Scope(value = "singleton")
    SingletonBean singletonBean(){
        return new SingletonBean(prototypeBean());
    }

    /*
     ProxyMode inform spring that we will use a proxy to our original bean ( managed by CGLIB : TARGET_CLASS ),
     that means exposing the exact same interface as the PrototypeBean class, and that is smart enough to be able
     to go off and fetch the real PrototypeBean object from whatever underlying scoping mechanism we have chosen
     (HTTP request, Session, etc.) and execute the original method.

     otherwise PrototypeBean will be treated as a singleton (conceptually) ( default scope ) and will be injected only once during
     ApplicationContext lifecycle
     */
    @Bean
    @Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
    PrototypeBean prototypeBean(){
        return new PrototypeBean();
    }

}
