package com.app.viewgroup.todowithfragments;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;


public class TodoItem   implements Serializable {

private String title;
private String description;
private String date;

    public TodoItem() {
    }

    public TodoItem(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public static Comparator<TodoItem> Compare_By_Date=new Comparator<TodoItem>() {
        @Override
        public int compare(TodoItem todoItem, TodoItem t1) {
            return todoItem.date.compareTo(t1.date);
        }
    };


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}