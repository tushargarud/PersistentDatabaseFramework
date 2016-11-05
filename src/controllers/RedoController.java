package controllers;

import components.ExecutedStack;
import components.UndoneStack;
import dal.MysqlImplCmd;

public class RedoController {
	
	public void redo()
	{
		MysqlImplCmd cmd = UndoneStack.pop();
		cmd.execute();
		ExecutedStack.push(cmd);
	}

}
