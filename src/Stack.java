/**
 * A stack structure using a Linked List
 * @author abrown
 *
 */
public class Stack
{
private ListNode stackTop;
	
	/* Constructor.  The parameter size is received but ignored. */
	public Stack(int size)
	{
		stackTop = null;
	}
	
	/* isEmpty - return true if empty, false otherwise. */
	public boolean isEmpty()
	{
		return stackTop == null;
	}
	
	/* isFull - never true for a linked list! */
	public boolean isFull()
	{
		return false;
	}
	
	/* push - Push s onto the stack.  Should never fail. */
	public void push(Object s)
	{
		stackTop = new ListNode(s, stackTop);
	}
	
	/* pop - If there is anything on the stack, pop the top and return it. */
	public Object pop()
	{
		if (!isEmpty())
		{
			Object temp = stackTop.getValue();
			stackTop = stackTop.getNext();
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	/* toString - Convert the stack to a string and return it. */
	public String toString()
	{
		String stackAsString = "";
		ListNode current = stackTop;
		int index = 0;
		while(current != null)
		{
			stackAsString = stackAsString + index + " : " + current.getValue() + '\n';
			current = current.getNext();
			index++;
		}
		return stackAsString;
	}
}
