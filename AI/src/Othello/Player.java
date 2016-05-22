package Othello;

import java.util.Random;

import javax.swing.ImageIcon;
/**
 * Creates a player that has gamepieces that he/she will play with on the gameboard
 */
public class Player
{
	private String name;
	private Piece pieces[] = new Piece[16];
	//Tells which pieces are in use or not in use
	private boolean index[] = new boolean[16];
	//Current pieces on the board
	private int piece_Count = 0;;
	private String color;
	/**
	 * A player has a name, a color that decides the color of the pieces and an array of pieces.
	 * @param name: Name of the player
	 * @param color: Color of the pieces
	 */
	public Player(String name, String color)
	{
		this.name = name;
		this.color = color;
		// If the color is white, create 16 white pieces
		if(color.equals("white"))
		{
			//Creates the players 16 white game pieces
			for(int i = 0; i < pieces.length; i++)
			{
				pieces[i] = new Piece(0,0, new ImageIcon("Images/White_Cat.png").getImage(),null,color );
				index[i] = false;
			}	
		}
		//Else if the color is black create 16 black pieces
		else if(color.equals("black"))
		{
			//Creates the players 16 black game pieces
			for(int i = 0; i < pieces.length; i++)
			{
				pieces[i] = new Piece(0,0, new ImageIcon("Images/Black_Cat.png").getImage(),null,color);
				index[i] = false;
			}
		}
		
	}
	/**
	 * Clones a players current position of pieces and give it to another player
	 * @param p: The player that will be copied from
	 */
	public void clone(Player p)
	{
		for (int i = 0; i < index.length; i++)
		{
			//if index is -1, it means that the piece is not ine use
			if (p.getPiece(i).getIndex() != -1)
			{
				this.pieces[i].setColor(p.getPiece(i).getColor());
				this.pieces[i].setCord(p.getPiece(i).getCord());
				this.pieces[i].setColom(p.getPiece(i).getColom());
				this.pieces[i].setRow(p.getPiece(i).getRow());
				this.pieces[i].setIndex(p.getPiece(i).getIndex());
				pieceInUse(true, i);
				piece_Count++;
			}
		}
	}
	/*
	 * Take a piece that is not in use and set it to in use
	 */
	public Piece take_piece()
	{
		for(int i = 0; i < index.length; i++)
		{
			//if the piece is not in use, then the piece can be used on the board.
			if(index[i] == false)
			{
				getPiece(i).setIndex(i);
				pieceInUse(true, i);
				piece_Count++;
				return getPiece(i);
			}
		}
		return null;
	}
	/**
	 * Sets a piece to in use or not in use
	 * @param b: true = in use, false = not in use
	 * @param i: Which piece
	 */
	public void pieceInUse(boolean b, int i)
	{
		index[i] = b;
		
		//if the piece is not in use, then the current pieces on the board will be lowered
		if(b == false)
		{
			pieces[i].setIndex(-1);
			piece_Count--;
		}
	}
	//------------------------------ Get and set methods-----------------------------------
	/**
	 * Get a piece
	 * @param i: Decide the index of which piece should be chosen
	 * @return: Returns the chosen piece 
	 */
	public Piece getPiece(int i)
	{
		return pieces[i];
	}
	/**
	 * Gets a piece color
	 * @param i: Decide the index of which piece should be chosen
	 * @return: color
	 */
	public String getPieceColor(int i)
	{
		return pieces[i].getColor();
	}
	/**
	 * Gets the number of pieces on the board
	 * @return: number of pieces
	 */
	public int getPieceCount()
	{
		return piece_Count;
	}
	/**
	 * Gets the player color
	 * @return: color
	 */
	public String getColor()
	{
		return this.color;
	}
}
