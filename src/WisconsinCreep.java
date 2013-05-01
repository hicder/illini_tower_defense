import javax.swing.ImageIcon;


public class WisconsinCreep extends Creeps {
	public WisconsinCreep(int x, int y){
		super(x,y);
		health = 300000;
		dx = 50;
		div = 15;
		this.x = x;
		this.y = y;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("RiS_BlueBullet.png"));
		creepImage = ii.getImage();
	}
}
