import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;


public abstract class Towers {
	protected String name = new String();
	public int x;
	public int y;
	protected int damage;
	protected int fireRate;
	protected int level;
	protected int cost;
	protected double range;
	public Image towerImage;
	public int BOX_SIZE = 50;
	
	public Towers(Towers a){
		this.x = a.x;
		this.y = a.y;
		this.damage = a.damage;
		this.fireRate = a.fireRate;
		this.level = a.level;
		this.cost = a.cost;
		this.range = a.range;
		this.towerImage = a.towerImage;
		this.name = a.name;
	}
	public Towers(){
		
	}
	
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}
	public void setLevel(int i){
		level = i;
	}
	
	public double getRange(){
		return range;
	}
	public void setRange(double i){
		range  = i;
	}
	public int getDamage(){
		return damage;
	}
	public void setDamage(int i){
		damage = i;
	}
	public int getFireRate(){
		return fireRate;
	}
	public void setFireRate(int i){
		fireRate = i;
	}
	public int getCost(){
		return cost;
	}
	
	
	
	public void upgrade(){
		if (TowerDefenseGame.money > cost){
			TowerDefenseGame.money = TowerDefenseGame.money - cost;
			this.level ++;
		}
	}

	public void attack(ArrayList<Creeps> a){
		double startTime = System.currentTimeMillis();
		//Main hieu = new Main();
		Collections.sort(a);									//sort the creep lists in order of distance to the end target
		Creeps closestCreep = getWithinRangeCreeps(a);			//get the first creeps in the list that is in range
//		while (closestCreep != null){							//if the closest creep is not null
//			if ((System.currentTimeMillis() - startTime) % fireRate == 0){
//				closestCreep.takeDamage(this.damage);
//			}
//			Collections.sort(a);
//			closestCreep = getWithinRangeCreeps(a);
//		}
		
		if(closestCreep != null){
			this.attack(closestCreep);
		}
	}
	
	public void attack(Creeps a){
		a.takeDamage(damage);
	}
	
	public boolean withinRange(int xCreep,int yCreep){
		double distance = Math.sqrt(Math.pow(xCreep - this.x*BOX_SIZE, 2) + Math.pow(yCreep - this.y*BOX_SIZE, 2));
		return (range > distance);
		
	}
	
	public Creeps getWithinRangeCreeps(ArrayList<Creeps> a){
		int count = 0;
		Collections.sort(a);
		while(count < a.size()){
			if(withinRange(a.get(count).getX(), a.get(count).getY()) && a.get(count).isAlive()){
				return a.get(count);	//return that creep
			}
			else count++;	//or increment to the next creep
		}
		return null;	//oops, all the creeps are out of range
	}
}
