import javax.swing.ImageIcon;


public class MITCreep extends Creeps{
	public MITCreep(int x,int  y){
		super(x,y);
		health = 30000000;
		dx = 50;
		div = 30;
		this.x = x;
		this.y = y;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("RiS_BlueBullet.png"));
		creepImage = ii.getImage();

	}

}
