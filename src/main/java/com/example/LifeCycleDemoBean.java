package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Rajesh Singh on 2/2/2019
 */
@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware,
        ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("I am in LifeCycleDemoBean Constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("The LifeCycleDemoBean has been terminated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("The LifeCycleDemoBean has its properties set" );
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("The Bean Factory has been set");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("My bean name is "+s);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("The application context has been set");
    }

    @PostConstruct
    public  void postConstruct(){
        System.out.println("The postConstruct annotation method has been called");
    }

    @PreDestroy
    public void preDistroy(){
        System.out.println("The pre distroy method has been called.");
    }

    public void beforeInit(){
        System.out.println("The before init method has been called by Post processor");
    }

    public void afterInit(){
        System.out.println("The after init method has been called by Post processor");
    }
}
