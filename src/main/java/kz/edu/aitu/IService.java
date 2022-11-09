package kz.edu.aitu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IService extends Remote {
    public List<Integer> findPallindroms(String[] words) throws RemoteException;
}
