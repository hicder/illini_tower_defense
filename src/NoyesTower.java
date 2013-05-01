import javax.swing.ImageIcon;


public class NoyesTower extends Towers{

public NoyesTower(){
	name = "Noyes";
	damage = 100;
	range = 175;
	fireRate = 3;
	level=1;
	ImageIcon ii = new ImageIcon(this.getClass().getResource("TowerNoyes.png"));
	towerImage = ii.getImage();
	}

	public NoyesTower(Towers a){
		super(a);
	}
	
	

}
