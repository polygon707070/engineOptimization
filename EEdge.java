 package GraphDDrawingProject;
import java.awt.Color;
import java.awt.Graphics;


public class EEdge
{
	public Node a,b;
	public double length;
                     GraphDDrawingProject agf;
	
	public void Draw(Graphics g ,Color c)
	{
                            g.setColor(c);
                            int x1=(int)a.posTodraw.getX() ;
                            int y1=(int)a.posTodraw.getY() ;
                            int x2=(int)b.posTodraw.getX();
                            int y2=(int)b.posTodraw.getY();
                            
                            g.drawLine (x1, y1,x2,y2);
                            
                            int cx = (int) ((x1 + x2) / 2)-1;
                            int cy = (int) ((y1 + y2) / 2)-1;
                           // int x=DrawGraph.x;
                            if(agf.typeOfGraph==1||agf.typeOfGraph==3)
                            {
                                int d=10;
                               double angle = (float) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
                                // double angle = Util.angle360(from, to)
                                 double anglePlus45 = angle + 45;
                                 if (anglePlus45 > 360)
                                     anglePlus45 = anglePlus45 % 360;
                                 double angleMinus45 = angle - 45;
                                 if (angleMinus45 < 360)
                                     angleMinus45 = angleMinus45 + 360;
                                 anglePlus45 = Math.toRadians(anglePlus45);
                                 angleMinus45 = Math.toRadians(angleMinus45);
                                 int ax1 = (int) (cx - d * Math.cos(anglePlus45));
                                 int ay1 = (int) (cy - d * Math.sin(anglePlus45));
                                 int ax2 = (int) (cx - d * Math.cos(angleMinus45));
                                 int ay2 = (int) (cy - d * Math.sin(angleMinus45));
                                 g.drawLine(cx, cy, ax1, ay1);
                                 g.drawLine(cx, cy, ax2, ay2);
                            }
                             if(agf.typeOfGraph==1||agf.typeOfGraph==2)
                                g.drawString(""+length,cx, cy);
	}
	
	public Vector getForce(Node toCal)
	{
		Vector dir ;
		if(a== toCal) {
			dir = b.pos.sub(a.pos);
		}
		else
		{
			dir = a.pos.sub(b.pos);
		}
		 double t=dir.Size()-10*length;
		double ss = Math.signum(t) *Math.log( Math.abs(t))*0.01;
		System.out.println("ss=" + ss);
		dir = dir.Unit().Mul(ss);
		return dir;
	}

}
