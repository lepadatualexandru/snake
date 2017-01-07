import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Butoane extends KeyAdapter {
int contor=0;
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_W){
			if(Peint.gamestate=="ingame")	if(Peint.velx!=0) {
				Peint.vely=-1;Peint.velx=0;
				
			}
			if(Peint.gamestate=="meniu") Peint.butmeniu--;
			if(Peint.gamestate=="meniuspeed") Peint.butspeed--;
		}
			
		if(e.getKeyCode()==KeyEvent.VK_S){
			if(Peint.gamestate=="ingame")	if(Peint.velx!=0) {
				Peint.vely=1;Peint.velx=0;
				
			}
			if(Peint.gamestate=="meniu") Peint.butmeniu++;
			if(Peint.gamestate=="meniuspeed") Peint.butspeed++;
		}
		if(e.getKeyCode()==KeyEvent.VK_D){
			if(Peint.gamestate=="ingame")	if(Peint.vely!=0){
				Peint.velx=1;Peint.vely=0;
				}
			if(Peint.gamestate=="meniuspeed") Peint.butspeed+=5;
			}
		if(e.getKeyCode()==KeyEvent.VK_A){
			if(Peint.gamestate=="ingame")  if(Peint.vely!=0){
				Peint.velx=-1;Peint.vely=0;
				}
			if(Peint.gamestate=="meniuspeed") Peint.butspeed-=5;}
		
		if(e.getKeyCode()==KeyEvent.VK_B){
			if(Peint.gamestate=="meniuspeed") Peint.gamestate="meniu";
			if(Peint.gamestate=="dead") Peint.gamestate="meniu";
			
			}
		
		if(e.getKeyCode()==KeyEvent.VK_R){
			if(Peint.gamestate=="dead") Peint.restart();
			}
		
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
		
			//Peint.velx=1;
			//Peint.vely=0;
			
			contor=0;
			if(Peint.gamestate=="meniu") switch(Peint.butmeniu){
			case 0:
				Peint.restart();
				contor++;
				break;
			case 1:
				contor++;
				Peint.gamestate="meniuspeed";
				break;
			case 2:
				contor++;
				System.exit(0);
			}
			
			if(Peint.gamestate=="meniuspeed" && contor==0){ Peint.speed=Peint.butspeed+1;

			Peint.gamestate="meniu";}
			
		}
	
	}
	
}
