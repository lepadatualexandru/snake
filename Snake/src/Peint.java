import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;



public class Peint extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

class Timp2 extends TimerTask{
	public int asd=0;
	public void run(){
		if(alive==false) asd++;
		if(asd==3) {gamestate="dead";
		alive=true;
		asd=0;
		}
		
	}
}
	
class Timp extends TimerTask{
	public void run(){
		repaint();
		try {
			Thread.sleep(80+(10-speed)*20-1);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}}
	

TimerTask timerTask = new Timp();
TimerTask timerTask2 = new Timp2();
Timer t = new Timer();
Timer t2 = new Timer();
Random rand=new Random();
boolean random;
static boolean alive=true;
public static String gamestate="meniu";
public static int butmeniu=0,butspeed=4,speed=5,scor=0,vely=0,velx=1;
int randx,randy;
public Peint(){
	
	Worm w=new Worm();
	for(int i=1;i<=4;i++){
	w=new Worm();
		w.x=Worm.worms.get(i).x-1;
	}
	t.schedule(timerTask, 0, 1);
	generateapple();
	t2.schedule(timerTask2, 0,250);
}
public static void restart(){
	scor=0;
	//alive=true;
	gamestate="ingame";
	Worm.worms.clear();
	velx=1;vely=0;
	Worm w=new Worm();
	for(int i=1;i<=4;i++){
	w=new Worm();
		w.x=Worm.worms.get(i).x-1;
	}
	
}

 void generateapple(){
	 randx=rand.nextInt(29)+0;
		randy=rand.nextInt(29)+0;
		for(Worm w:Worm.worms){
			if(w.x==randx && w.y==randy) random=false;
		}
		if(random) generateapple();
 }
 void miscare(){
 		if(Worm.worms.get(0).x==randx &&Worm.worms.get(0).y==randy) {
 			scor++;
 			generateapple();
 			@SuppressWarnings("unused")
			Worm w=new  Worm();
 		}
 		
 		Worm.worms.get(0).oldx=Worm.worms.get(0).x;
 		Worm.worms.get(0).oldy=Worm.worms.get(0).y;
 		
 		Worm.worms.get(0).x+=velx;
 		if(Worm.worms.get(0).x==30) Worm.worms.get(0).x=0;
 		if(Worm.worms.get(0).x==-1) Worm.worms.get(0).x=29;
 		
 		Worm.worms.get(0).y+=vely;
 		if(Worm.worms.get(0).y==30) Worm.worms.get(0).y=0;
 		if(Worm.worms.get(0).y==-1) Worm.worms.get(0).y=29;
 		
 		for(int i=1;i<=Worm.worms.size()-1;i++){
 		Worm.worms.get(i).oldx=Worm.worms.get(i).x;
 		Worm.worms.get(i).oldy=Worm.worms.get(i).y;
 		Worm.worms.get(i).x=Worm.worms.get(i-1).oldx;
 		Worm.worms.get(i).y=Worm.worms.get(i-1).oldy;
 		}
 		
 		
 		for(int k=1;k<=Worm.worms.size()-1;k++){
 			if(Worm.worms.get(0).x==Worm.worms.get(k).x && Worm.worms.get(0).y==Worm.worms.get(k).y) {
 			alive=false;
 		}
 		}
 }
public void paintmeniu(Graphics g){
	g.setFont(new Font("TimesRoman", Font.BOLD, 25));
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);
	
