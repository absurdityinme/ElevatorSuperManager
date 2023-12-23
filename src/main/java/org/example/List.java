package org.example;

public class List {
    Number head;
    public List(int nums) {
        for (int i = 1; i <= nums; ++i) {
            Number number = new Number(i);
            add(number);
            if (i == nums) {
                number.next = head;
                head.previous = number;
            }
        }
    }
    private void add(Number e1) {
        if (head == null) {
            head = e1;
        }
        else {
            Number current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = e1;
            e1.previous = current.next;
        }
    }
    public void output() {
        Number current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
