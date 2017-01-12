package com.github.chaoswang.java2s.designpattern.prototype;

class Rectangle extends Shape
{

    public Rectangle()
    {
        type = "Rectangle";
    }

    @Override
    public void draw()
    {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square extends Shape
{

    public Square()
    {
        type = "Square";
    }

    @Override
    public void draw()
    {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle extends Shape
{

    public Circle()
    {
        type = "Circle";
    }

    @Override
    public void draw()
    {
        System.out.println("Inside Circle::draw() method.");
    }
}
