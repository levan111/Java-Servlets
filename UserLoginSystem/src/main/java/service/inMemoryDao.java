package service;


import entity.user;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class inMemoryDao {

    private static inMemoryDao obj = null;
    private static Lock myLock = new ReentrantLock();
    private ConcurrentHashMap<String, user> data;

    private inMemoryDao() {
        data = new ConcurrentHashMap<>();
    }

    public static inMemoryDao getInstance(){
        if(obj == null){
            myLock.lock();
            if(obj == null){
                obj = new inMemoryDao();
            }
            myLock.unlock();
        }
        return obj;
    }

    public boolean addUser(String userName,String password) throws InterruptedException {
        if(data.containsKey(userName)) return false;
        data.put(userName,new user(userName,password));
        return true;
    }

    public boolean userExists(String userName){
        return data.containsKey(userName);
    }

    public boolean Login(String userName,String password){
        if(userExists(userName)){
            user inp = data.get(userName);
            return inp.getUsername().equals(userName) && inp.getPassword().equals(password);
        }
        return false;
    }

}
