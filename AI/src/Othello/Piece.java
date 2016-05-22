package Othello;

import java.awt.Graphics;
import java.awt.Image;
/**
 * Creates pieces that will be used in order to play the game
 * @author Andreas
 *
 */
public class Piece
{
	//Graphics
	private Image img;
	private int x, y;
	private int width, height;
	//Text coordinate
	private String cord;
	
	private String color;
	//Board coordinates
	private int row, colom;
	//Number of the piece
	private int index = -1;
	
	/**
	 * Creates a black or a white piece depending on the param color.
	 * @param x: Where the piece should be placed in the X line
	 * @param y: Where the piece should be placed in the Y line
	 * @param img: The picture of the piece
	 * @param cord: The text coordinate of the piece
	 * @param color: The color of the piece
	 */
	public Piece(int x, int y, Image img,String cord, String color)
	{
		this.img = img;
		this.x = x; this.y = y;
		
		this.cord = cord;
		this.color = color;
		//The height and width of the piece
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	/**
	 * Draws the piece
	 * @param g: The piece 
	 */
	public void draw(Graphics g)
	{
		g.drawImage(img, x, y, width, height, null);
	}
//------------------------- Get and set methods ---------------------------------------------
	/**
	 * Sets the text coordinate to the piece
	 * @param cord: Text based coordinate
	 */
	public void setCord(String cord)
	{
		this.cord = cord;
	}
	/**
	 * Gets the text coordinate of the piece
	 * @return: The text based coordinate
	 */
	public String getCord()
	{
		return this.cord;
	}
	/**
	 * Gets the color of the piece
	 * @return: color
	 */
	public String getColor()
	{
		return this.color;
	}
	 /**
     * Sets the color for the piece 
     * @param color: color
     */
	public void setColor(String color)
	{
		this.color = color;
	}
	/**
	 * Sets the X and Y coordinates for the piece
	 * @param x: X coordinate
	 * @param y: Y coordinate
	 */
	public void setXY(int x, int y)
	{
		this.x = x+50;
		this.y = y+50;
	}
	/**
	 * Gets the x graphic coordinate the piece
	 * @return: x
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * Gets the y graphic coordinate the piece
	 * @return: y
	 */
	public int getY()
	{
		return y;
	}
	/**
	 * Gets the row coordinate the piece
	 * @return: row
	 */
	public int getRow()
	{
		return row;
	}
	 /**
     * Sets the row coordinate for the piece 
     * @param r: row
     */
	public void setRow(int r)
	{
		this.row = r;
	}
	/**
	 * Gets the column coordinate the piece
	 * @return: column
	 */
	public int getColom()
	{
		return colom;
	}
	 /**
     * Sets the column coordinate for the piece 
     * @param c: column
     */
	public void setColom(int c)
	{
		this.colom = c;
	}
	/**
	 * Gets the index number of the piece which is the piece number
	 * @return: index
	 */
	public int getIndex()
	{
		return this.index;
	}
    /**
     * Sets the index number of the piece which is the piece number 
     * @param i: index
     */
	public void setIndex(int i) 
	{
		this.index= i;
	}

}
