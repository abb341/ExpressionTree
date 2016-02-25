
public class ExpressionTree
{
	private TreeNode root = null;
	
	
	public ExpressionTree(Token rootToken, ExpressionTree leftExpr, ExpressionTree rightExpr)
	{
		if (leftExpr != null && rightExpr != null)
		{
			root = new TreeNode(rootToken, leftExpr.root, rightExpr.root);
		}
		else if (leftExpr != null && rightExpr == null)
		{
			root = new TreeNode(rootToken, leftExpr.root, null);
		}
		else if (leftExpr == null && rightExpr != null)
		{
			root = new TreeNode(rootToken, null, rightExpr.root);
		}
		else
		{
			root = new TreeNode(rootToken, null, null);
		}
	}
	
	public Double evaluate()
	{
		return auxEvaluate(root);
	}
	
	public Double auxEvaluate(TreeNode t)
	{
		if (t == null)
		{
			// Error
			return null;
		}
		else
		{
			Token value = (Token) t.getValue();
			if (value.getType() == Token.NUMBER)
			{
				return value.getNum();
			}
			else if (value.getType() == Token.UNARY)
			{
				double left = auxEvaluate(t.getLeft());
				
				if (value.getOp() == Token.MINUS)
				{
					return -left;
				}
				else
				{
					return left;
				}
			}
			else if (value.getType() == Token.BINARY)
			{
				Double left = auxEvaluate(t.getLeft());
				Double right = auxEvaluate(t.getRight());
				
				if (value.getOp() == Token.ADD)
				{
					return left + right;
				}
				else if (value.getOp() == Token.SUBTRACT)
				{
					return left - right;
				}
				else if (value.getOp() == Token.MULTIPLY)
				{
					return left * right;
				}
				else
				{
					return left / right;
				}
			}
			else
			{
				return null;
			}
		}
	}
	
	public String toString()
	{
		return auxToStringPostOrder(root);
	}
	
	private String auxToStringPostOrder(TreeNode t)
	{
		if (t == null)
		{
			return "";
		}
		else
		{
			return 	auxToStringPostOrder(t.getLeft()) +  
					auxToStringPostOrder(t.getRight()) + 
					t.getValue().toString() + '\n';
		}
	}
}
