
package GraphDDrawingProject;
import java.util.*;
import java.util.Vector;
public class CyclicGraph implements GraphInterface
{
    LinkedList <Edge> adjacentVertices[] = new LinkedList [10000];
    Vertex ver[] = new Vertex[10000];
    int visited[] = new int[10000];
    boolean isCycle;
    
    @Override
    public boolean addVertex(int index)
    {
        Vertex v = new Vertex(index);
        ver[index]=v;
        adjacentVertices[index] = new LinkedList();
        return true;
    }
    
    @Override
    public boolean deleteVertex(int index)
    {
        adjacentVertices[index].remove();
        return true;
    }

    public boolean addEdge(int firstVertex , int secondVertex , int weight)
    {
        adjacentVertices[firstVertex].add(new Edge(secondVertex,weight));
        return false;
    }
     
    @Override
    public boolean deleteEdge(int firstVertex,int secondVertex)
    {
        Edge eg = new Edge(secondVertex,6);
        for (int i=0; i<adjacentVertices[firstVertex].size(); i++)
        {
            if (adjacentVertices[firstVertex].get(i).getIndex()== eg.getIndex())
            {
                adjacentVertices[firstVertex].remove(i); 
                return true;
            }
        }
        return false;
    }
    
    public void updateWeight(int index1 , int index2 , int weight)
    {
        for (int i=0; i<adjacentVertices[index1].size(); i++)
        {
            if (adjacentVertices[index1].get(i).getIndex()== index2) adjacentVertices[index1].get(i).setWeight(weight);
        }
    }
    
    public int showSumOfSomeWeightsint(int vertex)
    {
        int sum=0;
        for (int i=0; i<adjacentVertices[vertex].size(); i++)
        {
            sum += adjacentVertices[vertex].get(i).getWeight();
        }
        return sum;
    }
    
    public int showSumOfSomeWeightsint(List<Integer> lst)
    {
        int sum=0;
        for (int i=0; i<lst.size()-1; i++)
        {
            int firstVertex = lst.get(i) , secondVertex=lst.get(i+1);
            for (int j=0; j<adjacentVertices[firstVertex].size(); j++)
            {
                if (adjacentVertices[firstVertex].get(j).getIndex()== secondVertex) sum += adjacentVertices[firstVertex].get(j).getWeight();
            }
        }
        return sum;
    }
    @Override
    public void showGraph()
    {
        Arrays.fill(visited , 0);
        for (int i=1; i<10000; i++)
        {
            if (adjacentVertices[i] != null && visited[i]==0) dfs2(i);
        }
    }
    
    @Override
    public void clearGraph()
    {
        for (int i=0; i<10000; i++)
        {
            if (adjacentVertices[i] != null) adjacentVertices[i].clear();
        }
    }
    
    
    public void dfs2(int node)
    {
        visited[node]=1;
        System.out.println(node);
        for (int i=0; i<adjacentVertices[node].size(); i++)
        {
            int child = (int)adjacentVertices[node].get(i).getIndex();
            int cst = (int)adjacentVertices[node].get(i).getWeight();
          
            if (visited[child]==0) 
            {
                dfs2(child);
            }
        }
    }
    
    public boolean detectCycle()
    {
        Arrays.fill(visited , 0);
        for (int i=1; i<10; i++)
        {
           if (adjacentVertices[i] != null && visited[i]==0)
           {
               if (dfs(i)==true) 
                   return true;
           }
        }
        return false;
    }
    
    public boolean dfs(int node)
    {
         visited[node]=1;
         for (int i=0; i<adjacentVertices[node].size(); i++)
         {
             int ch = (int)adjacentVertices[node].get(i).getIndex();
             int cst = (int)adjacentVertices[node].get(i).getWeight();
             if (visited[ch]==0) 
             {
                return false || dfs(ch);
             }
             else if (visited[ch]==1) 
                 return true;
          }
          visited[node]=2;
          return false;
      }

 

    @Override
    public boolean addEdge(int index1, int index2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector getConnectionsOfVetex(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
