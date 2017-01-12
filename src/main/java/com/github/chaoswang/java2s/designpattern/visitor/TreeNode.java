package com.github.chaoswang.java2s.designpattern.visitor;

/**
 * In visitor pattern, element object accepts the visitor object and visitor object handles the operation on the element object.
 * By this way, execution algorithm of element can be changed from different visitors.
 * @author 10094714
 *
 */
class TreeNode
{
    private String name;

    public TreeNode(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void accept(NodeVisitor v)
    {
        v.visit(this);
    }

    public static void main(String[] args)
    {

        TreeNode computer = new TreeNode("Java2s.com");
        computer.accept(new ConsoleVisitor());
        computer.accept(new EmailVisitor());
    }
}

interface NodeVisitor
{
    public void visit(TreeNode n);
}

class ConsoleVisitor implements NodeVisitor
{
    @Override
    public void visit(TreeNode n)
    {
        System.out.println("console:" + n.getName());
    }
}

class EmailVisitor implements NodeVisitor
{
    @Override
    public void visit(TreeNode n)
    {
        System.out.println("email:" + n.getName());
    }
}
