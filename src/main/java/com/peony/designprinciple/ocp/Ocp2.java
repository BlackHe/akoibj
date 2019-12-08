package com.peony.designprinciple.ocp;

public class Ocp2 {

    public static void main(String[] args) {
        GraphicEditor2.draw(new Circle(1));
        GraphicEditor2.draw(new Squear(2));
    }
}

class GraphicEditor2{
    /**
     * 此处 画图形方法 接受抽象图形类为参数，
     * 方法体直接调用抽象类的画图方法，此时实现了依赖倒转原则和开闭原则
     * 将具体的图形类交给调用者去判断实现
     * @param shape
     */
    public static void draw(Shape shape){
        shape.draw();
    }
}

/**
 * 用Shape类，将例子1中的图形抽象出来，
 * 用type存储子类传递的标识
 */
abstract class Shape{
    int type;
    Shape(int type){
        this.type = type;
    }
    abstract void draw();
}

class Circle extends Shape{

    Circle(int type){
        super(type);
    }
    @Override
    void draw() {
        System.out.println("hu yuan....");
    }
}

class Squear extends Shape{

    Squear(int type){
        super(type);
    }
    @Override
    void draw() {
        System.out.println("hu zhegnfangxin....");
    }
}

