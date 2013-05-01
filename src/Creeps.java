import java.awt.Image;


public class Creeps implements Comparable<Creeps>{
	public int dx;
	public int x;
	public int health;
	public int y;
	public boolean alive;
	public int div;
	Image creepImage;
	public boolean[][] ownMap;

	public void takeDamage(int damage){
		health = health - damage;
	}

	public int getX(){
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void goSouth(){
		this.y = this.y + dx;
	}

	public void goEast(){
		this.x = this.x + dx;
	}

	public void goNorth(){
		this.y = this.y - dx;
	}
	//moves the creep one tick


	// Checks if creep is alive
	public boolean isAlive(){
		alive = (health > 0);
		return alive;
	}

	public double getDistancefromTarget(){
		boolean blocked[][] = copyArray(Maps.map);
		double disFromTarget = shortestPath(this.x, this.y, Maps.xTarget, Maps.yTarget, blocked);
		return disFromTarget;
	}

	public double shortestPath(int x, int y, int tX, int tY, boolean blocked[][]){
		if(x >= blocked.length || x < 0 || y < 0 || y >= blocked[0].length) return Double.MAX_VALUE;
		if(!blocked[x][y] ) return Double.MAX_VALUE;
		if(x == tX && y == tY) return 0;
		String result = null;
		double disFromTarget = 0;
		blocked[x][y] = false;
		double[] paths = {shortestPath(x, y + 1, tX, tY, blocked), shortestPath(x, y - 1, tX, tY, blocked), shortestPath(x+1, y , tX, tY, blocked), shortestPath(x-1, y , tX, tY, blocked)};
		blocked[x][y] = true;
		disFromTarget = getMin(paths[0], paths[1], paths[2], paths[3]) + 1;
		return disFromTarget;
		

		// TODO: Use findShortestString on paths
		// TODO: Return correct string with Compass direction prepended (or null)
		
	}

	public double getMin(double a, double b, double c, double d){
		return Math.min(Math.min(a, b), Math.min(c, d));
	}

	

	public int compareTo(Creeps another){
		int distance =(int) (this.getDistancefromTarget() - another.getDistancefromTarget());
		return distance;
	}

	
	

	/** Returns the length of the string or Integer.MAX_VALUE
	 * if the string is null.
	 * @param s
	 * @return
	 */
	public static boolean[][] copyArray(boolean another[][]){
		int w = another.length; int h = another[0].length;
		boolean result[][] = new boolean[w][h];
		for(int i = 0; i< w; i++){
			for(int j = 0; j < h; j++){
				result[i][j] = another[i][j];
			}
		}
		return result;
	}
	public Creeps(int x, int y){
		this.x = x;
		this.y = y;
		Maps temp = new Maps();
		ownMap = copyArray(Maps.map);
	}
}


