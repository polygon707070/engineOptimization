package GraphDDrawingProject;
import java.awt.Color;
import java.util.Vector;
import java.lang.*;
import java.util.List;
import java.util.*;
import javax.swing.JOptionPane;
public class GraphDDrawingProject extends javax.swing.JFrame 
{
WeightedGraphInterface weightedGraph;
GraphInterface unWeightedGraph;
public  static List <String> arrayOfGraphVertices ;
public static List<String> tempArrayInputTable;
public  static  int  arrayInputTAble[][] ;
public static int typeOfGraph=0;
public  List<Color>color =new ArrayList<>() ;
public List<Color>sortedColor;
Vector vecAccessVetexInComboBoxes= new Vector();
Vector edgesToCalcWeights = null;
int counterOfEdgesToCalcWeight = 0;
public  List<String> getEdgeChangeColor=new ArrayList<>() ;
public static int positionOfColoredEdge[][];
//Vector bigVector=new Vector();
    public GraphDDrawingProject()
    {
        initComponents();  
        this.setVisible(true);
        if(weightedGraph==null&&unWeightedGraph==null)
        {
            jTextField1.setEnabled(false);
        }
        jComboBox4.setEnabled(true);
        jComboBox5.setEnabled(false);
        jComboBox6.setEnabled(false);
        jComboBox8.setEnabled(false);
        jComboBox9.setEnabled(false);
        jComboBox10.setEnabled(false);
        jComboBox11.setEnabled(false);
        jComboBox12.setEnabled(false);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        jLabel1.setEnabled(false);
        jLabel6.setEnabled(false);
        jLabel7.setEnabled(false);
        jLabel8.setEnabled(false);
        jLabel9.setEnabled(false);
        jLabel10.setEnabled(false);
        jLabel11.setEnabled(false);
        jLabel12.setEnabled(false);
        jLabel13.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jComboBox8 = new javax.swing.JComboBox();
        jButton7 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox9 = new javax.swing.JComboBox();
        jComboBox10 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox();
        jComboBox12 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose type of graph", "UnWeighted Directed Graph", "UnWeighted UnDirected Graph", "Weighted Directed Graph", "Wieghted UnDirected Graph" }));
        jComboBox1.setToolTipText("");

        jButton1.setText("Add Vertex");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Add Name Of Vertex");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));

        jLabel3.setText("Edge");

        jLabel4.setText("to");

        jLabel5.setText("Weight");

        jButton2.setText("Add Edge");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Show Graph");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Apply");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Delete ", "Delete Edge", "Delete Vertex" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Name of Vetex");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));

        jLabel6.setText("Edge between");

        jLabel7.setText("to");

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));

        jButton7.setText("Get Weights");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No_color", "red", "BLUE", "cyan", "green", "pink", "black", "LIGHT_GRAY", "magenta", "orange", "white", "yellow", "darkGray" }));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));

        jLabel8.setText("to");

        jLabel9.setText("Choose Some edges to calculate weights");

        jButton8.setText("add");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);

        jLabel10.setText("Edge counter");

        jLabel11.setText("Update Weight");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vertex" }));

        jLabel12.setText("to");

        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel13.setText("Enter New weight");

        jButton6.setText("Clear Graph");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120)))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(20, 20, 20)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel4)
                                        .addGap(31, 31, 31)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(13, 13, 13)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)))
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public Color indexColor(String color){
        String []colors={"No color","red","BLUE","cyan","green","pink","black",
                                "LIGHT_GRAY","magenta","orange","white",
                                "yellow","darkGray"} ;
        for(int i=1 ;i<colors.length;i++)
        {
            if(color.equals(colors[i]))
                return chooseColor(i);
        }
        return null;
    }
    
public  Color chooseColor(int  i)
{
         Color[]color = 
         {
                Color.red,
                Color.BLUE,
                Color.cyan,
                Color.green,
                Color.pink,
                Color.black,
                Color.LIGHT_GRAY,
                Color.magenta,
                Color.orange,
                Color.white,
                Color.yellow,
                Color.darkGray
        }; 
        
         return color[i-1];
     }
