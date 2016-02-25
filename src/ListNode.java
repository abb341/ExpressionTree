/**
 * 
 * A node in a linked list
 *
 */
public class ListNode
{
	
	private Object value;
	private ListNode next;
	
	// Constructor
	public ListNode(Object initValue, ListNode initNext)
	{
		value = initValue;
		next = initNext;
	}
	
	// Accessors
	/**
	 * accesses the value stored in the node
	 * @return
	 */
	public Object getValue()
	{
		return value;
	}
	
	/**
	 * accesses the next value
	 * @return
	 */
	public ListNode getNext()
	{
		return next;
	}
	
	// Mutators
	/**
	 * changes the value stored in the listNode
	 * @param theNewVal
	 */
	public void setValue(Object theNewVal)
	{
		value = theNewVal;
	}
	
	/**
	 * changes the next value stored in the listNode
	 * @param theNewNext
	 */
	public void setNext(ListNode theNewNext)
	{
		next = theNewNext;
	}

}
