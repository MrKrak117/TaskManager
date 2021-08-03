package com.example.taskmanager.util;

public enum TaskType {
    GET(1),
    SAVE(2),
    DELETE(3);

    private final int actionNumber;

    private TaskType(int actionNumber){
        this.actionNumber = actionNumber;
    }

    public int getActionNumber(){
        return this.actionNumber;
    }
}
