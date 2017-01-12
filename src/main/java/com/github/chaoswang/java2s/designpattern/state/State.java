package com.github.chaoswang.java2s.designpattern.state;

/**
 * In State pattern a class behavior is changed based on its state.
 * State pattern is a behavior pattern.
 * When using State pattern, we create various state objects and a context object whose behavior varies as its state object changes.
 */
interface State
{
    public void doAction(Context context);
}

class StartState implements State
{
    public void doAction(Context context)
    {
        System.out.println("In start state");
        context.setState(this);
    }

    public String toString()
    {
        return "Start State";
    }
}

class StopState implements State
{

    public void doAction(Context context)
    {
        System.out.println("In stop state");
        context.setState(this);
    }

    public String toString()
    {
        return "Stop State";
    }
}

class PlayState implements State
{
    public void doAction(Context context)
    {
        System.out.println("In play state");
        context.setState(this);
    }

    public String toString()
    {
        return "Play State";
    }
}

class Context
{
    private State state = null;

    public void setState(State state)
    {
        this.state = state;
    }

    public State getState()
    {
        return state;
    }
}
