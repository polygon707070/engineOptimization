/*Notes in:
1-method delete vertex 
2-method delete edge 
*/
package GraphDDrawingProject;

import java.util.Collections;
import java.util.Vector;

public class WeightedGraph implements WeightedGraphInterface
{
    Vector adjacentVertices;  
    public WeightedGraph()
    {
        adjacentVertices = new Vector();
    }    
    public void setGraph(Vector adjacentVertices)
    {
        this.adjacentVertices = adjacentVertices;
    }
    public boolean addVertex(int index)
    {
        if(findVertex(index)==-1)
        {
            Vertex v = new Vertex(index);
            Vector tmp = new Vector();
            tmp.add(v);
            adjacentVertices.add(tmp);
            return true;
        }
        return false;
    }
    private int findVertex(int index)
    {
        for(int i=0; i<adjacentVertices.size(); i++)
        {
            Vector tmp = (Vector)adjacentVertices.elementAt(i); 
            Vertex vertex = (Vertex)tmp.elementAt(0);
            if(vertex.getIndex() == index)
                return i;
        }
        return -1;
    }
    public boolean deleteVertex(int index)
    {
        boolean ret=false;
        for(int i=0; i<adjacentVertices.size(); i++)
        {
            Vector tmp = (Vector)adjacentVertices.elementAt(i);
            Vertex v = (Vertex)tmp.elementAt(0);
            if(v.getIndex() == index)
            {
                adjacentVertices.remove(i);
                i--;
                ret= true;
            }
            else
            {
                boolean removed = false;
                for(int j=1; j<tmp.size(); j++)
                {
                    Edge wc = (Edge)tmp.elementAt(j);
                    if(wc.getIndex() == index)
                    {
                        tmp.remove(j);
                        j--;
                        removed = true;
                        
                    }
                }
                if(removed)
                {
                    adjacentVertices.remove(i);
                    adjacentVertices.add(tmp);
                    i--;
                }//Why is this if condition exists ? 
            }
        }
       return ret;
    }    
    public boolean addEdge(int firstIndex , int secondIndex , int weight)
    {
        int indexOfFirstVertex = findVertex(firstIndex);
        int indexOfSecondVertex = findVertex(secondIndex);
        if(indexOfFirstVertex !=-1 && indexOfSecondVertex !=-1)
        {
            Vector tmp = (Vector)adjacentVertices.elementAt(indexOfFirstVertex);
            for(int i=1;i<tmp.size();i++)
            {
                Edge edge = (Edge)tmp.elementAt(i);
                if(edge.getIndex() == secondIndex)
                    return false;
            }
            tmp.add(new Edge(secondIndex,weight));
            adjacentVertices.set(indexOfFirstVertex, tmp);
            return true;
        }
        return false;
    }
    public boolean deleteEdge(int index1 , int index2)
    {
        boolean ret=false;
        for(int i=0; i<adjacentVertices.size(); i++)
        {
            Vector tmp = (Vector)adjacentVertices.elementAt(i);
            Vertex v = (Vertex)tmp.elementAt(0);
            if(v.getIndex() == index1)
            {
                boolean removed = false;
                for(int j=1; j<tmp.size(); j++)
                {
                    if(((Edge)tmp.elementAt(j)).getIndex() == index2)
                        tmp.remove(j);
                }
                if(removed)
                {
                    adjacentVertices.remove(i);
                    adjacentVertices.add(tmp);
                    i--;
                    ret= true;
           
                }
            }
        }
         return ret;
    }
    
  
    public void  showGraph()
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

    public void updateWeight(int index1 , int index2 , int weight)
    {
        int indexOfVertex = findVertex(index1);
        Vector tmp = (Vector)adjacentVertices.elementAt(indexOfVertex);
        for(int i=1; i<tmp.size(); i++)
        {
            if(((Edge)tmp.elementAt(i)).getIndex()==index2)
            {
                ((Edge)tmp.elementAt(i)).setWeight(weight);
                adjacentVertices.set(indexOfVertex, tmp);
                break;
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

    @Override
    public void clearGraph()
    {
        adjacentVertices.clear();
    }

    @Override
    public boolean addEdge(int firstEdge, int secondEdge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

