package com.github.chaoswang.java2s.designpattern.mediator;

class Printer
{
    public static void showMessage(Machine user, String message)
    {
        System.out.println(new java.util.Date().toString() + " [" + user.getName() + "] : " + message);
    }
    
    public static void main(String[] args)
    {
        Machine m1 = new Machine("M1");
        Machine m2 = new Machine("M2");

        m1.sendMessage("Rebooting");
        m2.sendMessage("Computing");
    }
}

class Machine
{
    private String name;

    public Machine(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void sendMessage(String message)
    {
        Printer.showMessage(this, message);
    }
}

