package repository1;

import dataAcess.SalaryDao;
import java.util.ArrayList;
import java.util.HashMap;
import model.SalaryManagement;
import model.Worker;

public class SalaryRepository {

    public void addSalary(HashMap<Integer,Worker> workers, ArrayList<SalaryManagement> salaries, boolean status) throws Exception {
        SalaryDao.Instance().createSalaryChange(workers,salaries,status);
    }
     public void printAllSalary(ArrayList<SalaryManagement> salaries) {
        SalaryDao.Instance().printListHistory(salaries);
    }

}
