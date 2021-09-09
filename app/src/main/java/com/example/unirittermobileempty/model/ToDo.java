package com.example.unirittermobileempty.model;

public class ToDo {
    private int id;
    private int user_id;
    private String title;
    private boolean completed;

    public ToDo(int id, int user_id, String title, boolean completed) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
