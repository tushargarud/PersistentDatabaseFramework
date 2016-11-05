package controllers;

import components.ExecutedStack;
import components.UndoneStack;
import dal.MysqlImplCmd;

public class UndoController {
	
	public void undo()
	{
		MysqlImplCmd cmd = ExecutedStack.pop();
		cmd.undo();
		UndoneStack.push(cmd);
	}

}
