package GraphDDrawingProject;

public class Edge 
{
    private int  index , weight;
    public Edge( int index , int weight) 
    {
        this.index = index;
        this.weight = weight;
    }
    public int getIndex() 
    {
        return index;
    }
    public int getWeight() 
    {
        return weight;
    }
    public void setWeight(int weight) 
    {
        this.weight = weight;
    }
}