	g.setColor(Color.CYAN);
	switch(butmeniu){
	case 0:
		g.fillRect(200, 50, 200,100);	
		break;
	case 1:
		g.fillRect(200, 250,200,100);
		break;
	case 2:
		g.fillRect(200, 450,200,100);
		break;
	}
	

	
	g.setColor(Color.BLUE);
	g.fillRect(210, 60,180,80);
	g.fillRect(210, 260,180,80);
	g.fillRect(210, 460,180,80);
	g.setColor(Color.WHITE);
	g.drawString("START",250,105);
	g.drawString("SPEED",250,305);
	g.drawString("EXIT",260,505);
	g.setFont(new Font("TimesRoman", Font.BOLD, 10));
	g.drawString("Press \"W\" for next button", 224, 560);
	g.drawString("Press \"S\" for prev button", 224, 575);
	g.drawString("Press \"SPACE\" to select", 226, 590);
	butmeniu%=3;
	if(butmeniu==-1) butmeniu=2;
	
	
}
public void paintingame(Graphics g){
	miscare();
	g.setColor(Color.BLACK);	
	g.fillRect(0, 0, 600, 600);
	g.setColor(Color.WHITE);
	g.drawString("Score: "+scor, 275, 15);
	g.setColor(Color.CYAN);
	g.fillRect(randx*20, randy*20, 20,20);
	g.setColor(Color.RED);
	g.fillRect(Worm.worms.get(0).x*20, Worm.worms.get(0).y*20, 20,20);
	for(int i=1;i<=Worm.worms.size()-1;i++){
	if(alive==true)	g.setColor(Color.RED);
		g.fillRect(Worm.worms.get(i).x*20, Worm.worms.get(i).y*20, 20, 20);
	if(alive==true)	g.setColor(Color.BLACK);
		g.fillRect((Worm.worms.get(i).x*20)+2, (Worm.worms.get(i).y*20)+2, 16, 16);}
}
	


public void paintspeed(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);
	// 600 = 125 125 100 125 125
	// 600 = 5*x + 6*y
	// 600 = 62 75 62 75 62 75 62 75 62 75 66
	g.setColor(Color.CYAN);
	switch(butspeed){
	case 0:
		g.fillRect(125, 45, 125, 72);
		break;
	case 1:
		g.fillRect(125, 145, 125, 72);
		break;
	case 2:
		g.fillRect(125, 245, 125, 72);
		break;
	case 3:
		g.fillRect(125, 345, 125, 72);
		break;
	case 4:
		g.fillRect(125, 445, 125, 72);
		break;
	case 5:
		g.fillRect(375, 45, 125, 72);
		break;
	case 6:
		g.fillRect(375, 145, 125, 72);
		break;
	case 7:
		g.fillRect(375, 245, 125, 72);
		break;
	case 8:
		g.fillRect(375, 345, 125, 72);
		break;
	case 9:
		g.fillRect(375, 445, 125, 72);
		break;
	}
	g.setFont(new Font("TimesRoman", Font.BOLD, 25));
	for(int i=45;i<=500;i+=100){
	g.setColor(Color.blue);
	g.fillRect(129, i+4, 117, 64);
	g.fillRect(379, i+4, 117, 64);
	g.setColor(Color.WHITE);
	g.drawString(String.valueOf(i/100+1),175 , i+42);
	g.drawString(String.valueOf(i/100+6),425 , i+42);
	}
	g.setFont(new Font("TimesRoman", Font.BOLD, 15));
	g.drawString("Current speed : "+speed, 450, 20);
	g.drawString("Press \"SPACE\" to choose speed", 200 ,550);
	if(butspeed<0) {
		butspeed*=-1;
		butspeed=10-butspeed;
	}
	butspeed%=10;
	
}

public void paintdead(Graphics g){
	g.setFont(new Font("TimesRoman", Font.BOLD, 9));
	g.setColor(Color.BLACK);
	g.fillRect(0,0,600,600);
	g.setColor(new Color(50,5,5));
	for(int i=0;i<=600;i+=40){
		for(int j=10;j<=600;j+=20){
			g.drawString("Dead:( ", i, j);
		}}
	g.setFont(new Font("TimesRoman", Font.BOLD, 25));
	g.setColor(Color.WHITE);
	g.drawString("Score: "+scor,230,200);
	g.setColor(Color.RED);
	g.drawString("Press \"R\" to play again.",120,300);
	g.drawString("Press \"B\" to open menu.",120,400);
	
}

public void paintComponent(Graphics g){
	
	if(gamestate=="ingame")		paintingame(g);
	if(gamestate=="meniu")		paintmeniu(g);
	if(gamestate=="meniuspeed")		paintspeed(g);
	if(gamestate=="dead") paintdead(g);
	}
	
	
	
	
	
}

