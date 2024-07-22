 package GraphDDrawingProject;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawGraph extends JPanel
{
	public int [][] inputTable ;
	public String[] Nodename ;
	int []arr =new int[5];
	ArrayList<Node> all;
	ArrayList<EEdge> edges;
                     List<Color>color;
	int n;
        int mmm=0;
                     //public static int x;
                    int w , h ;//width & height
                  //  public static int x;
                    int indexArr=0;
	public void GenerateGraph()
	{
		int n= 12;
		inputTable = new int[n][n];
		Nodename = new String[n];
		for(int i=0;i< Nodename.length;i++)
		{ 
			for(int j=i+1;j< Nodename.length;j++)
			{ 
				if(Math.random() > 0.6)
				{
					inputTable[i][j] = (int)(Math.random() * 20);
					inputTable[j][i] =inputTable[i][j] ;
				}
			}
		}
		for(int i=0;i< Nodename.length;i++)
		{ 
			Nodename[i]= "" + (char)(65+i);
		}
	}
	
	public void GenerateGraph2()
	{
		int n= 12;
		inputTable = new int[n][n];
		Nodename = new String[n];
		for(int i=0;i< Nodename.length;i++)
		{ 
			for(int j=i+1;j< Nodename.length;j++)
			{ 
				if(Math.random()/Math.log(j-i)*Math.log(2)*2 > 0.5)
				{
					inputTable[i][j] = (int)(Math.random() * 7*(j-i));
					inputTable[j][i] =inputTable[i][j] ;
				}
			}
		}
		for(int i=0;i< Nodename.length;i++)
		{ 
			Nodename[i]= "" + (char)(65+i);
		}
	}
	
	
	public void ProcessInput()
	{
		//GenerateGraph();
		//GenerateGraph2();
		all = new ArrayList<Node>();
		edges =new ArrayList<EEdge>();
		
		for(int i=0;i< Nodename.length;i++)
		{
                                                    all.add(new Node());
                                                    all.get(i).name = Nodename[i]; 
                                                    all.get(i).Adj= new ArrayList<EEdge>();
		}
		
		for(int i=0;i< Nodename.length;i++)
		{ 
			for(int j=0;j< Nodename.length;j++)
			{ 
				if(inputTable[i][j] != 0)
				{
                                                                                            EEdge e = new EEdge();
                                                                                            e.a = all.get(i);
                                                                                            e.b = all.get(j);
                                                                                            e.length = inputTable[i][j] ;
                                                                                            edges.add(e);
                                                                                            if(mmm!=-1)
                                                                                            {
                                                                                            if(GraphDDrawingProject.positionOfColoredEdge[i][j]==1)
                                                                                            {
                                                                                                arr[indexArr]=edges.indexOf(e);
                                                                                                 indexArr++;
                                                                                            }
                                                                                            }
                                                                                            //end if
                                                                                            all.get(i).Adj.add(e);
                                                                                            all.get(j).Adj.add(e); 
				}
			}
		}
	}

	public DrawGraph(JFrame f,int [][]inputTable,String []Nodename, int numOfvertex)
	{ 
                                this.inputTable=inputTable; 
                                this.Nodename=Nodename;
                                this.color=color;
                                if(numOfvertex==-1)
                                {
                                    n=5;
                                    mmm=-1;
                                    w=600;h=600;
                                    GraphDDrawingProject.typeOfGraph=1;
                                   // this.setBackground(Color.getHSBColor(102,0,102));
                                    this.setBackground(Color.GRAY);
                                }
                                else
                                    {
                                        n=numOfvertex;
                                         w=600;h=600;   
                                         this.setBackground(Color.GRAY);
                                     }
                                ProcessInput();
		Thread t = new Thread(new Runnable()
		{ 
			@Override
			public void run()
			{
				 while(true)
				 {
					try
					{
						Thread.sleep(100);
					} catch (InterruptedException e)
					{ 
						e.printStackTrace();
					}
					for(int j=0;j< Nodename.length;j++)
					{ 
						all.get(j).acc=new Vector();
						all.get(j).calForce(all);
						all.get(j). calForceEdge( ); 
						all.get(j).move();
					}
					//scale
					Scale();
					//centroid
					Vector centoid = all.get(0).getCentroid(all);
					Vector temp = (new Vector(300,300)).sub(centoid);
					for(int j=0;j< Nodename.length;j++)
					{ 
						 all.get(j).posTodraw=all.get(j).posTodraw.add(temp) ;
					}
					
					
					
					
					repaint();
					
				 }
			}
		});
		
		t.start();	
                                        this.setSize(w, h);
                                         f.add(this);
                                        
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		for(int j=0;j< Nodename.length;j++)
		{
			all.get(j).Draw(g);
		}
		for(int j=0;j< edges.size();j++)
		{
                                                    if(j==arr[j])
                                                         edges.get(j).Draw(g,Color.RED);
                                                    else
                                                        edges.get(j).Draw(g,Color.BLACK);
		}
	}
//	public static void main(String[] args)
//	{
//		new DrawGraph();
//	}
	
	
	public void Scale()
	{
		double XMin= Integer.MAX_VALUE;
		double YMin= Integer.MAX_VALUE;
		double XMax= Integer.MIN_VALUE;
		double YMax= Integer.MIN_VALUE;
		
		for(int j=0;j< Nodename.length;j++)
		{
			if(all.get(j).pos.getX() < XMin)
			{
				XMin=all.get(j).pos.getX();
			}
			if(all.get(j).pos.getY() < YMin)
			{
				YMin=all.get(j).pos.getY();
			}
			if(all.get(j).pos.getX() > XMax)
			{
				XMax=all.get(j).pos.getX();
			}
			if(all.get(j).pos.getY() > YMax)
			{
				YMax=all.get(j).pos.getY();
			}
		}
		
		double length_x = XMax- XMin;
		double length_y = YMax- YMin;
		double length  = Math.max(length_x, length_y);
		for(int j=0;j< Nodename.length;j++)
		{
			 Vector vv = all.get(j).pos;
			 vv= vv.Mul(400.0 / length);
			 all.get(j).setPosToDraw(vv);
		}
		
		
		
	}

}
