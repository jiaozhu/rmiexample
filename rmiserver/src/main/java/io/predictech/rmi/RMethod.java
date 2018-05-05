package io.predictech.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Weijie Zhao
 * @email tttx(at)me.com
 * @date 2018/5/5
 * @description
 */
public interface RMethod extends Remote {
    String sayHello(String name) throws RemoteException;
}
