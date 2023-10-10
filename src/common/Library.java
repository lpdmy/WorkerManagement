package common;

import java.util.Scanner;

public class Library {

    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }

    public String getString(String mes) {
        System.out.print(mes + ": ");
        return sc.nextLine();
    }


    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a < m || a > n || a == 0) {
                    System.out.println("Please enter a number between " + m + " and " + n);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public double getDouble(String promt, double m, double n) {
        double a = m - 1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Double.parseDouble(s);
                if (a < m || a > n || a == 0) {
                    System.out.println("Please enter a number greater than zero: ");

                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number greater than zero: ");
            }
        }
        return a;
    }

    public boolean getYN(String promt) {
        boolean a;
        while (true) {
            System.out.print(promt + ": ");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("Y")) {
                return true;
            }
            if (s.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please enter Y or N ");
        }
    }


}
