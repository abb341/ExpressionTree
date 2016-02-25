
public class Token
{
	// Special Cases
	public static final int ERROR = -1;
	public static final int GARBAGE = 0;
	
	// Token Types
	public static final int NUMBER = 1;
	public static final int UNARY = 2;
	public static final int BINARY = 3;
	public static final int END = 4;
	
	// Unary Ops 
	public static final int PLUS = 5; 
	public static final int MINUS = 6;
	
	// Binary Ops
	public static final int ADD = 7; 
	public static final int SUBTRACT = 8; 
	public static final int MULTIPLY = 9; 
	public static final int DIVIDE = 10;

	// Data
	private int type;
	private double num;
	private int op;
	
	public Token(int type, double num, int op)
	{
		this.type = type;
		this.num = num;
		this.op = op;
	}
	
	// Accessors
	public int getType()
	{
		return type;
	}
	
	public double getNum()
	{
		return num;
	}
	
	public int getOp()
	{
		return op;
	}
	
	public String toString()
	{
		if (type == NUMBER)
		{
			return "#" + num;
		}
		else if (type == UNARY)
		{
			return "u" + op;
		}
		else if (type == BINARY)
		{
			return "b" + op;
		}
		else if (type == END)
		{
			return "e";
		}
		else
		{
			// ERROR
			return "Token Error";
		}
	}

}
