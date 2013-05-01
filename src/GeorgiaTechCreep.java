import javax.swing.ImageIcon;


public class GeorgiaTechCreep extends Creeps{
	public GeorgiaTechCreep(int x, int y){
		super(x,y);
		health = 600;
		dx = 50;
		div = 40;
		this.x = x;
		this.y = y;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("RiS_BlueBullet.png"));
		creepImage = ii.getImage();
	}
}
