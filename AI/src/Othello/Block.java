package Othello;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * This class creates blocks that represents a piece of the board.
 * A block has a position which the game pieces will be placed on
 * @author Andreas
 *
 */
public class Block
{
	private Image img;
	private int x, y;
	private int field;
	private int width, height;
	private String cord;
	private int row, colom;
	private Piece piece = null;
	private boolean occupied = false;
	
	/**
	 * Creates a Block object
	 * @param x: The x position on the screen
	 * @param y: The y position on the screen
	 * @param img: The picture that will show the block
	 * @param cord: The text based coordinate for the block
	 */
	public Block(int x, int y, Image img,String cord)
	{
        this.img = img;
		this.x = x;
		this.y = y;
		this.cord = cord;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		
	}
	/**
	 * Draws the block
	 * @param g
	 */
	public void draw(Graphics g)
	{
		g.drawImage(img, x, y, width, height, null);
	}

	/**
	 * Set the block to occupied by attaching a piece
	 * @param p: The piece
	 */
	public void setOccupied(Piece p)
	{
		piece = null;
		piece = p;
		occupied = true;
	}
	/**
	 * Checks if the block is occupied
	 * @return
	 */
	public boolean checkOccupied()
	{
		return occupied;				
	}
	/**
	 * Returns the piece standing on the block
	 * @return: piece
	 */
	public Piece getPiece()
	{
		return this.piece;
	}
	/**
	 * Returns the color of the piece standing on the block
	 * @return: colort
	 */
	public String getPieceColor()
	{
		return this.piece.getColor();
	}
//------------------------------------------ Geter and setters ------------------------------------------------------	
	/**
	 * Gives the block a text based coordinate
	 * @param cord
	 */
	public void setCord(String cord)
	{
		this.cord = cord;
	}
	/**
	 * Returns the block a text based coordinate
	 * @return: cord
	 */
	public String getCord()
	{
		return this.cord;
	}
	/**
	 * Returns the Blocks X position
	 * @return: x
	 */
	public int getX()
	{
		return this.x;
	}
	/**
	 * Returns the Blocks X position
	 * @return
	 */
	public int getY()
	{
		return this.y;
	}
	/**
	 * Returns the row coordinate for the block
	 * @return
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * Sets the row coordinate for the block
	 * @param r: row
	 */
	public void setRow(int r)
	{
		this.row = r;
	}
	/**
	 * Returns the column coordinate for the block
	 * @return column
	 */
	public int getColom()
	{
		return colom;
	}
	/**
	 * Sets the column coordinate for the block
	 * @param c: column
	 */
	public void setColom(int c)
	{
		this.colom = c;
	}

}
