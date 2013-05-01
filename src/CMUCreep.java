import javax.swing.ImageIcon;


public class CMUCreep extends Creeps{
	public CMUCreep(int x, int y){
		super(x,y);
		health = 60000;
		dx = 50;
		div = 30;
		this.x = x;
		this.y = y;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("RiS_BlueBullet.png"));
		creepImage = ii.getImage();
	}
}
