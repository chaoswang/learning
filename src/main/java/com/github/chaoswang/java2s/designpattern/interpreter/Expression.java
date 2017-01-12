/**
 * We normally use Interpreter pattern to evaluate language grammar or expression.
 */
package com.github.chaoswang.java2s.designpattern.interpreter;

interface Expression
{
    public boolean evaluate(String context);
}

class IsInExpression implements Expression
{
    private String data;

    public IsInExpression(String data)
    {
        this.data = data;
    }

    @Override
    public boolean evaluate(String context)
    {
        if (context.contains(data))
        {
            return true;
        }
        return false;
    }
}

class OrExpression implements Expression
{

    private Expression expr1 = null;

    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2)
    {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean evaluate(String context)
    {
        return expr1.evaluate(context) || expr2.evaluate(context);
    }
}

class AndExpression implements Expression
{

    private Expression expr1 = null;

    private Expression expr2 = null;

    public AndExpression(Expression expr1, Expression expr2)
    {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean evaluate(String context)
    {
        return expr1.evaluate(context) && expr2.evaluate(context);
    }
}
