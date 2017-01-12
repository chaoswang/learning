package com.github.chaoswang.java2s.designpattern.responsibilitychain;

public class Main
{
    private static Logger getChainOfLoggers()
    {
        Logger emailLogger = new EMailLogger();
        Logger fileLogger = new FileLogger();
        Logger consoleLogger = new ConsoleLogger();
        emailLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return emailLogger;
    }

    public static void main(String[] args)
    {
        Logger loggerChain = getChainOfLoggers();
        loggerChain.logMessage("Null pointer");
        loggerChain.logMessage("Array Index Out of Bound");
        loggerChain.logMessage("Illegal Parameters");
    }
}
