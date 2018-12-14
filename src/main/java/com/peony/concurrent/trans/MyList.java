package com.peony.concurrent.trans;

import java.util.ArrayList;

public class MyList {

    private ArrayList<String> list = new ArrayList<String>();

    public void add(String item){
        list.add(item);
    }

    public int size(){
        return list.size();
    }
}
