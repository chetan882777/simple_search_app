package com.heptware.android.j3;


import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private List<DataManager> list = new ArrayList<>();
    private String key;
    private String name;


    // make it singleton
    private DataManager(){}
    private DataManager(String key , String name){
        this.key = key;
        this.name = name;
    }

    // get singleton object
    public static DataManager getInstance(){
        DataManager dm = new DataManager();
        dm.initialize();
        return dm;
    }

    private void initialize(){
        // sample data

        list.add(new DataManager("1a1a1a" , "Chetan"));
        list.add(new DataManager("2b1b1b" , "Darshan"));
        list.add(new DataManager("3c1c1c" , "Ayush"));
        list.add(new DataManager("4d1d1d" , "Bhupendra"));
        list.add(new DataManager("5e1e1e" , "Jitendra"));
        list.add(new DataManager("6f1f1f" , "Jay"));
        list.add(new DataManager("7g1g1g" , "Abhishek"));
        list.add(new DataManager("8h1h1h" , "Ajay"));
        list.add(new DataManager("9j1i1i" , "Chetan Pawar"));
        list.add(new DataManager("0k1j1j" , "Darshan Patidar"));
        list.add(new DataManager("1k0k1k" , "Ayush Bankar"));
        list.add(new DataManager("1m2m1m" , "Bhupendra Prajapati"));
        list.add(new DataManager("1n3n1n" , "Jitendra Prajapat"));
        list.add(new DataManager("1o4o1o" , "Jay Narayan"));
        list.add(new DataManager("1p5p1p" , "Abhishek Maheshwari"));
        list.add(new DataManager("1q6q1q" , "Ajay Sharma"));

        list.add(new DataManager("1a1a1a" , "Chetan"));
        list.add(new DataManager("2b1b1b" , "Darshan"));
        list.add(new DataManager("3c1c1c" , "Ayush"));
        list.add(new DataManager("4d1d1d" , "Bhupendra"));
        list.add(new DataManager("5e1e1e" , "Jitendra"));
        list.add(new DataManager("6f1f1f" , "Jay"));
        list.add(new DataManager("7g1g1g" , "Abhishek"));
        list.add(new DataManager("8h1h1h" , "Ajay"));
        list.add(new DataManager("9j1i1i" , "Chetan Pawar"));
        list.add(new DataManager("0k1j1j" , "Darshan Patidar"));
        list.add(new DataManager("1k0k1k" , "Ayush Bankar"));
        list.add(new DataManager("1m2m1m" , "Bhupendra Prajapati"));
        list.add(new DataManager("1n3n1n" , "Jitendra Prajapat"));
        list.add(new DataManager("1o4o1o" , "Jay Narayan"));
        list.add(new DataManager("1p5p1p" , "Abhishek Maheshwari"));
        list.add(new DataManager("1q6q1q" , "Ajay Sharma"));


        list.add(new DataManager("111a1a" , "zChetan"));
        list.add(new DataManager("211b1b" , "zDarshan"));
        list.add(new DataManager("311c1c" , "zAyush"));
        list.add(new DataManager("411d1d" , "zBhupendra"));
        list.add(new DataManager("511e1e" , "zJitendra"));
        list.add(new DataManager("611f1f" , "zJay"));
        list.add(new DataManager("711g1g" , "zAbhishek"));
        list.add(new DataManager("811h1h" , "zAjay"));
        list.add(new DataManager("911i1i" , "zChetan Pawar"));
        list.add(new DataManager("011j1j" , "zDarshan Patidar"));
        list.add(new DataManager("110k1k" , "zAyush Bankar"));
        list.add(new DataManager("112m1m" , "zBhupendra Prajapati"));
        list.add(new DataManager("113n1n" , "zJitendra Prajapat"));
        list.add(new DataManager("114o1o" , "zJay Narayan"));
        list.add(new DataManager("115p1p" , "zAbhishek Maheshwari"));
        list.add(new DataManager("116q1q" , "zAjay Sharma"));


        list.add(new DataManager("2a1a1a" , "Cheta234n"));
        list.add(new DataManager("2b1b1b" , "Darsha234n"));
        list.add(new DataManager("2c1c1c" , "Ayus234h"));
        list.add(new DataManager("3d1d1d" , "Bhupen234dra"));
        list.add(new DataManager("3e1e1e" , "Jite234ndra"));
        list.add(new DataManager("4f1f1f" , "Ja234y"));
        list.add(new DataManager("4g1g1g" , "Abhis324hek"));
        list.add(new DataManager("4h1h1h" , "Aja234y"));
        list.add(new DataManager("5j1i1i" , "Chetan 234Pawar"));
        list.add(new DataManager("5k1j1j" , "Darsh234an Patidar"));
        list.add(new DataManager("5k0k1k" , "Ayu234sh Bankar"));
        list.add(new DataManager("6m2m1m" , "B234hupendra Prajapati"));
        list.add(new DataManager("6n3n1n" , "324Jitendra Prajapat"));
        list.add(new DataManager("6o4o1o" , "J234ay Narayan"));
        list.add(new DataManager("7p5p1p" , "234Abhishek Maheshwari"));
        list.add(new DataManager("7q6q1q" , "342Ajay Sharma"));
    }

    // used to display whole list
    public List<DataManager> getList() {
        return list;
    }

    // to dislay object
    @Override
    public String toString() {
        return key + " - " + name + "\n";
    }

    public List getSearchResult(CharSequence s) {
        List<DataManager> resultSet = new ArrayList<>();
        for(DataManager dm : list){
            String thisKey = dm.key;
            if(thisKey.startsWith(s.toString())){
                resultSet.add(dm);
            }
        }
        return resultSet;
    }


    public DataManager addToList(String key, String value) {
        return new DataManager(key , value);
    }
}
