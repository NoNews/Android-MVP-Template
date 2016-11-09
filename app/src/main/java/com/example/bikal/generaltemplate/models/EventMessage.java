package com.example.bikal.generaltemplate.models;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class EventMessage {

    private int id;
    private Object data;
    private Object secondData;



    public EventMessage(int type){
        this.id =type;
    }


    public EventMessage(int type, Object data){
        this.id =type;
        this.data=data;
    }

    public EventMessage(int type, Object data, Object secondData) {
        this.id = type;
        this.data = data;
        this.secondData = secondData;
    }

    public int getId() {
        return id;
    }

    public Object getData() {
        return data;
    }

    public Object getSecondData() {
        return secondData;
    }
}
