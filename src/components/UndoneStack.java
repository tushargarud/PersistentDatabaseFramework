package components;

import java.util.Stack;

import dal.MysqlImplCmd;

public class UndoneStack {
	
	private static Stack<MysqlImplCmd> uStack;
	
	public static void initialize()
	{
		uStack = new Stack<MysqlImplCmd>();		
	}
	
	public static void push(MysqlImplCmd cmd)
	{
		uStack.push(cmd);
	}
	
	public static MysqlImplCmd pop()
	{
		if(!uStack.isEmpty())
			return uStack.pop();
		
		return null;
	}
		
}
