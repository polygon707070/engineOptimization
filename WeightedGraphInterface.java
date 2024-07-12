
package GraphDDrawingProject;
import java.util.Vector;
public interface WeightedGraphInterface extends GraphInterface
{
    boolean addEdge(int firstindex , int secondindex , int weight);
    void updateWeight(int index1 , int index2 , int weight);
    int showSumOfSomeWeights(Vector vertices);
}
