
package GraphDDrawingProject;

import java.util.Collections;
import java.util.Vector;
public class UnDirectedWeightedGraph implements WeightedGraphInterface
{
    private Vector adjacentVertices;
    private int numOfEdges;
    public UnDirectedWeightedGraph()
    {
        adjacentVertices = new Vector();
    }
    public void setGraph(Vector adjacentVertex)
     {
         this.adjacentVertices= adjacentVertex;
     }
        
    public int findVertex(int index)
    {
        for(int i =0; i<adjacentVertices.size();i++)
        { 
            Vector v = new Vector();
            v=(Vector)adjacentVertices.elementAt(i);
            Vertex ver = (Vertex)v.elementAt(0);
           if(ver.getIndex()==index)
               return i;
        }
        return -1;
    }
        
    public boolean addVertex(int index)
    {
        if(findVertex(index)==-1)
        {
            Vector v = new Vector();
            Vertex vertex =new Vertex(index);
            v.add(vertex);
            adjacentVertices.add(v);
            return true;
        }
        return false;
    }
 
    public boolean deleteVertex(int  index)
    { 
        int indexOfVertex = findVertex(index);
        if(indexOfVertex == -1)
            return false;
        Vector vectorOfVertex = (Vector)adjacentVertices.elementAt(indexOfVertex);
        for(int i=1;i<vectorOfVertex.size();i++)
        {
            Edge edge = (Edge)vectorOfVertex.elementAt(i);
            int indexOfConnnectedVertex = edge.getIndex();
            deleteEdge(indexOfConnnectedVertex,index);
            i--;
        }
        adjacentVertices.removeElementAt(indexOfVertex);
        return true;
    }
    public boolean addEdge(int firstIndex ,int secondIndex,int weight)
    {
        int indexOfFirstVertex = findVertex(firstIndex);
        int indexOfSecondVertex = findVertex(secondIndex);
        if(indexOfFirstVertex !=-1 && indexOfSecondVertex !=-1)
        {
           
            Vector first = (Vector)adjacentVertices.elementAt(indexOfFirstVertex);
            Vector second = (Vector)adjacentVertices.elementAt(indexOfSecondVertex);
             for(int i=1;i<first.size();i++)
            {
                Edge edge = (Edge)first.elementAt(i);
                if(edge.getIndex() == secondIndex)
                    return false;
            }
            first.add(new Edge(secondIndex,weight));
            second.add(new Edge(firstIndex,weight));
            adjacentVertices.set(indexOfFirstVertex, first);
            adjacentVertices.set(indexOfSecondVertex, second);
            return true;
        }
        return false;
    }
    
    public boolean deleteEdge(int firstIndex ,int secondIndex)
    {
        int indexOfFirst = findVertex(firstIndex);
        int indexOfSecond = findVertex(secondIndex);
        if(indexOfFirst !=-1 && indexOfSecond !=-1)
        {
            Vector v1 = (Vector)adjacentVertices.elementAt(indexOfFirst);
            Vector v2 = (Vector)adjacentVertices.elementAt(indexOfSecond);
            for(int i=1;i<v1.size();i++)
            {
               if(((Edge)v1.elementAt(i)).getIndex()==secondIndex)
               {
                   v1.remove(i);
                   adjacentVertices.set(indexOfFirst, v1);
                   break;
               }
            }
            for(int i=1;i<v2.size();i++)
            {
                if(((Edge)v2.elementAt(i)).getIndex()== firstIndex)
                {
                    v2.remove(i);
                    adjacentVertices.set(indexOfSecond, v2);
                    break;
                }
            }
            return true;
        }
        return false;
    }
    public void showGraph()
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
                Edge wc = (Edge)vec.elementAt(j);
                int nodeI=0,nodeJ=0;
                for(int k=0;k<GraphDDrawingProject.arrayOfGraphVertices.size();k++)
                {
                    if(String.valueOf(vertex.getIndex()).equals((String)GraphDDrawingProject.arrayOfGraphVertices.get(k)))
                    {
                        nodeI=k;
                        //System.out.println("i = "+nodeI);
                    }  
                    else if(String.valueOf(wc.getIndex()).equals((String)GraphDDrawingProject.arrayOfGraphVertices.get(k)))
                    {
                        nodeJ=k;
                        //System.out.println("j = "+nodeJ);
                    }
                    else
                       GraphDDrawingProject.arrayInputTAble[k][k]=0;
                    if(nodeI!=0&&nodeJ!=0)
                        break;
                }
            GraphDDrawingProject.arrayInputTAble[nodeI][nodeJ]=wc.getWeight();
            System.out.println("arrayOfGraphVertices sort = "+GraphDDrawingProject.arrayInputTAble[nodeI][nodeJ]);

            //System.out.println(vertex.getIndex()+"   "+v.getIndex());
            }
        }
    }
    
   public void updateWeight(int first,int seconed ,int weight)
   {
       int firstVertex = findVertex(first);
       int secondVertex = findVertex(seconed);
       if(firstVertex !=-1 && secondVertex !=-1)
       {
           
            Vector v1 = (Vector)adjacentVertices.elementAt(firstVertex);
            Vector v2 = (Vector)adjacentVertices.elementAt(secondVertex);
            for(int i = 1 ; i <v1.size();i++)
            {
                 if(((Edge)v1.elementAt(i)).getIndex()==seconed)
                 {
                     ((Edge)v1.elementAt(i)).setWeight(weight);
                     break;
                 }
            }
            for(int i = 1 ; i <v2.size();i++)
            {
                 if(((Edge)v2.elementAt(i)).getIndex()==first)
                 {
                     ((Edge)v2.elementAt(i)).setWeight(weight);
                     break;
                 }
            }
       }
   }
   
    public int showSumOfSomeWeights(Vector indexOfVertices)
    {
        //it takes an even number of vertices to calculate sum of the weights..
        //on the edge between them
        int sum = 0;
        for(int i=0; i<indexOfVertices.size(); i++)
        {
            int indexOfVertex = findVertex((int)indexOfVertices.get(i));
            Vector v = (Vector)adjacentVertices.get(indexOfVertex);
            for(int j=1;j<v.size();j++)
            {
                if(((Edge)v.get(j)).getIndex() == (int)indexOfVertices.get(i+1))
                {
                    sum+= ((Edge)v.get(j)).getWeight();
                    break;
                }
            }
            i++;
        }
        return sum;
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
  public boolean addEdge(int f,int s)
  {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
