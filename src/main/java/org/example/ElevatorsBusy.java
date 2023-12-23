package org.example;

public class ElevatorsBusy extends Exception {
    ElevatorsBusy() { super(); }
    ElevatorsBusy(String message) { super(message); }
}
