package Othello;

import javax.swing.*;
import java.awt.*;
/**
 * Creates the gameboard that is made up by 16 blocks and 8 letters
 * @author Andreas
 *
 */
public class GameBoard extends JPanel
{
	//The Size of the panel/gameboard
	private int height = 1000, widht = 1000;
	private int h_start = 50, w_start = 50;
	//The letter blocks
	private Block letters[] = new Block[8];
	private String[] search_Way = {"Images/A.png","Images/B.png","Images/C.png","Images/D.png",
			                       "Images/one.png","Images/two.png","Images/tree.png","Images/four.png"};
	//Number of squares
	private int row = 4;
	private int colom = 4;
	//The board blocks
	public Block field[][] = new Block[colom][row];
	private String cordinates[] = {"A1","B1","C1","D1",
			               "A2","B2","C2","D2",
			               "A3","B3","C3","D3",
			               "A4","B4","C4","D4"};
	
	public char simpleField[][] = new char[4][4];
	/**
	 * Creates a gameboard
	 */
	public GameBoard()
	{    
		createField();
		setSize(widht,height);
		setLocation(w_start ,h_start);
	}
	/**
	 * Checks if the written command match any of the blocks coordinates
	 * @param r: the colom position of the block
	 * @param c: the row position of the block
	 * @return: Returns the coordinate of the block
	 */
	public String checkSpelling(int r, int c)
	{
		return field[r][c].getCord();
	}
	/**
	 * Check if a block is occupied or not
	 * @param r: the colom position of the block
	 * @param c: the row position of the block
	 * @return: Retruns true if the block is occupied
	 */
	public boolean checkPosition(int r, int c)
	{
		return field[r][c].checkOccupied();
	}
	
	public int cordToRow(String cord)
	{
		char search = cord.charAt(1);
		for(int r = 0; r < field[0].length; r++)
		{
			if(field[r][0].getCord().charAt(1) == search)
				return r;
		}
		return -1;
	}
	/**
	 * Convert the text cordinate till column coordinate
	 * @param c: Text coordinate
	 * @return: column coordinate 
	 */
	public int cordToColumn(String cord)
	{
		char search = cord.charAt(0);
		for(int c = 0; c < field[0].length; c++)
		{
			if(field[0][c].getCord().charAt(0) == search)
				return c;
		}
		return -1;
	}
	/**
	 * Checks the color of the piece on the block
	 * @param i: the colom position of the block
	 * @param j: the row position of the block
	 * @return
	 */
	public String checkColor(int r, int c)
	{
		return field[r][c].getPieceColor();
	}
	
	/**
	 * Creates the field with 16 playable blocks and 8 letters that show the coordinates of the blocks
	 */
	public void createField()
	{
		int x = 150 ;
		int y = 0;
		int count = 0;
		//Allows the block pattern to be like a chessboard
		int change = 1;
		int a = 0;
		boolean first = true;
		for(int e = 0; e < simpleField.length; e++)
		{
			for(int f = 0; f < simpleField[0].length; f++)
			{
				simpleField[e][f] = ('z');
			}
		}
		
		//Creates the letter blocks
		while(a < letters.length)
		{
			if(a < (letters.length/2))
			{
				letters[a] = new Block(x,y, new ImageIcon(search_Way[a]).getImage(),null );
				x += 200;
			}
			else
			{
				if(first)
				{
					y = 150;
					first = false;
				}
			    x = 0;
				letters[a] = new Block(x,y, new ImageIcon(search_Way[a]).getImage(),null );
				y += 200;
			}
			a++;
				
		}
		//Creates the playable blocks (the board)
		x = 100 ;
		y = 100;
		for(int r = 0; r < field.length; r++)
		{
			for(int c = 0; c < field[0].length; c++)
			{
				if(change == 1)
				{
					field[r][c] = new Block(x,y,new ImageIcon("Images/DarkGreen.png").getImage(), cordinates[count]);
					change = 2;
				}
				else
				{
					field[r][c] = new Block(x,y,new ImageIcon("Images/LightGreen.png").getImage(), cordinates[count]);
					change = 1;
				}
				
				x+= 200;
				count++;
			}
			if(change == 1)
				change = 2;
			else if(change == 2)
				change = 1;

			x = 100;
			y+= 200;
		}
	
	}
	/**
	 * Paints all the blocks
	 */
	public void paintComponent(Graphics g)
	{		
	    g.clearRect(0, 0, getWidth(), getHeight());
	    for(int h = 0; h < letters.length; h++)
	    {
	    	letters[h].draw(g);
	    }
	    for(int r = 0; r < field.length; r++)
	    {
	    	for(int c = 0; c < field[0].length; c++)
			{
	    		if(field[r][c].checkOccupied())
	    		{
					field[r][c].draw(g);
					field[r][c].getPiece().draw(g);
	    		}
	    		else
	    			field[r][c].draw(g);
			}
	    }
		repaint();
	}
	//------------------------------Get and set methods ------------------------------------------------
	/**
	 * Sets the standing piece on the block
	 * @param p: The piece that stands on the block
	 * @param r: the colom position of the block
	 * @param c: the row position of the block
	 */
	public void setPieceOnBlock(Piece p, int r, int c)
	{
		simpleField[r][c] = p.getColor().charAt(0);
		field[r][c].setOccupied(p);
		field[r][c].setColom(c);
		field[r][c].setRow(r);
	}
	/**
	 * Gets a piece on the block
	 * @param r: row coordinate
	 * @param c: column coordinate
	 * @return
	 */
	public Piece getPieceFromBlock(int r, int c)
	{
		return field[r][c].getPiece();
	}
	/**
	 * Gets the X coordinate of the block
	 * @param c: the column position of the block
	 * @param r: the row position of the block
	 * @return: Returns the X coordinate
	 */
	public int getBlockX(int r, int c)
	{
		return field[r][c].getX();
	}
	/**
	 * Gets the Y coordinate of the block
	 * @param c: the colom position of the block
	 * @param r: the row position of the block
	 * @return: Returns the Y coordinate
	 */
	public int getBlockY(int r, int c)
	{
		return field[r][c].getY();
	}
	/**
	 * Gets the text coordinate from the block
	 * @param r: row coordinate
	 * @param c: column coordinate
	 * @return
	 */
	public String getCordForBlock(int r, int c)
	{
		return field[r][c].getCord();
	}
}
