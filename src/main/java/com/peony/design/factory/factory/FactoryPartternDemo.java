package com.peony.design.factory.factory;

public class FactoryPartternDemo {

    public static void main(String[] args) {
        Shape shape = ShapeFactory.create("circle");
        shape.draw();
    }
}
