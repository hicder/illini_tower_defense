import javax.swing.ImageIcon;


public class AltgeldTower extends Towers {
	//Long range tower slower attack speed

	public AltgeldTower(){
		name="Altgeld";
		damage = 100;
		range = 175;
		fireRate = 1;
		level=1;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("TowerAltgeld.png"));
		towerImage = ii.getImage();
	}
	public AltgeldTower(Towers a){
		super(a);
	}
	
	
	
}
