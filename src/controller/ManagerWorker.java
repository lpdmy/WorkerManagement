package controller;

import view.Menu;
import common.Library;
import java.util.ArrayList;
import java.util.HashMap;
import model.Worker;
import repository1.SalaryRepository;
import repository.WorkerRepository;
import view.Validation;
import model.SalaryManagement;

public class ManagerWorker extends Menu<String> {

    HashMap<Integer, Worker> workers = new HashMap<>();
    ArrayList<SalaryManagement> salaries = new ArrayList<>();
    Library lib = new Library();
    WorkerRepository workerRepository = new WorkerRepository();
    SalaryRepository salaryRepository = new SalaryRepository();
    Validation val = new Validation();
    static String[] menu = {"Add a worker",
        "Increase salary for worker",
        "Decrease for worker",
        "Show adjusted salary worker infomation",
        "Exit"
    };

    public ManagerWorker() {
        super("MENU", menu);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                try {
                    workerRepository.addWorker(workers);
                } catch (Exception ex) {
                    System.out.println("An exception occurred: " + ex.getMessage());
                }
            }
            break;

            case 2: {
                try {
                    salaryRepository.addSalary(workers, salaries, true);
                } catch (Exception ex) {
                    System.out.println("An exception occurred: " + ex.getMessage());
                }
            }
            break;

            case 3: {
                try {
                    salaryRepository.addSalary(workers, salaries, false);
                } catch (Exception ex) {
                    System.out.println("An exception occurred: " + ex.getMessage());
                }
            }
            break;

            case 4:
                salaryRepository.printAllSalary(salaries);
                break;
            case 5:
                System.exit(0);
            default:
                return;
        }
    }

}
