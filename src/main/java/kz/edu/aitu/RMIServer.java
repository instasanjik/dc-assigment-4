package kz.edu.aitu;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        String hostName = "localhost";
        int port = 8080;
        String RMI_HOSTNAME = "java.rmi.server.hostname";
        try {
            System.setProperty(RMI_HOSTNAME, hostName);

            Service service = new Service();

            String serviceName = "Service";

            Registry registry = LocateRegistry.createRegistry(port);

            registry.rebind(serviceName, service);

            System.out.println("Start " + serviceName);
        } catch (RemoteException e) {
            System.out.println("Remote is not working");
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
