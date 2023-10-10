package repository;

import dataAcess.WorkerDao;
import java.util.HashMap;

import model.Worker;

public class WorkerRepository implements IWorkerRepository {

    @Override
    public void addWorker(HashMap<Integer, Worker> doctors) throws Exception {
        WorkerDao.Instance().createWorker(doctors);
    }

    @Override
    public void printAllDoctors(HashMap<Integer, Worker> workers) {
        WorkerDao.Instance().printListNameWorker(workers);
    }

}
