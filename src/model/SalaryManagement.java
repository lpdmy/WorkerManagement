package model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryManagement {

    private boolean status; //true if up, false if down;
    private Date date;
    private Worker worker;
    private double amount;
    private double recentSalary;

    public SalaryManagement(boolean status, Date date, Worker worker, double amount) {
        this.status = status;
        this.date = date;
        this.worker = worker;
        changeSalary(status, worker, amount);
        this.recentSalary = worker.getSalary();
    }

    public SalaryManagement() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void changeSalary(boolean status, Worker worker, double amount) {
        if (status) {
            worker.setSalary(amount + worker.getSalary());
        } else {
            worker.setSalary(worker.getSalary() - amount);
        }
    }

    public String statusUD() {
        if (status) {
            return "UP";
        }
        return "DOWN";
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = formatter.format(date);
        DecimalFormat df = new DecimalFormat("#,###.##");
        String formatSalary = df.format(recentSalary);
        String formatStr = "%-5s %-10s %-8s %-10s %-10s %10s%n";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        ps.format(formatStr, worker.getId(), worker.getName(), worker.getAge()+"", formatSalary + " $", statusUD(), dateInString);
        String formattedString = out.toString();
        return formattedString;
    }

}
