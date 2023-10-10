package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import model.Worker;

public interface IWorkerRepository {
    void addWorker(HashMap<Integer,Worker> workers) throws Exception;
//    void updateDoctor(HashMap<String,Doctor> doctors, Doctor doctor) throws Exception;
//    void deleteDoctor(HashMap<String,Doctor> doctors,String code) throws Exception;
//    public HashMap<String,Doctor> search(HashMap<String,Doctor> doctors, Predicate<Doctor> c) throws Exception;
    void printAllDoctors (HashMap<Integer, Worker> workers);
}
