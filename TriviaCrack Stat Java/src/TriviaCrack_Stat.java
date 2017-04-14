
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class TriviaCrack_Stat {

	public static void main(String[] args) {
	JFrame TriviaCrackStat = new JFrame("TriviaCrackStat");
	TriviaCrackStat.setSize(600, 700);
	TriviaCrackStat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel Panel = new JPanel();
	TriviaCrackStat.add(Panel);
	Panel.setLayout(null);
	Panel.setBackground(Color.WHITE);
	String[] Subjects = {"Geography","Science","History","Sports","Art","Entertainment"};
	//String[] ImagePaths = {"Geography.jpg","Science.jpg"}
	
	Image img;
	ImageIcon subjectImage;
	
	JLabel p1Labels;	
	JTextField p1PercText;
	
	JLabel p2Labels;	
	JTextField p2PercText;
	
	JRadioButton p1Radios;
	JRadioButton p2Radios;

	
	JLabel Wall;
	JLabel Wall2;
	JLabel Wall3;
	JLabel imageLabel1;
	JLabel imageLabel2;
	
	JTextField[] p1inputArray = new JTextField[6];
	JTextField[] p2inputArray = new JTextField[6];
	JRadioButton[] p1RadioArray = new JRadioButton[6];
	JRadioButton[] p2RadioArray = new JRadioButton[6];

	
	for(int i=1; i<=6;i++){
		p1PercText = new JTextField();
		p1PercText.setLocation(120, (i*25)+40);
		p1PercText.setSize(50, 20);
		
		p1Labels = new JLabel();
		p1Labels.setText(Subjects[i-1]+":");
		p1Labels.setSize(83, 30);
		p1Labels.setLocation((p1PercText.getLocation().x - p1Labels.getSize().width) - 10, p1PercText.getLocation().y - 6);
		
		p1Radios = new JRadioButton();
		p1Radios.setText(Subjects[i-1]);
		p1Radios.setLocation(p1Labels.getLocation().x, (i*45)+230);
		p1Radios.setSize(110, 30);
		p1Radios.setBackground(Color.WHITE);
		
		p2PercText = new JTextField();
		p2PercText.setLocation(420, (i*25)+40);
		p2PercText.setSize(50, 20);
		
		p2Labels = new JLabel();
		p2Labels.setText(Subjects[i-1]+":");
		p2Labels.setSize(83, 30);
		p2Labels.setLocation((p2PercText.getLocation().x - p2Labels.getSize().width) - 10, p2PercText.getLocation().y - 6);
		
		p2Radios = new JRadioButton();
		p2Radios.setText(Subjects[i-1]);
		p2Radios.setLocation(p2Labels.getLocation().x, (i*45)+230);
		p2Radios.setSize(110, 30);
		p2Radios.setBackground(Color.WHITE);
		
		
		Wall = new JLabel();
		Wall.setText("|");
		Wall.setSize(5, 35);
		Wall.setLocation(248, (i*25)- 5);
		
		Wall2 = new JLabel();
		Wall2.setText("|");
		Wall2.setSize(5, 35);
		Wall2.setLocation(248, (i*30)+145);
		
		Wall3 = new JLabel();
		Wall3.setText("|");
		Wall3.setSize(5, 35);
		Wall3.setLocation(248, (i*30)+330);
		
		subjectImage = new ImageIcon(Subjects[i-1]+".jpg");
		
		img = subjectImage.getImage();
		img = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		
		subjectImage = new ImageIcon(img);
		
		imageLabel1 = new JLabel();
		imageLabel1.setSize(50, 50);
		imageLabel1.setLocation(p1Labels.getLocation().x + p1Radios.getSize().width, (i*45)+220);
		imageLabel1.setIcon(subjectImage);
		
		imageLabel2 = new JLabel();
		imageLabel2.setSize(50, 50);
		imageLabel2.setLocation(p2Labels.getLocation().x + p2Radios.getSize().width, (i*45)+220);
		imageLabel2.setIcon(subjectImage);
		
		Panel.add(p1PercText);
		Panel.add(p1Labels);
		
		Panel.add(p2PercText);
		Panel.add(p2Labels);
		
		Panel.add(p1Radios);
		Panel.add(p2Radios);
		
		Panel.add(Wall);
		Panel.add(Wall2);
		Panel.add(Wall3);
		
		Panel.add(imageLabel1);
		Panel.add(imageLabel2);
		
		p1inputArray[i-1] = p1PercText;
		p2inputArray[i-1] = p2PercText;
		p1RadioArray[i-1] = p1Radios;
		p2RadioArray[i-1] = p2Radios;
	}
	Font f = new Font("Courier", Font.BOLD, 18);
	Font C = new Font("Courier", Font.BOLD, 15);
	
	JLabel p1Title = new JLabel();
	p1Title.setText("Player 1 Stats:");
	p1Title.setFont(f);
	p1Title.setSize(180, 60);
	p1Title.setLocation(27, 5);
	
	JLabel p2Title = new JLabel();
	p2Title.setText("Player 2 Stats:");
	p2Title.setFont(f);
	p2Title.setSize(300, 60);
	p2Title.setLocation(p1Title.getLocation().x + p1Title.getSize().width + 100, 5);
	
	JLabel p1Crown= new JLabel();
	p1Crown.setText("Player 1's Crowns Won:");
	p1Crown.setFont(C);
	p1Crown.setSize(250, 60);
	p1Crown.setLocation(27, 200 );
	
	JLabel p2Crown= new JLabel();
	p2Crown.setText("Player 2's Crowns Won:");
	p2Crown.setFont(C);
	p2Crown.setSize(250, 60);
	p2Crown.setLocation(p1Crown.getLocation().x + p1Crown.getSize().width, 200 );
	
	ListenerClass CalcListener = new ListenerClass(p1inputArray,p2inputArray,p1RadioArray,p2RadioArray);
	
	JButton Calculate = new JButton();
	Calculate.setText("Give me the Win Percentages!");
	Calculate.setLocation(143, 540);
	Calculate.setSize(210, 50);
	Calculate.addActionListener(CalcListener);
	
	
	Panel.add(p1Title);
	Panel.add(p2Title);
	Panel.add(p1Crown);
	Panel.add(p2Crown);
	Panel.add(Calculate);
	
		//categories={"Geography","Science","History","Sports","Art","Entertainment"};
	
Panel.setVisible(true);
TriviaCrackStat.setVisible(true);
		}

	
}


