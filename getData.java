package com.bankApp.bootcamp;

public class getData{
    
    String name, accNum, addrs;
 
    public getData(String name, String accNum, String addrs)
    {
        this.name = name;
        this.accNum = accNum;
        this.addrs = addrs;
    }
     
    public String getName()
    {
       return name;
    }
     
    public String getAccNum()
    {
       return accNum;
    }
     
    public String getAddrs()
    {
       return addrs;
    }
}