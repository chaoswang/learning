package com.github.chaoswang.java2s.designpattern.responsibilitychain;

abstract class Logger
{
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger)
    {
        this.nextLogger = nextLogger;
    }

    public void logMessage(String message)
    {
        log(message);
        if (nextLogger != null)
        {
            nextLogger.logMessage(message);
        }
    }

    abstract protected void log(String message);
}

class ConsoleLogger extends Logger
{
    public ConsoleLogger()
    {
    }

    @Override
    protected void log(String message)
    {
        System.out.println("Console::Logger: " + message);
    }
}

class EMailLogger extends Logger
{
    public EMailLogger()
    {
    }

    @Override
    protected void log(String message)
    {
        System.out.println("EMail::Logger: " + message);
    }
}

class FileLogger extends Logger
{
    public FileLogger()
    {
    }

    @Override
    protected void log(String message)
    {
        System.out.println("File::Logger: " + message);
    }
}
