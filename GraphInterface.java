
package GraphDDrawingProject;
import java.util.Vector;
public interface GraphInterface 
{
    boolean addVertex(int index);
    boolean deleteVertex(int index);
    boolean addEdge(int index1,int index2);
    boolean deleteEdge(int index1,int index2);
    void showGraph();
    Vector getConnectionsOfVetex(int index);
    void clearGraph();
}
