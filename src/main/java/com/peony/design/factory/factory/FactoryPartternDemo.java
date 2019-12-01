package com.peony.design.factory.factory;

public class FactoryPartternDemo {

    public static void main(String[] args) {
        Shape circle = ShapeFactory.create("circle");
        circle.draw();
        Shape square = ShapeFactory.create("square");
        square.draw();
        Shape rectangle = ShapeFactory.create("rectangle");
        rectangle.draw();
        System.out.println("simple factory");

    }
}
