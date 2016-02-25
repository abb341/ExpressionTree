import java.util.Scanner;

public class ExpressionEvaluator
{

	private static final int GARBAGE = Token.GARBAGE;
	private static Scanner user = new Scanner(System.in);

	public static void main(String[] args)
	{
		boolean quit = false;
		while (!quit)
		{
			ExpressionTree expressionTree = generateExpressionTree();
			System.out.println(expressionTree);
			System.out.println(expressionTree.evaluate());

			System.out.println("Enter 'q' to quit or enter any letter to continue");
			String input = user.nextLine();
			System.out.println(input);
			if (input.equals("q"))
			{
				quit = true;
			}
		}
	}

	/**
	 * Generates the expression tree by getting user input, turning tokens into expression trees,
	 * 		adding these trees into a stack and then creating 1 big tree after the end token is entered
	 * @return an ExpressionTree that contains all the tokens the user entered
	 */
	public static ExpressionTree generateExpressionTree()
	{
		Stack stack = new Stack(GARBAGE);
		while (true)
		{
			Token enteredToken = getToken();
			if (enteredToken == null)
			{
				System.out.println("ERROR: Invalid Token");
			}
			else if (enteredToken.getType() == Token.NUMBER)
			{
				ExpressionTree insertedTree = new ExpressionTree(enteredToken, null, null);
				stack.push(insertedTree);
			}
			else if (enteredToken.getType() == Token.UNARY)
			{
				ExpressionTree lastTree = (ExpressionTree) stack.pop();
				stack.push(new ExpressionTree(enteredToken, lastTree, null));
			}
			else if (enteredToken.getType() == Token.BINARY)
			{
				ExpressionTree exprTree = (ExpressionTree) stack.pop();
				ExpressionTree exprTree2 = (ExpressionTree) stack.pop();
				stack.push(new ExpressionTree(enteredToken, exprTree, exprTree2));
			}
			else if (enteredToken.getType() == Token.END)
			{
				return (ExpressionTree) stack.pop();
			}
			else
			{
				System.out.println("ERROR");
				return null;
			}
		}
	}

	/**
	 * Creates a token based off of what the user enters
	 * @return
	 */
	public static Token getToken()
	{
		Token enteredToken;

		int type = Token.ERROR;
		do
		{
			// Get user input and make sure that it is not a bad type
			System.out.println("Choose a token type: '#', 'u', 'b', 'e'");
			String tokenType = getUserInput();
			type = convertType(tokenType);
		}
		while (type == Token.ERROR);

		if (type == Token.NUMBER)
		{
			enteredToken = newNumberToken();
		}
		else if (type == Token.UNARY || type == Token.BINARY)
		{
			System.out.println("Enter op");
			String tokenOp = user.nextLine();
			System.out.println(tokenOp);
			int op = convertOp(type, tokenOp);

			if (op == Token.ERROR)
			{
				// Error: Bad Operation
				enteredToken = null;
			}
			else
			{
				enteredToken = new Token(type, GARBAGE, op);
			}

		}
		else if (type == Token.END)
		{
			enteredToken = new Token(type, GARBAGE, GARBAGE);
		}
		else
		{
			// Error: Bad Type
			enteredToken = null;
		}

		System.out.println(enteredToken);
		return enteredToken;
	}

	/**
	 * Gets the user input if it is a string
	 * @return String userInput
	 */
	public static String getUserInput()
	{
		String userInput;
		System.out.println("Enter a command");
		userInput = user.nextLine();
		System.out.println(userInput);
		return userInput;
	}

	public static int convertType(String tokenType)
	{
		if (tokenType.equals("#"))
		{
			return Token.NUMBER;
		}
		else if (tokenType.equals("u"))
		{
			return Token.UNARY;
		}
		else if (tokenType.equals("b"))
		{
			return Token.BINARY;
		}
		else if (tokenType.equals("e"))
		{
			return Token.END;
		}
		else
		{
			// Error: Bad Type
			System.out.println("Error: Bad Type");
			return Token.ERROR;
		}
	}
	
	public static Token newNumberToken()
	{
		int type = Token.NUMBER;
		
		System.out.println("Enter number:");
		double tokenNumber = user.nextDouble();
		user.nextLine();
		System.out.println(tokenNumber);

		Token enteredToken = new Token(type, tokenNumber, GARBAGE);
		return enteredToken;
	}

	/**
	 * Converts the String for the operation that the user entered into the proper type
	 * 		that the Token class can read
	 * @param type
	 * @param tokenOp
	 * @return
	 */
	public static int convertOp(int type, String tokenOp)
	{
		if (type == Token.UNARY)
		{
			if (tokenOp.equals("+"))
			{
				return Token.PLUS;
			}
			else if (tokenOp.equals("-"))
			{
				return Token.MINUS;
			}
			else
			{
				// Error: Bad Operation
				return Token.ERROR;
			}
		}
		else if (type == Token.BINARY)
		{
			if (tokenOp.equals("+"))
			{
				return Token.ADD;
			}
			else if (tokenOp.equals("-"))
			{
				return Token.SUBTRACT;
			}
			else if (tokenOp.equals("*"))
			{
				return Token.MULTIPLY;
			}
			else if (tokenOp.equals("/"))
			{
				return Token.DIVIDE;
			}
			else
			{
				// Error: Bad Operation
				return Token.ERROR;
			}
		}
		else
		{
			// Error: Bad Type
			return Token.ERROR;
		}
	}

}
