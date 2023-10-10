package dataAcess;

import common.Library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Predicate;
import model.SalaryManagement;
import model.Worker;

public class SalaryDao {

    Library lib = new Library();
    private static SalaryDao instance = null;

    public static SalaryDao Instance() {
        if (instance == null) {
            synchronized (SalaryDao.class) {
                if (instance == null) {
                    instance = new SalaryDao();
                }
            }
        }
        return instance;
    }

    public void createSalaryChange(HashMap<Integer, Worker> workers, ArrayList<SalaryManagement> salaries, boolean status) throws Exception {
        while (true) {
            int id = lib.getInt("Enter Worker Id", 0, 1000);
            double salary = lib.getDouble("Enter salary", 0, workers.get(id).getSalary());
            if (!workers.containsKey(id)) {
                throw new Exception("Worker id is not found");
            }
            salaries.add(new SalaryManagement(status, java.util.Calendar.getInstance().getTime(), workers.get(id), salary));
            System.err.println("Changing Salary Success");
            if (!lib.getYN("Do you want to continue (Y/N)")) {
                return;
            }
        }
    }

    public void printListHistory(ArrayList<SalaryManagement> salaries) {
        String formatStr = "%-5s %-10s %-8s %-10s %-10s %10s%n";
        System.out.format(formatStr, "Code", "Name", "Age", "Salary", "Status", "Date");
        for (SalaryManagement salary : salaries) {
            System.out.println(salary);
        }
    }
}
