package Othello;
/**
 * This class contains a value and a coordinate that is linked with the value
 * @author Andreas
 *
 */
public class UtilityNode
{
	private int value;
	private String cord;
	/**
	 * Creates a utilitynode with a number based value and a board coordinate
	 * @param v
	 * @param c
	 */
	public UtilityNode(int v, String c)
	{
		this.value = v;
		this.cord = c;
	}
	/**
	 * Sets the value
	 * @param v: value
	 */
	public void setValue(int v)
	{
		this.value = v;
	}
	/**
	 * Gets the value
	 * @return: value
	 */
	public int getValue()
	{
		return this.value;
	}
	/**
	 * Sets the text coordinate
	 * @param c: coordinate
	 */
	public void setCord(String c)
	{
		this.cord = c;
	}
	/**
	 * Gets the text coordinate
	 * @return: cord
	 */
	public String getCord()
	{
		return this.cord;
	}
}
