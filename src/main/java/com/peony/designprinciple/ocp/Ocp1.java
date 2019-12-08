package com.peony.designprinciple.ocp;

public class Ocp1 {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.draw(1);
        graphicEditor.draw(2);
        graphicEditor.draw(3);


    }


}

class GraphicEditor{

    /**
     * 这里违反了OCP原则，如果增加新的图形画法，则需要通过修改现有的代码来实现，
     * 而现有的方法，可能会在外部有调用，此时如果修改了，会有风险
     * @param type
     */
    public void draw(int type){
        if (type == 1){
            System.out.println(" 画了圆形");
        }else if (type == 2){
            System.out.println(" 画了矩形 ");
        }else if (type == 3){
            System.out.println(" 画了三角形 ");
        }
    }
}
