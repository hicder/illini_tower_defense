import java.applet.Applet;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Main extends Applet implements MouseListener, Runnable
{

	private Image offScreenImage;
	private Dimension offScreenSize;
	private Graphics offScreenGraphics;





	private static final long serialVersionUID = 1L;
	private final int APPLET_WIDTH = 1053;
	private final int APPLET_HEIGHT = 503;
	private final int BOX_SIZE = 50;
	private final int DELAY = 10;
	private Thread animator;
	public static ArrayList<Creeps> creepsList;
	public static ArrayList<Towers> towerlist;
	public static ArrayList<Long> enterTime;
	public int money=1000;
	public int health=100;
	public int wave=1;
	public static boolean[][] towers = new boolean[19][11];
	//public static boolean[][] creepsList.get(i).ownMap = new boolean[19][11];
	public Towers[][] towersList = new Towers[19][11];
	Towers tempTower = null;
	Towers displayTower=null;
	int displayParam=0;
	boolean upgradeButton=false;

	public void init(){
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setBackground(Color.BLACK);
		addMouseListener(this);
		enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK);
		creepsList = new ArrayList<Creeps>();
		towerlist = new ArrayList<Towers>();
		Creeps cmu = new CMUCreep(0, 3*BOX_SIZE+5);
		Creeps mic = new MichiganCreep(0, 3*BOX_SIZE+5);
		Maps temp = new Maps();
		creepsList.add(cmu);
		creepsList.add(mic);
		animator = new Thread(this);
		animator.start();

		for(int i=0; i<19; i++)
			for(int j=0; j<11; j++)
				towers[i][j]=Maps.map[i][j];


	}

	int mouseX;
	int mouseY;
	int highlightX;
	int highlightY;


	public void mousePressed(MouseEvent e){
	}

	public void mouseReleased(MouseEvent e){
	}

	public void mouseEntered(MouseEvent e){
	}

	public void mouseExited(MouseEvent e){
	}

	public void mouseClicked(MouseEvent e){
		mouseX = (int) e.getX()/BOX_SIZE;
		mouseY = (int) e.getY()/BOX_SIZE;
		if(mouseX==19 && mouseY==0){
			tempTower= new AltgeldTower();
			displayTower= new AltgeldTower();
			displayParam=1;
			highlightX=mouseX;
			highlightY=mouseY;
		}
		if(mouseX==20 && mouseY==0){
			tempTower= new DCLTower();
			displayTower= new DCLTower();
			displayParam=1;
			highlightX=mouseX;
			highlightY=mouseY;
		}
		if(mouseX==19 && mouseY==1){
			tempTower= new ISRTower();
			displayTower= new ISRTower();
			displayParam=1;
			highlightX=mouseX;
			highlightY=mouseY;

		}
		if(mouseX==20 && mouseY==1){
			tempTower= new LoomisTower();
			displayTower= new LoomisTower();
			displayParam=1;
			highlightX=mouseX;
			highlightY=mouseY;
		}
		if(mouseX==19 && mouseY==2){
			tempTower= new NoyesTower();
			displayTower= new NoyesTower();
			displayParam=1;
			highlightX=mouseX;
			highlightY=mouseY;
		}
		if(mouseX==20 && mouseY==2){
			tempTower= new SiebelTower();
			displayTower= new SiebelTower();
			displayParam=1;
			highlightX=mouseX;
			highlightY=mouseY;
		}
		if(mouseX==19 && mouseY==3){
			tempTower= new UGLTower();
			displayTower= new UGLTower();
			displayParam=1;
			highlightX=mouseX;
			highlightY=mouseY;
		}
		if(mouseX==20 && mouseY==3){
			tempTower= new UnionTower();
			displayTower= new UnionTower();
			displayParam=1;
			highlightX=mouseX;
			highlightY=mouseY;
		}
		if(mouseX<19 && tempTower!=null && towers[mouseX][mouseY]==false){
			towersList[mouseX][mouseY]=tempTower;
			towers[mouseX][mouseY]=true;
			tempTower.x = mouseX;
			tempTower.y = mouseY;
			towerlist.add(tempTower);
			tempTower=null;
			displayParam=0;
		}
		if(mouseX<19 && towers[mouseX][mouseY]==true && Maps.map[mouseX][mouseY]==false){
			displayTower= towersList[mouseX][mouseY];
			displayParam=2;
			highlightX=mouseX;
			highlightY=mouseY;
			tempTower=null;
		}

		if((mouseX>=19 && mouseY>=4 && mouseX<21 && mouseY<12) && displayTower!=null && (upgradeButton==false||displayParam==1)){
			displayTower=null;
			tempTower=null;
			displayParam=0;
		}
		if(mouseX<19){
			if((towers[mouseX][mouseY]==false || Maps.map[mouseX][mouseY]==true) && displayTower!=null){
				displayTower=null;
				tempTower=null;
				displayParam=0;
			}}
		repaint();
	}

	public void processMouseMotionEvent(MouseEvent e) {
		mouseX = (int) e.getX()/BOX_SIZE;
		mouseY = (int) e.getY()/BOX_SIZE;
		int mouseXX = (int) e.getX();
		int mouseYY = (int) e.getY();
		if(mouseXX>=((BOX_SIZE*19)+11) && mouseYY>=((BOX_SIZE*7)-10) &&
				mouseXX<=((BOX_SIZE*20)+35) && mouseYY<=((BOX_SIZE*8)-15)){
			upgradeButton=true;
		}
		else upgradeButton=false;
	}

	public synchronized void paint(Graphics g){
		Paint p = new Paint();
		p.drawBackground(g); // draw background + grid

		{//drawTowers
			for(int i = 0; i < towerlist.size(); i++){
				g.drawImage(towerlist.get(i).towerImage, towerlist.get(i).x*BOX_SIZE +6, towerlist.get(i).y* BOX_SIZE +6, BOX_SIZE-10, BOX_SIZE - 10, null);
			}

		}

		{//selected tower highlight
			if(displayTower!=null){
				int shift=0;
				if(highlightX>=19) shift=2;
				g.setColor(Color.WHITE);
				for(int i=-1; i<2+(shift/2); i++)
					for(int j=-1; j<2+(shift/2); j++)
						g.drawRect(highlightX * BOX_SIZE +(i+shift), highlightY * BOX_SIZE +(j), BOX_SIZE, BOX_SIZE);
				if(highlightX<19){
					int newRange = (int)displayTower.getRange()+(((BOX_SIZE)/2)*displayTower.getLevel()+1);
					if(((int)displayTower.getRange()+(int)((highlightX*BOX_SIZE)+25))>(BOX_SIZE*19)||
							((int)newRange+(int)((highlightX*BOX_SIZE)+25))>(BOX_SIZE*19)){
						int startAngle;
						int shortX;
						int newX;
						double cosParam;
						if(upgradeButton==true){
							shortX = ((int)newRange+(int)(highlightX*BOX_SIZE)+25)-(BOX_SIZE*19);
							newX = ((int) newRange-shortX);
							cosParam = ((double) newX/newRange);
							startAngle = (int) Math.toDegrees(Math.acos(cosParam))+1;
							g.drawArc((int)(((highlightX*BOX_SIZE)+25)-newRange), (int)(((highlightY*BOX_SIZE)+25)-newRange), 
									(int) (2*newRange), (int) (2*newRange), startAngle, 360-2*startAngle);
						}
						else{
							shortX = ((int)displayTower.getRange()+(int)(highlightX*BOX_SIZE)+25)-(BOX_SIZE*19);
							newX = ((int) displayTower.getRange()-shortX);
							cosParam = ((double) newX/displayTower.getRange());
							startAngle = (int) Math.toDegrees(Math.acos(cosParam))+1;
							g.drawArc((int)(((highlightX*BOX_SIZE)+25)-displayTower.getRange()), (int)(((highlightY*BOX_SIZE)+25)-displayTower.getRange()), 
									(int) (2*displayTower.getRange()), (int) (2*displayTower.getRange()), startAngle, 360-2*startAngle);
						}
					}
					else{
						if(upgradeButton==true){
							g.drawOval((int)(((highlightX*BOX_SIZE)+25)-newRange), (int)(((highlightY*BOX_SIZE)+25)-newRange), 
									(int) (2*newRange), (int) (2*newRange));
						}	
						else
							g.drawOval((int)(((highlightX*BOX_SIZE)+25)-displayTower.getRange()), (int)(((highlightY*BOX_SIZE)+25)-displayTower.getRange()), 
									(int) (2*displayTower.getRange()), (int) (2*displayTower.getRange()));
					}
				}
			}
		}
		{//tracing
			if(mouseX<19 && mouseY<10)
			{
				if(towers[mouseX][mouseY]==true)
					g.setColor(Color.RED);
				else g.setColor(Color.GREEN);
				for(int i=-1; i<2; i++)
					for(int j=-1; j<2; j++)
						g.drawRect(mouseX * BOX_SIZE +(i), mouseY * BOX_SIZE +(j), BOX_SIZE, BOX_SIZE);
			}
			if(mouseX>=19 && mouseX<21 && mouseY<=3)
			{
				g.setColor(Color.WHITE);
				for(int i=0; i<5; i++)
					for(int j=-1; j<3; j++)
						g.drawRect(mouseX * BOX_SIZE +(i), mouseY * BOX_SIZE +(j), BOX_SIZE, BOX_SIZE);
			}
		}

		{//display
			p.display(g, displayTower, displayParam, upgradeButton);
		}

		//display the creep
		for(int i= 0; i < creepsList.size(); i++){
			if(((creepsList.get(i).getX() + creepsList.get(i).dx)/BOX_SIZE < creepsList.get(i).ownMap.length) && ((creepsList.get(i).getY()+ creepsList.get(i).dx)/BOX_SIZE < creepsList.get(i).ownMap[0].length) && creepsList.get(i).isAlive()){
				g.drawImage(creepsList.get(i).creepImage,creepsList.get(i).x, creepsList.get(i).y,BOX_SIZE - 10, BOX_SIZE - 10,null);}
		}
	}

	public void drawCreeps(Graphics g){

	}

	public void cycle(){
		for(int i = 0; i < creepsList.size(); i++){
			//System.out.println("Number: "+i);
			if(creepsList.get(i).isAlive() && (creepsList.get(i).getX()+ creepsList.get(i).dx)/BOX_SIZE < creepsList.get(i).ownMap.length && (creepsList.get(i).getY()+ creepsList.get(i).dx)/BOX_SIZE < creepsList.get(i).ownMap[0].length){
				int cx = creepsList.get(i).getX();
				int cdx = creepsList.get(i).dx;
				int cy = creepsList.get(i).getY(); 
				if((cx+cdx)/BOX_SIZE >= creepsList.get(i).ownMap.length || (cy + cdx)/BOX_SIZE >= creepsList.get(i).ownMap[0].length) creepsList.get(i).health = -1;
				if(creepsList.get(i).ownMap[(cx+cdx)/BOX_SIZE][(cy)/BOX_SIZE] && cy/BOX_SIZE == (cy+40)/BOX_SIZE) {
					creepsList.get(i).x += cdx/creepsList.get(i).div;
				} else if(creepsList.get(i).ownMap[cx/BOX_SIZE][(cy + cdx)/BOX_SIZE]) {
					creepsList.get(i).y += cdx/creepsList.get(i).div;
				} else if(creepsList.get(i).ownMap[(cx - cdx)/BOX_SIZE][(cy)/BOX_SIZE]) {
					creepsList.get(i).x -=cdx/creepsList.get(i).div;
				} 
				else creepsList.get(i).y -= cdx/creepsList.get(i).div;
				creepsList.get(i).ownMap[(cx)/BOX_SIZE][cy/BOX_SIZE] = false;
			}
		}

		for(int i = 0; i < towerlist.size(); i++){
			for(int j = 0; j < towerlist.get(i).fireRate; j++){
				towerlist.get(i).attack(creepsList);
			}
		}

	}

	public synchronized void  update(Graphics g){
		Dimension d = size();
		if((offScreenImage == null) ||(d.width !=offScreenSize.width)||
				(d.height !=offScreenSize.height))
		{
			offScreenImage = createImage(d.width,d.height);
			offScreenSize = d;
			offScreenGraphics = offScreenImage.getGraphics();
		}
		offScreenGraphics.clearRect(0,0,d.width,
				d.height);
		paint(offScreenGraphics);
		g.drawImage(offScreenImage,0,0,null);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long beforeTime, timeDiff, sleep, startingTime;
		beforeTime = System.currentTimeMillis();
		startingTime = System.currentTimeMillis();

		while(true){
			repaint();
			cycle();

			//the following code is for smooth animation
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;

			if(sleep < 0) sleep = 2;

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			beforeTime = System.currentTimeMillis();
		}
	}


}

