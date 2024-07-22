
/*This class works properly */

package GraphDDrawingProject;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Collections;

public class DirectedGraph implements GraphInterface
{
     Vector adjacentVertices;
     private int numOfEdges;
  
     public DirectedGraph()
     {
         adjacentVertices= new Vector() ;
     }
     public void setGraph(Vector adjacentVertex)
     {
         this.adjacentVertices= adjacentVertex;
     }
    public int findVertex(int index)
    {
        for(int i=0 ;i<adjacentVertices.size();i++)
        {
            Vector v =(Vector) adjacentVertices.elementAt(i);
            Vertex vertex =(Vertex) v.elementAt(0);
            if(vertex.getIndex()==index)
                return i;
        }
        return -1;
    }
    public boolean addVertex(int index)
    {
      if(findVertex(index)==-1)
      {
            Vector vec =new Vector();
            Vertex vertex = new Vertex(index);
            vec.add(vertex);
            adjacentVertices.add(vec);
            return true;
      }
      else
          return false;
    }
    public boolean deleteVertex(int  index)
    {
        int indexOfVertex = findVertex(index);
        if(indexOfVertex!=-1)
        {
            adjacentVertices.remove(indexOfVertex);
            for(int i=0; i<adjacentVertices.size(); i++)
            {
                Vector vec =(Vector) adjacentVertices.elementAt(i);
                int vecSize = vec.size();
                for(int j=1; j<vecSize; j++)
                {
                    Vertex vertex = (Vertex)vec.elementAt(j);
                    if(vertex.getIndex() == index)
                    {
                        vec.remove(j);
                        vecSize--;
                        j--;
                    }
                }
                adjacentVertices.set(i, vec);
            }
            return  true;
        }
        return  false;
    }
    public boolean addEdge(int firstIndex ,int secondIndex)
    {
        int indexOfFirstVertex = findVertex(firstIndex);
        int indexOfSecondVertex = findVertex(secondIndex);
        if(indexOfFirstVertex !=-1 && indexOfSecondVertex !=-1)
        {
            Vector vec = (Vector)adjacentVertices.elementAt(indexOfFirstVertex);
            for(int i=1;i<vec.size();i++)
            {
                Vertex vertex = (Vertex)vec.elementAt(i);
                if(vertex.getIndex() == secondIndex)
                    return false;
            }
            Vertex vertex = new Vertex(secondIndex);
            vec.add(vertex);
            adjacentVertices.set(indexOfFirstVertex,vec);
            numOfEdges++;
            return true;
        }
        return false;
    }
    public boolean deleteEdge(int firstIndex ,int secondIndex)
    {
        int indexOfVertex = findVertex(firstIndex);
        Vector vec = (Vector)adjacentVertices.elementAt(indexOfVertex);
        for(int i=1; i<vec.size();i++)
        {
            Vertex vertex = (Vertex)vec.elementAt(i);
            if(vertex.getIndex() == secondIndex)
            {
                vec.remove(i);
                adjacentVertices.set(indexOfVertex,vec);
                return true;
            }
        }
        return false;
    }
  
    public void  showGraph ()
    {   
        for(int i=0 ;i<adjacentVertices.size();i++)
        {
            Vector vec = (Vector)adjacentVertices.elementAt(i);
            Vertex vertex =(Vertex)vec.elementAt(0);
            GraphDDrawingProject.arrayOfGraphVertices.add(String.valueOf(vertex.getIndex()));
            GraphDDrawingProject.tempArrayInputTable.add(String.valueOf(vertex.getIndex()));
           
        }
       GraphDDrawingProject.arrayInputTAble =new int [GraphDDrawingProject.arrayOfGraphVertices.size()][GraphDDrawingProject.arrayOfGraphVertices.size()];
        //connection
        Collections.sort(GraphDDrawingProject.arrayOfGraphVertices);
         for(int i=0 ;i<adjacentVertices.size();i++)
        {
            Vector vec = (Vector)adjacentVertices.elementAt(i);
            Vertex vertex =(Vertex)vec.elementAt(0);
            for(int j=1 ;j<vec.size();j++)
            {
                Vertex v = (Vertex)vec.elementAt(j);
                int nodeI=0,nodeJ=0;
                for(int k=0;k<GraphDDrawingProject.arrayOfGraphVertices.size();k++)
                {
                    if(String.valueOf(vertex.getIndex()).equals((String)GraphDDrawingProject.arrayOfGraphVertices.get(k)))
                    {
                        nodeI=k;
                        //System.out.println("i = "+nodeI);
                    }  
                    else if(String.valueOf(v.getIndex()).equals((String)GraphDDrawingProject.arrayOfGraphVertices.get(k)))
                    {
                        nodeJ=k;
                        //System.out.println("j = "+nodeJ);
                    }
                    else
                       GraphDDrawingProject.arrayInputTAble[k][k]=0;
                    if(nodeI!=0&&nodeJ!=0)
                        break;
                }
            GraphDDrawingProject.arrayInputTAble[nodeI][nodeJ]=1;
            //System.out.println("arrayOfGraphVertices sort = "+agf.arrayInputTAble[nodeI][nodeJ]);

            //System.out.println(vertex.getIndex()+"   "+v.getIndex());
            
          
            }
        }
          System.out.println("in put table");
          for(int i=0;i<GraphDDrawingProject.arrayOfGraphVertices.size();i++)
          {
               for(int j=0;j<GraphDDrawingProject.arrayOfGraphVertices.size();j++)
               {
                   System.out.print(GraphDDrawingProject.arrayInputTAble[i][j]+" ");
               }
               System.out.println(" ");
          }
    }
    public void clearGraph()
    {
        adjacentVertices.clear();
    }

    public Vector getConnectionsOfVetex(int index) 
    {
        int indexV=findVertex(index);
        if(indexV != -1)
        {
            Vector vec = (Vector)adjacentVertices.elementAt(indexV);
            return vec;
        }
        return null;
    }
}