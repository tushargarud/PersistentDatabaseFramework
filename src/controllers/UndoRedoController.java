package controllers;

import components.ExecutedStack;
import components.UndoneStack;
import dal.MysqlImplCmd;

public class UndoRedoController {
	
	public void undo()
	{
		MysqlImplCmd cmd = ExecutedStack.pop();
		cmd.undo();
		UndoneStack.push(cmd);
	}
	
	public void redo()
	{
		MysqlImplCmd cmd = UndoneStack.pop();
		cmd.execute();
		ExecutedStack.push(cmd);
	}

}
