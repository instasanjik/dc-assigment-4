package kz.edu.aitu;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class RMIClient {
    public static String hostName = "localhost";
    public static int port = 8080;
    public static String RMI_HOSTNAME = "java.rmi.server.hostname";
    public static String SERVICE_PATH = "//" + hostName + ":" + port + "/Service";

    public static void main(String[] args) {
        try {
            System.setProperty(SERVICE_PATH, hostName);
            IService service = (IService) Naming.lookup(SERVICE_PATH);

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter words in one line with spaces in between: ");
                String[] words = scanner.nextLine().split(" ");
                List<Integer> result = service.findPallindroms(words);

                if (result.size() == 0) {
                    System.out.println("No pallindroms found");
                } else {
                    System.out.println("Pallindroms found: ");
                    for (Integer i : result) {
                        System.out.println(words[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
