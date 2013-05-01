import javax.swing.ImageIcon;


public class ISRTower extends Towers {
// Slows down creeps in range
	
	public ISRTower(){
		name="ISR";
		damage = 0;
		range = 175;
		fireRate = 2;
		level=1;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("TowerISR.png"));
		towerImage = ii.getImage();
	}
	
	public ISRTower(Towers a){
		super(a);
	}
}
