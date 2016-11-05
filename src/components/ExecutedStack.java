package components;

import java.util.Stack;

import dal.MysqlImplCmd;

public class ExecutedStack {
	
	private static Stack<MysqlImplCmd> eStack;
	
	public static void initialize()
	{
		eStack = new Stack<MysqlImplCmd>();		
	}
	
	public static void push(MysqlImplCmd cmd)
	{
		eStack.push(cmd);
	}
	
	public static MysqlImplCmd pop()
	{
		if(!eStack.isEmpty())
			return eStack.pop();
		
		return null;
	}
		
}
