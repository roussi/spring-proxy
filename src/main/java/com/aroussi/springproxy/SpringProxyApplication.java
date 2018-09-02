package com.aroussi.springproxy;

import com.aroussi.springproxy.cglib.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringProxyApplication {

	/**
	 * @see {spring proxy scope} https://stackoverflow.com/questions/14371335/spring-scoped-proxy-bean?answertab=votes#tab-top
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringProxyApplication.class, args);

		SingletonBean singletonBean= context.getBean(SingletonBean.class);
		System.out.println("1: "+singletonBean.getDate());

		SingletonBean singletonBean2= context.getBean(SingletonBean.class);
		System.out.println("2: "+singletonBean2.getDate());


	}
}
