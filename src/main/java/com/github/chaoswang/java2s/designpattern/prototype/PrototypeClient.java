package com.github.chaoswang.java2s.designpattern.prototype;

import java.util.Hashtable;

class ShapeProtoType
{
    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId)
    {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache()
    {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}

public class PrototypeClient
{
    public static void main(String[] args)
    {
        ShapeProtoType.loadCache();

        Shape clonedShape = (Shape) ShapeProtoType.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeProtoType.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeProtoType.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}