package org.example;


public class Main{
    public static void main(String[] args) {
        Elevator[] elevators = new Elevator[7];
        List listEven = new List(3);    // 3 even elevators
        List listOdd = new List(3);    // 3 odd elevators
        List listStaff = new List(1);    // maybe there will be more in the future
        // creation of elevators: 3 even, 3 odd, 1 staff
        for (int i = 0; i < elevators.length; ++i) {
            if (i < 3) elevators[i] = new EvenElevator(Options.EVEN);
            else if (i < 6) elevators[i] = new OddElevator(Options.ODD);
            else elevators[i] = new StaffElevator(Options.STAFF);
        }
        try {
            call(elevators, listEven, listOdd, listStaff);
        }
        catch (ElevatorsBusy a) {
            System.out.println(a.getMessage());
        }

        // set 1 even elevator free & try again
        elevators[0].setStatus(Status.FREE);
        try {
            call(elevators, listEven, listOdd, listStaff);
        }
        catch (ElevatorsBusy a) {
            System.out.println(a.getMessage());
        }

    }


    public static void call(Elevator[] elevators, List listEven, List listOdd, List listStaff) throws ElevatorsBusy {
        // 21 calls of elevators
        for (int i = 0; i < 3; ++i) {
            int countOfBusy = 0;
            Number currentEven = listEven.head;
            Number currentOdd = listOdd.head;
            Number currentStaff = listStaff.head;
            for (int j = 0; j < 7; ++j) {
                if (elevators[j].free()) {
                    if (elevators[j].getOption().equals(Options.EVEN)) {
                        elevators[j].number = currentEven;
                        currentEven = currentEven.next;
                    }
                    else if (elevators[j].getOption().equals(Options.ODD)) {
                        elevators[j].number = currentOdd;
                        currentOdd = currentOdd.next;
                    }
                    else {
                        elevators[j].number = currentStaff;
                        currentStaff = currentStaff.next;
                    }
                    elevators[j].call();
                }
                else countOfBusy++;
            }
            if (countOfBusy == elevators.length) throw new ElevatorsBusy("Sorry all the elevators are currently busy, please wait !");
        }
    }

}