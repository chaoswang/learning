package com.github.chaoswang.java2s.designpattern.builder;

class Menu
{
}

class ToolBar
{
}

class MainWindow
{
    Menu menu;

    ToolBar toolBar;

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

    public ToolBar getToolBar()
    {
        return toolBar;
    }

    public void setToolBar(ToolBar toolBar)
    {
        this.toolBar = toolBar;
    }
}

class WindowBuilder
{
    public static MainWindow createWindow()
    {
        MainWindow window = new MainWindow();
        Menu menu = new Menu();
        ToolBar toolBar = new ToolBar();
        window.setMenu(menu);
        window.setToolBar(toolBar);
        return window;
    }
}

public class BuilderClient
{
    public static void main(String[] args)
    {
        MainWindow object = WindowBuilder.createWindow();

    }
}