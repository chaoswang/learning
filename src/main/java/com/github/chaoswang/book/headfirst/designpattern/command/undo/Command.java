package com.github.chaoswang.book.headfirst.designpattern.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
