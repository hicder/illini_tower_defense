
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;

public class Paint{
	private final int APPLET_WIDTH = 1053;
    private final int APPLET_HEIGHT = 503;
    private final int BOX_SIZE = 50;
    private Maps m = new Maps();
    
    public Paint(){}
    
    public void drawBackground(Graphics g){
    	//ImageIcon ii = new ImageIcon(this.getClass().getResource("grassTile.png"));
    	//Image grass = ii.getImage();
		//g.drawImage(grass, 0, 0, BOX_SIZE*19, BOX_SIZE*11, null);
    	//grid(g);
    	m.mapone(g);
    	sidePanel(g); 
    	startButton(g);
    	money(g);
    }
    

	public void grid(Graphics g){
    	g.setColor(Color.LIGHT_GRAY);
		for(int i=0; i<20; i++)
	    g.drawRect((BOX_SIZE*i), 0, 1, APPLET_HEIGHT);
	    for(int i=0; i<11; i++)
	    g.drawRect(0, (BOX_SIZE*i), APPLET_WIDTH-100, 1);
	}
	
	public void sidePanel(Graphics g){
    	g.setColor(Color.RED);
    	g.fillRect((BOX_SIZE*20)+2, 0, 3, (BOX_SIZE*4));
    	g.fillRect((BOX_SIZE*19), 0, 4, APPLET_HEIGHT);
    	for(int i=0; i<5;){
    	g.drawRect((BOX_SIZE*19), (BOX_SIZE*i), (BOX_SIZE*2), 1);
    	i++;
    	}
    	
    	g.drawImage(new AltgeldTower().towerImage, 19*BOX_SIZE+7, 0*BOX_SIZE+7, BOX_SIZE -10, BOX_SIZE-10, null);
    	g.drawImage(new DCLTower().towerImage, 20*BOX_SIZE+7, 0*BOX_SIZE+7, BOX_SIZE -10, BOX_SIZE-10, null);
    	g.drawImage(new ISRTower().towerImage, 19*BOX_SIZE+7, 1*BOX_SIZE+7, BOX_SIZE -10, BOX_SIZE-10, null);
    	g.drawImage(new LoomisTower().towerImage, 20*BOX_SIZE+7, 1*BOX_SIZE+7, BOX_SIZE -10, BOX_SIZE-10, null);
    	g.drawImage(new NoyesTower().towerImage, 19*BOX_SIZE+7, 2*BOX_SIZE+7, BOX_SIZE -10, BOX_SIZE-10, null);
    	g.drawImage(new SiebelTower().towerImage, 20*BOX_SIZE+7, 2*BOX_SIZE+7, BOX_SIZE -10, BOX_SIZE-10, null);
    	g.drawImage(new UGLTower().towerImage, 19*BOX_SIZE+7, 3*BOX_SIZE+7, BOX_SIZE -10, BOX_SIZE-10, null);
    	g.drawImage(new UnionTower().towerImage, 20*BOX_SIZE+7, 3*BOX_SIZE+7, BOX_SIZE -10, BOX_SIZE-10, null);

	}
	
