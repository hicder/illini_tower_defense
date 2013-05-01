import javax.swing.ImageIcon;


public class StanfordCreep extends Creeps{
	public StanfordCreep(int x, int y){
		super(x,y);
		health = 2000000;
		dx = 50;
		div = 25;
		this.x = x;
		this.y = y;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("RiS_BlueBullet.png"));
		creepImage = ii.getImage();
	}


}
