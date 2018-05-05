package io.predictech.rmi;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author Weijie Zhao
 * @email tttx(at)me.com
 * @date 2018/5/5
 * @description
 */
public class Client {
    private String name;
    private String hostURL;
    private String obj;

    public Client(String name) {
        this.name = name;
        hostURL = "rmi://" + Config.SERVER_IP + ":" + Config.PORT + "/";
        this.obj = Config.OBJECT_NAME;
    }

    public void callRMethod() {
        try {
            RMethod rm = (RMethod) java.rmi.Naming.lookup(hostURL + obj);
            String result = rm.sayHello(name);
            System.out.println(result);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client c1 = new Client("Monica");
        c1.callRMethod();

        Client c2 = new Client("Joy");
        c2.callRMethod();

        Client c3 = new Client("Ross");
        c3.callRMethod();

        Client c4 = new Client("Chandler");
        c4.callRMethod();
    }
}
