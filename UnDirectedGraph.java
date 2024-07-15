/*This class works properly */

package GraphDDrawingProject;

import java.util.Collections;
import java.util.Vector;

public class UnDirectedGraph implements GraphInterface
{
    private Vector adjacentVertices;
   
    public UnDirectedGraph()
    {
        adjacentVertices = new Vector();
    }
    
    public void setGraph(Vector adjacentVertices) 
    {
        this.adjacentVertices = adjacentVertices;
    }
    private int findVertex(int index)
    {
        for(int i=0;i<adjacentVertices.size();i++)
        {
            Vector v = (Vector)adjacentVertices.elementAt(i);
            Vertex vtx = (Vertex)v.elementAt(0);
            if(vtx.getIndex() == index)
                return i;
        }
        return -1;
    }
    @Override
    public boolean addVertex(int index) 
    {
        Vector VectorOfVertex = new Vector();
        if(findVertex(index) != -1)
        {
            System.out.println("Vertex does exist");
            return false;
        }   
        Vertex vertex = new Vertex(index);
        VectorOfVertex.add(vertex);
        adjacentVertices.add(VectorOfVertex);
        return  true;
    }
    
    @Override
    public boolean deleteVertex(int index) 
    {
        int indexOfVertex = findVertex(index);
        if(indexOfVertex == -1)
            return false;
        Vector vectorOfVertex = (Vector)adjacentVertices.elementAt(indexOfVertex);
        for(int i=1;i<vectorOfVertex.size();i++)
        {
            Vertex vertex = (Vertex)vectorOfVertex.elementAt(i);
            int indexOfConnnectedVertex = vertex.getIndex();
            deleteEdge(indexOfConnnectedVertex,index);
            i--;
        }
        adjacentVertices.removeElementAt(indexOfVertex);
        return  true;
    }
    @Override
    public boolean addEdge(int firstIndex, int secondIndex) 
    {
        int indexOfFirstVertex = findVertex(firstIndex);
        int indexOfSecondVertex = findVertex(secondIndex);
        if(indexOfFirstVertex !=-1 && indexOfSecondVertex !=-1)
        {
            Vector vec1 = (Vector)adjacentVertices.elementAt(indexOfFirstVertex);
            Vector vec2 = (Vector)adjacentVertices.elementAt(indexOfSecondVertex);
            for(int i=1;i<vec1.size();i++)
            {
                Vertex vertex = (Vertex)vec1.elementAt(i);
                if(vertex.getIndex() == secondIndex)
                    return false;
            }
            Vertex vertex = new Vertex(secondIndex);
            vec1.add(vertex);
            vertex = new Vertex(firstIndex);
            vec2.add(vertex);
            adjacentVertices.set(indexOfFirstVertex, vec1);
            adjacentVertices.set(indexOfSecondVertex, vec2);
            return  true;
        }        
        return false;
    }

    @Override
    public boolean deleteEdge(int firstIndex, int secondIndex)
    {
        int indexOfFirstVertex = findVertex(firstIndex);
        int indexOfSecondVertex = findVertex(secondIndex);
        boolean b1=false ,b2=false;
        if(indexOfFirstVertex !=-1 && indexOfSecondVertex !=-1)
        {
            Vector vec1 = (Vector)adjacentVertices.elementAt(indexOfFirstVertex);
            Vector vec2 = (Vector)adjacentVertices.elementAt(indexOfSecondVertex);
            for(int i=1;i<vec1.size();i++)
            {
                Vertex vertex = (Vertex)vec1.elementAt(i);
                if(vertex.getIndex() == secondIndex)
                {
                    vec1.removeElementAt(i);
                    adjacentVertices.set(indexOfFirstVertex, vec1);
                    b1=true;
                    break;
                }
            }
            for(int i=1;i<vec2.size();i++)
            {
                Vertex vertex = (Vertex)vec2.elementAt(i);
                if(vertex.getIndex() == firstIndex)
                {
                    vec2.removeElementAt(i);
                    adjacentVertices.set(indexOfSecondVertex, vec2);
                    b2=true;
                    break;
                }
            }
            if(b1&&b2)
                return true;
            return  false;
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
            System.out.println("arrayOfGraphVertices sort = "+GraphDDrawingProject.arrayInputTAble[nodeI][nodeJ]);

            //System.out.println(vertex.getIndex()+"   "+v.getIndex());
            }
        }
        
    }
    @Override
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
