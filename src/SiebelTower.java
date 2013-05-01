import javax.swing.ImageIcon;


public class SiebelTower extends Towers{
 // Faster but weaker tower.
	
	public SiebelTower(){
		name="Siebel";
		damage = 50;
		range = 175;
		fireRate = 5;
		level=1;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("TowerSiebel.png"));
		towerImage = ii.getImage();
	}
	public SiebelTower(Towers a){
		super(a);
	}
	
	
}