	public void display(Graphics g, Towers t, int i, boolean up){
		//i=0 = no tower selected, i=1 = side panel, i=2 = in map
		int shift=0;
		Main m = new Main();
        int font_size = 16;
        Font heading = new Font("Dialog", Font.BOLD, font_size+4);
        Font subhead = new Font("Dialog", Font.BOLD, font_size);
        Font subtext = new Font("Dialog", Font.BOLD, font_size-4);
        
		if(i==0){
			if(m.wave<10) shift=7;
			else shift=0;
			g.setFont(subhead);
			g.setColor(Color.WHITE);
			g.drawString("Current", (BOX_SIZE*19)+18, (BOX_SIZE*4)+20);
			g.drawString("Wave", (BOX_SIZE*19)+28, (BOX_SIZE*4)+38);
			g.drawString(""+m.wave, (BOX_SIZE*19)+41+shift, (BOX_SIZE*5)+6);
	        Font font1 = new Font("Dialog", Font.BOLD, 18);
	        g.setFont(font1);
	        if(m.health<100 && m.health>9) shift=8;
			else if (m.health<10) shift=16;
			else shift=0;
			g.setColor(Color.RED);
	        g.drawString("HEALTH", (BOX_SIZE*19)+14, (BOX_SIZE*7)+23);
			g.setColor(Color.WHITE);
	        g.drawString(""+m.health, (BOX_SIZE*19)+35+shift, (BOX_SIZE*7)+43);
			
		}
		if(i==1){
	        g.setFont(heading);
	        g.setColor(Color.WHITE);
	        if(t.getName().length()<5) shift=20;
	        else if(t.getName().length()==5) shift=6;
	        else if(t.getName().equals("Siebel")) shift=5;
	        else shift=0;
			g.drawString(t.getName(), (BOX_SIZE*19)+13+shift, (BOX_SIZE*4)+30);
			g.setColor(Color.RED);
			g.setFont(subhead);
			g.drawString("Tier: "+t.getLevel(), (BOX_SIZE*19)+25, (BOX_SIZE*5));
			g.setColor(Color.WHITE);
			g.setFont(subtext);
			g.drawString("Damage: "+t.getDamage(), (BOX_SIZE*19)+8, (BOX_SIZE*6)-10);
			g.drawString("Fire Rate: "+t.getFireRate(), (BOX_SIZE*19)+8, (BOX_SIZE*6)+10);
			g.drawString("Range: "+(int)t.getRange(), (BOX_SIZE*19)+8, (BOX_SIZE*6)+30);
			g.drawString("Cost: "+t.getCost(), (BOX_SIZE*19)+8, (BOX_SIZE*7));
		}
		if(i==2){
			int upBinary=0;
			g.setFont(heading);
		    g.setColor(Color.WHITE);
		    if(t.getName().length()<5) shift=20;
		    else if(t.getName().length()==5) shift=6;
		    else if(t.getName().equals("Siebel")) shift=5;
		    else shift=0;
			g.drawString(t.getName(), (BOX_SIZE*19)+13+shift, (BOX_SIZE*4)+30);
			g.setColor(Color.RED);
			g.setFont(subhead);
			g.drawString("Tier: ", (BOX_SIZE*19)+25, (BOX_SIZE*5));
			g.drawString(""+t.getLevel(), (BOX_SIZE*19)+71, (BOX_SIZE*5));
			g.setColor(Color.WHITE);
			g.setFont(subtext);
			g.drawString("Damage: ", (BOX_SIZE*19)+8, (BOX_SIZE*6)-10);
			g.drawString("Fire Rate: ", (BOX_SIZE*19)+8, (BOX_SIZE*6)+10);
			g.drawString("Range: ", (BOX_SIZE*19)+8, (BOX_SIZE*6)+30);
			g.drawString("Cost: "+(t.getCost()*((int) Math.pow(2, t.getLevel()))), (BOX_SIZE*19)+8, (BOX_SIZE*8)-5);
			if (up==true) {
				g.setColor(Color.GREEN);
				upBinary=1;
			}
			else {
				g.setColor(Color.WHITE);
				upBinary=0;
			}
			g.drawString(""+(t.getDamage()+((t.getDamage()*t.getLevel())*upBinary)), (BOX_SIZE*19)+75, (BOX_SIZE*6)-10);
			g.drawString(""+(t.getFireRate()+((t.getLevel())*upBinary)), (BOX_SIZE*19)+81, (BOX_SIZE*6)+10);
			g.drawString(""+((int)t.getRange()+((((BOX_SIZE)/2)*t.getLevel())*upBinary)), (BOX_SIZE*19)+62, (BOX_SIZE*6)+30);
			upgradeButton(g);
			
		}
		
		
	}
	
	public void money(Graphics g){
		Main m = new Main();
        int font_size = 18;
        int x = (BOX_SIZE*19)+16;
        int y = (BOX_SIZE*8)+20;
        Font font1 = new Font("Dialog", Font.BOLD, font_size);
        int shift=0;
        if(m.money<10000 && m.money>999) shift=7;
        else if(m.money<1000 && m.money>99) shift=14;
        else if(m.money<100 && m.money>9) shift=21;
		else if (m.money<10) shift=29;
		else shift=0;
        g.setFont(font1);
		g.setColor(Color.GREEN);
        g.drawString("MONEY", x, y);
		g.setColor(Color.WHITE);
        g.drawString(""+m.money, x+4+shift, y+23);
	}
	
	public void startButton(Graphics g){
		Graphics2D graphics = (Graphics2D) g;
		RoundRectangle2D startButton = new RoundRectangle2D.Float((BOX_SIZE*19)+10, (BOX_SIZE*9)+10, (BOX_SIZE)+35, (BOX_SIZE)-15, 10, 10);
		g.setColor(Color.YELLOW);
		graphics.fill(startButton);
		g.setColor(Color.BLACK);
        int font_size = 24;
        int x = (BOX_SIZE*19)+18;
        int y = (BOX_SIZE*9)+37;
        Font font1 = new Font("Dialog", Font.BOLD, font_size);
        g.setFont(font1);
        g.drawString("Start", x, y);
	}
	
	public void upgradeButton(Graphics g){
		Graphics2D graphics = (Graphics2D) g;
		RoundRectangle2D upgradeButton = new RoundRectangle2D.Float((BOX_SIZE*19)+11, (BOX_SIZE*7)-10, (BOX_SIZE)+35, (BOX_SIZE)-15, 10, 10);
		g.setColor(Color.LIGHT_GRAY);
		graphics.fill(upgradeButton);
		g.setColor(Color.BLACK);
        int font_size = 16;
        int x = (BOX_SIZE*19)+12;
        int y = (BOX_SIZE*7)+15;
        Font font1 = new Font("Dialog", Font.BOLD, font_size);
        g.setFont(font1);
        g.drawString("UPGRADE", x, y);
	}
	
}
