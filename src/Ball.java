import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Ball extends Applet implements Runnable{

    int x = 0;
    int y = 100;
    boolean flag = false;
    boolean mv = false;
    boolean started = false;
    Thread th = new Thread(this);
  
        
    
    Button Start;
    Button Pause;
    public void init() {
        Start = new Button("Start");
        Pause = new Button ("Pause");
        Start.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                if(started == true)  
                  th.resume();
                else
                {
                    th.start();
                    started = true;
                }                
             }
        });
        add(Start);
        
        Pause.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                   th.suspend();
                   
             }
        });
        add(Pause);
        
      
    }
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
	g.fillOval(x,y,25,25);
        
    }
    
    public void run()
	{
		while(true)
		{
			try
			{
				repaint();
				Thread.sleep(50);
				if(flag == false)
				{
					x = x + 10;
					if(x <0)
					{
						flag = false;
					}
					
					else if(x >= getWidth()-30)
					{
						flag = true;
					}
				}
					
				else
				{
					x = x - 10;
					if(x <0)
					{
						flag = false;
					}
					
					else if(x >= getWidth()-30)
					{
						flag = false;
					}
						
				}
				if(mv == false)
				{
					y = y + 15;
					if(y <0)
					{
						mv = false;
					}
					
					else if(y >= getHeight()-30)
					{
						mv = true;
					}
				}
					
				else
				{
					y = y - 15;
					if(y <0)
					{
						mv = false;
					}
					
					else if(y >= getHeight()-30)
					{
						mv = false;
					}
						
				}
				
				
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}

 
}
