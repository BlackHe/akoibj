package com.peony.designprinciple.inversion;

public class Example1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());

    }

}

class Email{
    public String getInfo(){
        return "email message: hello world";
    }
}

class Person{
    // 此时依赖了email这个实现类，依赖的是类，如果后续接受的消息不是邮件，而是微信，
    // 则，这里就要改动，显然违反了开闭原则，
    public void receive(Email email){
        String info = email.getInfo();
        System.out.println(info);
    }
}
