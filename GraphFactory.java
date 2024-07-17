package GraphDDrawingProject;
public class GraphFactory
{
    public static GraphInterface getUnWeightedGraph(String graphType)
    {
        if("DirectedGraph".equals(graphType))
            return new DirectedGraph();
        else if("UnDirectedGraph".equals(graphType))
            return new UnDirectedGraph();
        return null;
    }
    public static WeightedGraphInterface getWeightedGraph(String graphType)
    {
        if("WeightedGraph".equals(graphType))
            return new WeightedGraph();
        else if("UnDirectedWeightedGraph".equals(graphType))
            return new UnDirectedWeightedGraph();
        return null;
    }
}
