package io.predictech.rmi;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

/**
 * @author Weijie Zhao
 * @email tttx(at)me.com
 * @date 2018/5/5
 * @description
 */
public class Server {
    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        if (null == System.getSecurityManager()) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            try {
                LocateRegistry.createRegistry(Config.PORT);
            } catch (java.rmi.server.ExportException ex) {
                System.out.println("Register the port failed:\n" + ex.getMessage());
            }

            RMethod rm = new RMethodImpl();
            String objAddr = "rmi://" + Config.SERVER_IP + ":" + Config.PORT + "/" + Config.OBJECT_NAME;
            java.rmi.Naming.rebind(objAddr, rm);
            System.out.println("Server is running...");

        } catch (Exception e) {
            System.out.println("Server startup failed!");
            e.printStackTrace();
        }
    }
}
