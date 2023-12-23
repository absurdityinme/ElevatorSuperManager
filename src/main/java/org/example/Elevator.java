package org.example;

public abstract class Elevator implements Free, Call {
    private final Options option;
    private Status status = Status.FREE;
    public Number number;
    Elevator(Options option) {
        this.option = option;
    }
    public boolean free() {
        return status == Status.FREE;
    }
    public void call() {
        status = Status.BUSY;
        System.out.println("You called " + option.getValue() + " elevator №" + number.value + " !");
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Options getOption() {
        return option;
    }
}
