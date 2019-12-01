package com.peony.design.factory.factory;

public class ShapeFactory {

    public static Shape create(String shape){
        if ("circle".equalsIgnoreCase(shape)){
            return new Circle();
        }else if ("square".equalsIgnoreCase(shape)){
            return new Square();
        }else if ("rectangle".equalsIgnoreCase(shape)){
            return new Rectangle();
        }else {
            return null;
        }
    }
}
