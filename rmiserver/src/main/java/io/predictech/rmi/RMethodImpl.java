package io.predictech.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Weijie Zhao
 * @email tttx(at)me.com
 * @date 2018/5/5
 * @description
 */
public class RMethodImpl extends UnicastRemoteObject implements RMethod {


    protected RMethodImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.println("Client-" + name + ": invoking \" sayHello \"");
        return "Hello " + name + "\n thisis a message from Remote Method";
    }
}
