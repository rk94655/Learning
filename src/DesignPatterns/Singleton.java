package DesignPatterns;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {
    private static volatile Singleton singletonObject;
    private Singleton(){
        if(singletonObject!=null){
            throw new IllegalStateException("Object already created");//to handle reflection issue
        }
    }

    public static Singleton getInstance(){
        if(singletonObject==null){
            synchronized (Singleton.class){
                if(singletonObject==null){
                    singletonObject=new Singleton();
                }
            }
        }
        return singletonObject;
    }

    //to handle clone
    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }

    //to handle deserialization
    protected Object readResolve(){
        return singletonObject;
    }

}
