package dataAcess;

import common.Library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Predicate;
import model.Worker;

public class WorkerDao {

    Library lib = new Library();
    private static WorkerDao instance = null;

    public static WorkerDao Instance() {
        if (instance == null) {
            synchronized (WorkerDao.class) {
                if (instance == null) {
                    instance = new WorkerDao();
                }
            }
        }
        return instance;
    }

    public void createWorker(HashMap<Integer, Worker> workers) throws Exception {
        while (true) {
            int id = lib.getInt("Enter Worker Id", 0, 1000);
            String name = lib.getString("Enter Worker Name");
            double salary = lib.getDouble("Enter worker salary",0,1000000000);
            int age = lib.getInt("Enter worker age", 18, 50);
            String location = lib.getString("Enter work Location");
            if (workers.containsKey(id)) {
                throw new Exception("Worker id is duplicated");
            }
            workers.put(id, new Worker(id, name, age, salary, location));
            System.err.println("Create Success");
            if (!lib.getYN("Do you want to continue (Y/N)")) {
                return;
            }
        }
    }
    



    public void printListNameWorker(HashMap<Integer, Worker> workers) {
        System.out.println("Code\tName\tSpecialization\tAvailability");
        Set keySet = workers.keySet();
        for (Object o : keySet) {
            System.out.println(workers.get(o));
        }
    }
}
