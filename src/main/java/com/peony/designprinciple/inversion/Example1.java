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
    public void receive(Email email){
        String info = email.getInfo();
        System.out.println(info);
    }
}
