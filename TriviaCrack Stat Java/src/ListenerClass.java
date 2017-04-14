import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ListenerClass implements ActionListener{
	JTextField[] p1Stats;
	JTextField[] p2Stats;
	JRadioButton[] p1Prog;
	JRadioButton[] p2Prog;
	
	
	public ListenerClass(JTextField[] inp1Stats, JTextField[] inp2Stats, JRadioButton[] inp1Prog, JRadioButton[] inp2Prog){
		p1Stats = inp1Stats;
		p2Stats = inp2Stats;
		p1Prog = inp1Prog;
		p2Prog = inp2Prog;

	}
	public void actionPerformed(ActionEvent e) {
		Random r = new Random();
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		player1.setStats((Double.parseDouble(p1Stats[0].getText()))/100,(Double.parseDouble(p1Stats[1].getText()))/100,(Double.parseDouble(p1Stats[2].getText()))/100,(Double.parseDouble(p1Stats[3].getText()))/100,(Double.parseDouble(p1Stats[4].getText()))/100,(Double.parseDouble(p1Stats[5].getText()))/100);
		player2.setStats((Double.parseDouble(p2Stats[0].getText()))/100,(Double.parseDouble(p2Stats[1].getText()))/100,(Double.parseDouble(p2Stats[2].getText()))/100,(Double.parseDouble(p2Stats[3].getText()))/100,(Double.parseDouble(p2Stats[4].getText()))/100,(Double.parseDouble(p2Stats[5].getText()))/100);
		
		Player curPlayer = player1;
		
		int Spin,crown;
		double p1GamesWon=0,p2GamesWon=0,p1Perc,p2Perc;

		
		
		for(int i=0;i<10000;i++){
			for(int a=0;a<6;a++){
				if(p1Prog[a].isSelected()){
					player1.setCrown(a, true);
					player1.setCount(player1.getCount()+1);
				}
				
				if(p2Prog[a].isSelected()){
					player2.setCrown(a, true);
					player2.setCount(player2.getCount()+1);
				}	
			}

		while(curPlayer.getCount() != 6){
			Spin = r.nextInt(7);
			if (Spin < 6 ){
				if(curPlayer.ask(Spin))
					curPlayer.setProg((curPlayer.getProg()+1)); 
				else{
					if(curPlayer == player1)
						curPlayer = player2;
					else curPlayer = player1;
					continue;
				}
					
			}else{
				curPlayer.setProg(0);
				crown = curPlayer.select();
				if(curPlayer.ask(crown)){
					curPlayer.winCrown(crown);
				}
		
				else {
					if(curPlayer == player1)
						curPlayer = player2;
					else curPlayer = player1;
					continue;
				}
						
			}
			if(curPlayer.getProg()== 3){
				curPlayer.setProg(0);
				crown = curPlayer.select();
				if(curPlayer.ask(crown)){
					curPlayer.winCrown(crown);
				}

					else {
						if(curPlayer == player1)
							curPlayer = player2;
						else curPlayer = player1;
						continue;
					}
						
			}
		
			}
		if(player1.getCount() == 6)
			p1GamesWon++;
		else
			p2GamesWon++;
		
		
		clearProgress(player1,player2);
		
		}
		NumberFormat percentageFormat = NumberFormat.getPercentInstance();
		p1Perc = (p1GamesWon/10000);
		p2Perc = (p2GamesWon/10000);
	JOptionPane.showMessageDialog(null, "Player 1 Win Percentage: "+percentageFormat.format(p1Perc)+"\nPlayer 2 Win Percentage: "+percentageFormat.format(p2Perc));
	


			}
		public static void clearProgress(Player p1,Player p2){
			p1.setProg(0);
			p2.setProg(0);
			
			p1.setCount(0);
			p2.setCount(0);
			
			for(int i=0;i<6;i++){
			p1.setCrown(i, false);
			p2.setCrown(i, false);
			}
		
		
	}

}
