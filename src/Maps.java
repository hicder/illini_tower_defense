import java.awt.*;

import javax.swing.ImageIcon;

public class Maps {

	private final int APPLET_WIDTH = 1053;
    private final int APPLET_HEIGHT = 527;
    private final int BOX_SIZE = 50;
    public static boolean[][] map = new boolean[19][11];
    
    
    
    public static int xTarget;
    public static int yTarget;
    
    public Maps(){
    	 for(int i=0; i<19; i++)
 	    	for(int j=0; j<11; j++)
 	    		map[i][j]=false;

 	    for(int i=0; i<7; i++)
 	    	for(int j=3; j<4; j++)
 	    		map[i][j]=true;
 	    
 	    for(int i=6; i<7; i++)
 	    	for(int j=3; j<8; j++)
 	    		map[i][j]=true;
 	    
 	    for(int i=6; i<10; i++)
 	    	for(int j=7; j<8; j++)
 	    		map[i][j]=true;
 	    
 	    for(int i=9; i<10; i++)
 	    	for(int j=5; j<8; j++)
 	    		map[i][j]=true;
 	    
 	    for(int i=9; i<14; i++)
 	    	for(int j=5; j<6; j++)
 	    		map[i][j]=true;
 	    
 	    for(int i=13; i<14; i++)
 	    	for(int j=1; j<5; j++)
 	    		map[i][j]=true;
 	    
 	    for(int i=13; i<17; i++)
 	    	for(int j=1; j<2; j++)
 	    		map[i][j]=true;
 	    
 	    for(int i=17; i<18; i++)
 	    	for(int j=1; j<9; j++)
 	    		map[i][j]=true;
 	    
 	    for(int i=17; i<19; i++)
 	    	for(int j=8; j<9; j++)
 	    		map[i][j]=true;
    }
    public void mapone(Graphics g){
    	/*ImageIcon ii = new ImageIcon(this.getClass().getResource("dirtTile.png"));
		Image dirt = ii.getImage();
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[0].length; j++){
				if(map[i][j]==true)
				g.drawImage(dirt, (i*BOX_SIZE)-1, (j*BOX_SIZE)-1, BOX_SIZE+2, BOX_SIZE+2, null);
			}
		}*/
		
    	g.setColor(Color.BLUE);
		g.fillRect((BOX_SIZE*0)+2, (BOX_SIZE*03)+2, (BOX_SIZE*7)-2, (BOX_SIZE*1)-2);
		g.fillRect((BOX_SIZE*6)+2, (BOX_SIZE*03)+2, (BOX_SIZE*1)-2, (BOX_SIZE*5)-2);
		g.fillRect((BOX_SIZE*6)+2, (BOX_SIZE*07)+2, (BOX_SIZE*4)-2, (BOX_SIZE*1)-2);
		g.fillRect((BOX_SIZE*9)+2, (BOX_SIZE*05)+2, (BOX_SIZE*1)-2, (BOX_SIZE*3)-2);
		g.fillRect((BOX_SIZE*9)+2, (BOX_SIZE*05)+2, (BOX_SIZE*5)-2, (BOX_SIZE*1)-2);
		g.fillRect((BOX_SIZE*13)+2, (BOX_SIZE*01)+2, (BOX_SIZE*1)-2, (BOX_SIZE*5)-2);
		g.fillRect((BOX_SIZE*13)+2, (BOX_SIZE*01)+2, (BOX_SIZE*5)-2, (BOX_SIZE*1)-2);
		g.fillRect((BOX_SIZE*17)+2, (BOX_SIZE*01)+2, (BOX_SIZE*1)-2, (BOX_SIZE*8)-2);
		g.fillRect((BOX_SIZE*17)+2, (BOX_SIZE*8)+2, (BOX_SIZE*2)-2, (BOX_SIZE*1)-2);
		
		
	}
}
