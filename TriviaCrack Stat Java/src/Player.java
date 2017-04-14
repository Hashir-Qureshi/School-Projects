import java.util.Random;
public class Player {

	public Player(){
		progress = 0;
		C_count = 0;
	}
	
	
	
	private boolean Crowns[] = {false,false,false,false,false,false};
	double Stats[] = new double[6];
	private int progress;
	private int C_count;
	private Random r = new Random();
	
	public void setCrown(int index, boolean status){
		Crowns[index] = status;
	}
	public boolean getCrown(int index){
		return Crowns[index];
	}
	
	public void setProg(int inProg){
		progress = inProg;
	}
	public int getProg(){
		return progress;
	}
	
	public void setCount(int inCount){
		C_count = inCount;
	}
	public int getCount(){
		return C_count;
	}
	
	public void setStats(double geo, double sci, double hist,double sport,double art,double ent){
		Stats[0] = geo;
		Stats[1] = sci;
		Stats[2] = hist;
		Stats[3] = sport;
		Stats[4] = art;
		Stats[5] = ent;
	}
	public double getStats(int index){
		return Stats[index];
	}
	
	public boolean ask(int index){
		double chance = r.nextInt(100)+1;
		chance = chance/100;
		if(chance <= Stats[index]){
			return true;
		}else return false;
	}
	
	public int select(){
		boolean found= false;
		int place=0;
		while(!found){
			place = r.nextInt(6);
			if(Crowns[place]== false){
				found = true;
			}else found = false;
		}
		return place;	
	}
	
	public void winCrown(int index){
		Crowns[index] = true;
		C_count++;
	}
	
	
	
	
}