public void addEdgeOnArrayOfDrawingEdges(int weight)
{
       int nodeI=0,nodeJ=0;
            //System.out.println(arrayOfGraphVertices.size());
            for(int i=0;i<arrayOfGraphVertices.size();i++)
            {
                if(jComboBox2.getSelectedItem().equals((String)arrayOfGraphVertices.get(i)))
                {
                    nodeI=i;
                    System.out.println("i = "+nodeI);
                }  
                else if(jComboBox3.getSelectedItem().equals((String)arrayOfGraphVertices.get(i)))
                {
                    nodeJ=i;
                    System.out.println("j = "+nodeJ);
                }
                    
                else
                    arrayInputTAble[i][i]=0;
                if(nodeI!=0&&nodeJ!=0)
                    break;
            }
            arrayInputTAble[nodeI][nodeJ]=weight;
            System.out.println(arrayInputTAble[nodeI][nodeJ]);
         
}
public void accessVetexInComboBoxes(String vertex){
    jComboBox2.addItem(vertex);
    jComboBox3.addItem(vertex);
    jComboBox5.addItem(vertex);
    jComboBox8.addItem(vertex);
    jComboBox9.addItem(vertex);
    jComboBox11.addItem(vertex);
}

public void deleteVetexInComboBoxes(String vertex){
    jComboBox2.removeItem(vertex);
    jComboBox3.removeItem(vertex);
    jComboBox5.removeItem(vertex);
    jComboBox8.removeItem(vertex);
    jComboBox9.removeItem(vertex);
    jComboBox11.removeItem(vertex);
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
                if(weightedGraph != null)
                {
                    if(weightedGraph.addVertex(Integer.parseInt(jTextField1.getText())))
                    {
                        accessVetexInComboBoxes(jTextField1.getText());   
                        jTextField1.setText("");
                    }
                    else 
                        JOptionPane.showMessageDialog(this,"aready Exist");
                }
                    
                else if (unWeightedGraph != null)
                {
                    if(unWeightedGraph.addVertex(Integer.parseInt(jTextField1.getText())))
                    {
                        accessVetexInComboBoxes(jTextField1.getText()); 
                         jTextField1.setText("");
                    }
                    else 
                        JOptionPane.showMessageDialog(this,"aready Exist");
                }    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"error");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            color.add(indexColor((String)jComboBox7.getSelectedItem()));
            if(jComboBox2.getSelectedItem()=="Vertex"||jComboBox3.getSelectedItem()=="Vertex"||(jComboBox2.getSelectedItem()==jComboBox3.getSelectedItem()))
            {
                JOptionPane.showMessageDialog(this,"Select Anthor node");
            }
            else
            {
                int firstIndex = Integer.parseInt((String) jComboBox2.getSelectedItem());
                int secondIndex = Integer.parseInt((String)jComboBox3.getSelectedItem());
                int weight=1 ;
                if(weightedGraph != null)
                {
                    weight = Integer.parseInt(jTextField2.getText());
                    if(!weightedGraph.addEdge(firstIndex,secondIndex,weight))
                        JOptionPane.showMessageDialog(this, "Edge exists");
                    jTextField2.setText("");
                }
                else if (unWeightedGraph != null)
                {
                    unWeightedGraph.addEdge(firstIndex, secondIndex);
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
//Show Graph
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        List<Color>sortedColor=new  ArrayList<>();
        arrayOfGraphVertices = new ArrayList<>();
        tempArrayInputTable  =new ArrayList<>();
        tempArrayInputTable.clear();
        arrayOfGraphVertices.clear();
        sortedColor.clear();
        if(typeOfGraph==1||typeOfGraph==2)
            weightedGraph.showGraph();
        else
            unWeightedGraph.showGraph();
        //list to array
        String[] nodeName=new String[arrayOfGraphVertices.size()];
        for(int i=0;i<arrayOfGraphVertices.size();i++)
            nodeName[i]=String.valueOf((String)arrayOfGraphVertices.get(i));
       System.out.println( "---"+ getEdgeChangeColor.size());
        for(int i=0;i<getEdgeChangeColor.size();i++)
            System.out.println(" Get  = "+getEdgeChangeColor.get(i));
        positionOfColoredEdge =new int[arrayOfGraphVertices.size()][arrayOfGraphVertices.size()];
        int ii=0,jj=0;
        for(int i=0;i<getEdgeChangeColor.size();i+=2)
        {  
            ii=arrayOfGraphVertices.indexOf(getEdgeChangeColor.get(i));
            jj=arrayOfGraphVertices.indexOf(getEdgeChangeColor.get(i+1));
            positionOfColoredEdge[ii][jj]=1;
        }
        for(int i=0;i<getEdgeChangeColor.size();i++)
        {
            for(int j=0;j<getEdgeChangeColor.size();j++)
            {
                if(positionOfColoredEdge[i][j]!=1)
                    positionOfColoredEdge[i][j]=0;
            }
        }
//        for(int i=0;i<arrayOfGraphVertices.size();i++)
//        {
//            int indexColor =tempArrayInputTable.indexOf((String)arrayOfGraphVertices.get(i));
//            sortedColor.add((Color)color.get(indexColor));
//            System.out.println(" color = "+sortedColor.get(i));
//        }
         getEdgeChangeColor.clear();
        new ShowGraphFrame(arrayInputTAble ,nodeName,arrayOfGraphVertices.size());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(jComboBox1.getSelectedItem().equals("Weighted Directed Graph"))
        {
            weightedGraph = GraphFactory.getWeightedGraph("WeightedGraph");
            typeOfGraph=1;
        }  
        else if (jComboBox1.getSelectedItem().equals("Wieghted UnDirected Graph"))
        {
            weightedGraph = GraphFactory.getWeightedGraph("UnDirectedWeightedGraph");
            typeOfGraph=2;
        }     
        else if (jComboBox1.getSelectedItem().equals("UnWeighted Directed Graph"))
        {
            unWeightedGraph = GraphFactory.getUnWeightedGraph("DirectedGraph");
            typeOfGraph=3;
        } 
        else if (jComboBox1.getSelectedItem().equals("UnWeighted UnDirected Graph"))
        {
            unWeightedGraph = GraphFactory.getUnWeightedGraph("UnDirectedGraph");
            typeOfGraph=4;
        }
        if(weightedGraph!=null||unWeightedGraph!=null)
        {
            jTextField1.setEnabled(true);
            jButton4.setVisible(false);
            jComboBox1.setEnabled(false);
        }      
        else
        {
            JOptionPane.showMessageDialog(this,"Select type first ");
        }    
        if(unWeightedGraph != null)
        {
            jTextField2.setEnabled(false);
            jLabel5.setEnabled(false);
        }
        else if (weightedGraph != null)
        {
            edgesToCalcWeights = new Vector();
            jComboBox9.setEnabled(true);
            jComboBox10.setEnabled(true);
            jComboBox11.setEnabled(true);
            jComboBox12.setEnabled(true);
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jLabel8.setEnabled(true);
            jLabel9.setEnabled(true);
            jLabel10.setEnabled(true);
            jLabel11.setEnabled(true);
            jLabel12.setEnabled(true);
            jLabel13.setEnabled(true);
            jTextField3.setEnabled(true);
            jTextField4.setEnabled(true);
            jTextField5.setEnabled(true);
            jTextField3.setText(String.valueOf(counterOfEdgesToCalcWeight));
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    //check combo box for delete
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try
        {
            if(jComboBox4.getSelectedItem()=="Delete Vertex")
            {
                    if(weightedGraph != null)
                   {
                       int deletedVertex=Integer.valueOf((String)jComboBox8.getSelectedItem());
                       weightedGraph.deleteVertex(deletedVertex);
                       deleteVetexInComboBoxes(String.valueOf(deletedVertex));
                   }
                   else if (unWeightedGraph != null)
                   {
                       int deletedVertex = Integer.valueOf((String)jComboBox8.getSelectedItem());
                       unWeightedGraph.deleteVertex(deletedVertex);
                       deleteVetexInComboBoxes(String.valueOf(deletedVertex));
                   }
            }
            else if (jComboBox4.getSelectedItem()=="Delete Edge")
            {
                if(weightedGraph!=null)
                {
                    int firstDeletedEdge= Integer.valueOf((String)jComboBox5.getSelectedItem());
                    int secondDeletedEdge= Integer.valueOf((int)jComboBox6.getSelectedItem());
                    weightedGraph.deleteEdge(firstDeletedEdge,secondDeletedEdge);
                }
                else if(unWeightedGraph!=null)
                {
                    int secondDeletedEdge= Integer.valueOf((int)jComboBox6.getSelectedItem());
                    int firstDeletedEdge= Integer.valueOf((String)jComboBox5.getSelectedItem());
                    unWeightedGraph.deleteEdge(firstDeletedEdge,secondDeletedEdge);
                }
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error");
        }
    }//GEN-LAST:event_jButton5ActionPerformed
//Get Weights
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //getEdgeChangeColor = new ArrayList<>(); 
        try
        {
            int sumOfWeights;
            if(weightedGraph != null)
            {
               
                sumOfWeights = weightedGraph.showSumOfSomeWeights(edgesToCalcWeights);
                jTextField4.setText(String.valueOf(sumOfWeights));
                counterOfEdgesToCalcWeight = 0;
                jTextField3.setText(String.valueOf(counterOfEdgesToCalcWeight));
                edgesToCalcWeights.clear();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
         if(jComboBox4.getSelectedItem()=="Delete Vertex")
        {
            jLabel1.setEnabled(true);
            jComboBox8.setEnabled(true);   
            jComboBox5.setEnabled(false);
            jComboBox6.setEnabled(false);
            jLabel6.setEnabled(false);
            jLabel7.setEnabled(false);
        }
        else if(jComboBox4.getSelectedItem()=="Delete Edge")
        {
            jLabel1.setEnabled(false);
            jComboBox8.setEnabled(false); 
            jComboBox5.setEnabled(true);
            jComboBox6.setEnabled(true);
            jLabel6.setEnabled(true);
            jLabel7.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
       try
       {
            jComboBox6.removeAllItems();
            if(weightedGraph!=null)
            {
                Vector vertices=weightedGraph.getConnectionsOfVetex(Integer.parseInt((String)jComboBox5.getSelectedItem()));
                for(int i=1;i<vertices.size();i++)
                {
                    jComboBox6.addItem(((Edge)vertices.elementAt(i)).getIndex());
                }
            }
            else if(unWeightedGraph!=null)
            {
                Vector vertices=unWeightedGraph.getConnectionsOfVetex(Integer.parseInt((String)jComboBox5.getSelectedItem()));
                System.out.println("size: "+vertices.size());
                for(int i=1;i<vertices.size();i++)
                {
                    jComboBox6.addItem(((Vertex)vertices.elementAt(i)).getIndex());
                }
            }
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(this, "Error");
       }
    }//GEN-LAST:event_jComboBox5ActionPerformed
//add weights
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try
        {   int first = Integer.valueOf((String)jComboBox9.getSelectedItem());
            int second = Integer.valueOf((int)jComboBox10.getSelectedItem());
            edgesToCalcWeights.add(first);
            edgesToCalcWeights.add(second);
            String f =((String)jComboBox9.getSelectedItem());
            String s= String.valueOf((int)jComboBox10.getSelectedItem());
            getEdgeChangeColor.add(f);
            getEdgeChangeColor.add(s);
            counterOfEdgesToCalcWeight++;
            jTextField3.setText(String.valueOf(counterOfEdgesToCalcWeight));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error");
        }     
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        try
        {
            jComboBox10.removeAllItems();
            Vector vertices=weightedGraph.getConnectionsOfVetex((Integer)jComboBox9.getSelectedIndex());
            for(int i=1;i<vertices.size();i++)
            {
                jComboBox10.addItem(((Edge)vertices.elementAt(i)).getIndex());
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "error");
        }
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        try
        {
            jComboBox12.removeAllItems();
            Vector vertices=weightedGraph.getConnectionsOfVetex(Integer.parseInt((String)jComboBox11.getSelectedItem()));
            for(int i=1;i<vertices.size();i++)
            {
                jComboBox12.addItem(((Edge)vertices.elementAt(i)).getIndex());
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try
        {
            int first = Integer.parseInt((String)jComboBox11.getSelectedItem());
            int second = Integer.parseInt(String.valueOf(jComboBox12.getSelectedItem()));
            int weight = Integer.parseInt((String)jTextField5.getText());
            weightedGraph.updateWeight(first, second, weight);
            jTextField5.setText("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(weightedGraph != null)
        weightedGraph.clearGraph();
        else if (unWeightedGraph != null)
        unWeightedGraph.clearGraph();
        int size = jComboBox2.getItemCount();
        for(int i=1; i<size ;i++)
        {
            deleteVetexInComboBoxes((String)jComboBox2.getItemAt(i));
            size--;
            i--;
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphDDrawingProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphDDrawingProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphDDrawingProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphDDrawingProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphDDrawingProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
