package com.github.chaoswang.java2s.designpattern.nullobject;

abstract class AbstractEmployee
{
    protected String name;

    public abstract boolean isNull();

    public abstract String getName();
}

class Programmer extends AbstractEmployee
{
    public Programmer(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public boolean isNull()
    {
        return false;
    }
}

class NullCustomer extends AbstractEmployee
{
    @Override
    public String getName()
    {
        return "Not Available";
    }

    @Override
    public boolean isNull()
    {
        return true;
    }
}

class EmployeeFactory
{
    public static final String[] names = { "Rob", "Joe", "Jack" };

    public static AbstractEmployee getCustomer(String name)
    {
        for (int i = 0; i < names.length; i++)
        {
            if (names[i].equalsIgnoreCase(name))
            {
                return new Programmer(name);
            }
        }
        return new NullCustomer();
    }
}
