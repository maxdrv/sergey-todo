package com.example.demo;

public class TodoList {
    private int id;
    private String text;
    private boolean resul;

    public TodoList(int id, String text) {
        this.id = id;
        this.text = text;
        this.resul = resul;

    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
    public boolean getResult(){return resul;}


    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void setResul(boolean resul){this.resul=resul;}


}


