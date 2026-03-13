/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
class NumberPrinter {

    private int number = 1;
    private final int MAX = 10;

    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 != 0) {
                System.out.printf("%-10d", number);
                number++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 == 0) {
                System.out.println(number);
                number++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class oddeventhreads {
     public static void main(String[] args) {

        NumberPrinter printer = new NumberPrinter();

        Thread oddThread = new Thread(new Runnable() {
            public void run() {
                printer.printOdd();
            }
        });

        Thread evenThread = new Thread(new Runnable() {
            public void run() {
                printer.printEven();
            }
        });

        System.out.println("Odd       Even");

        oddThread.start();
        evenThread.start();
    }
}
