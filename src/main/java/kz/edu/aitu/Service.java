package kz.edu.aitu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Service extends UnicastRemoteObject implements IService {
    ExecutorService executorService = null;

    public Service() throws RemoteException {
        super();
        this.executorService = Executors.newCachedThreadPool();
    }

    @Override
    public List<Integer> findPallindroms(String[] words) throws RemoteException {
        List<Integer> result = new ArrayList<>();
        List<Future<Boolean>> futures = new ArrayList<>();
        int i = 0;
        for (String word : words) {
            futures.add(executorService.submit(new PalindromeCallable(word)));
        }
        for (Future<Boolean> future : futures) {
            try {
                if (future.get()) {
                    result.add(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
        return result;
    }
}
