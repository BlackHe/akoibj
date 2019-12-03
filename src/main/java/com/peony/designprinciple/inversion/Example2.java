package com.peony.designprinciple.inversion;

public class Example2 {
    public static void main(String[] args) {
        Person1 person = new Person1();
        person.receive(new Email1());
        person.receive(new Wechat());

    }

}

interface IReceiver{
    String getInfo();
}
class Email1 implements IReceiver {
    @Override
    public String getInfo() {
        return  "email message: hello world";
    }
}
class Wechat implements IReceiver{

    @Override
    public String getInfo() {
        return "wechat message: hello world";
    }
}

class Person1{
    public void receive(IReceiver receiver){
        String info = receiver.getInfo();
        System.out.println(info);
    }
}
