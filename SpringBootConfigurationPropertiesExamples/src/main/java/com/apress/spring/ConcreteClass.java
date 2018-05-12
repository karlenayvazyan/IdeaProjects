package com.apress.spring;

public class ConcreteClass implements Java8Interface, Java8Interface_1 {

    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.hi();

        Java8Interface.hello();
    }

    @Override
    public void hi() {
        Java8Interface.super.hi();
    }
}
