import java.util.*;
import java.io.*;
import java.awt.Point;

/**
* Map class
*/
public class Map {
	private char [][] map;
	private boolean [][] revealed;

  /**
  * Sets up the map for the game
  */
	public Map()	{
		map = new char[5][5];
		revealed = new boolean[5][5];	
	}
	
  /**
  * Sets up text file for map
  * @param mapNum For Area1.txt/Area2.txt/Area3.txt selection
  */
  public void loadMap(int mapNum)	{
		try {
			String mapSelect = ("Area");
			// Switch statement to determine the map chosen
			switch(mapNum)	{
				case 1: mapSelect += ("1.txt");
						break;
				case 2: mapSelect += ("2.txt");
						break;
				case 3: mapSelect += ("3.txt");
						break;
				default: 
						break;
			}
			Scanner m = new Scanner(new FileReader(mapSelect)); 
			while(m.hasNextLine()) {
		         for (int i = 0; i < map.length; i++) {
		            String[] column = m.nextLine().trim().split(" ");
		            for (int j = 0; j < column.length; j++) {
		               map[i][j] = column[j].charAt(0);
		            }
		         }
		      }
			revealed = new boolean[5][5];
		} catch (FileNotFoundException err)	{
			System.out.println("Error. File Reading Error or File not found.");
			err.printStackTrace();
		}
	}
	
  /**
  *character location return to map
  *@param p is point with 
  *the coordinate on map of x, y
  *@return this.map for sepcific location
  */
  public char getCharAtLoc(Point p){
    if((p.x < 0) || (4 < p.x) || (p.y < 0) || (4 < p.y)){
          return 'p';
        }
    return this.map[p.x][p.y];
  }
  /**	
  *displays map as string 
  *@param p for location
  *@return String space for map display
  */ 
  public String mapToString(Point p)	{
		String space = "";	
		for (int i = 0; i < this.map.length; i++)
		{
			for (int j = 0; j < this.map.length; j++)
			{
				if (p.x == i && p.y == j) {
					space += "* "; 
					continue;
				}
				else if (revealed[i][j] == true) {
					space += map[i][j] + " "; 
					continue;
				}				
				else{
					space += "x "; 
					continue;
				}
			}			
			space += "\n";
		}		
		return space;
	}
  /**	
  * Finds s on the map string as set
  * as the starting point = sP
  * @retun Point sP for trainer's location with starting point
  */
	public Point findStart()	{
		Point sP = new Point();
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				if (map[i][j] == 's'){
          sP.setLocation(i, j);
        }
			}
		}
		return sP;
	}
	/**
  *checks character has been to previous point 
  *@param p to show map location
  */
	public void reveal(Point p)	{
			revealed[p.x][p.y] = true;
	}
  /**
  *remove character at location 
  *@param p for removing character location
  */
  public void removeCharAtLoc(Point p){
    char loc = map[p.x][p.y];
    if (loc == 'i'){
      map[p.x][p.y] = 'n';
    }
    else if(loc == 'p'){
      map[p.x][p.y] = 'n';
    }
    else if(loc == 'w'){
      map[p.x][p.y] = 'n';
    }
  }
}
