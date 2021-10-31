import org.junit.Test;
import static org.junit.Assert.*;

public class DAGTest {

    
    @Test
    public void LCATest() {

        DAG newDAG = new DAG();
        newDAG.root = new DagNode(1);
        DagNode r2 = new DagNode(2);
        DagNode r3 = new DagNode(3);
        DagNode r4 = new DagNode(4);
        DagNode r5 = new DagNode(5);
        DagNode r6 = new DagNode(6);
        DagNode r7 = new DagNode(7);
        DagNode r8 = new DagNode(8);



        DagNode[] rootoutput = new DagNode[2];
        rootoutput[0] = r2;
        rootoutput[1] = r3;

        DagNode[] r2output = new DagNode[2];
        r2output[0] = r4;
        r2output[1] = r5;
        DagNode[] r2in = new DagNode[1];
        r2in[0] = newDAG.root;

        DagNode[] r3output = new DagNode[2];
        r3output[0] = r6;
        r3output[1] = r7;
        DagNode[] r3in = new DagNode[1];
        r3in[0] = newDAG.root;

        DagNode[] r4in = new DagNode[1];
        r4in[0] = r2;

        DagNode[] r5output = new DagNode[1];
        r5output[0] = r8;
        DagNode[] r5in = new DagNode[1];
        r5in[0] = r2;

        DagNode[] r6in = new DagNode[1];
        r6in[0] = r3;

        DagNode[] r7in = new DagNode[1];
        r7in[0] = r3;

        DagNode[] r8in = new DagNode[1];
        r8in[0] = r5;

        newDAG.addEdgesOutput(newDAG.root, rootoutput);
        newDAG.addEdgesOutput(r2, r2output);
        newDAG.addEdgesInput(r2, r2in);
        newDAG.addEdgesOutput(r3, r3output);
        newDAG.addEdgesInput(r3, r3in);
        newDAG.addEdgesInput(r4, r4in);
        newDAG.addEdgesOutput(r5, r5output);
        newDAG.addEdgesInput(r5, r5in);
        newDAG.addEdgesInput(r6, r6in);
        newDAG.addEdgesInput(r7, r7in);
        newDAG.addEdgesInput(r8, r8in);

       assertEquals("", 2, newDAG.findLCAList(newDAG.root, r8, r4));
        assertEquals("", 1, newDAG.findLCAList(newDAG.root, r8, newDAG.root));
        assertEquals("", 3, newDAG.findLCAList(newDAG.root, r7, r3));
    }

    @Test
    public void LLLCATest() {
        DAG newDAG = new DAG();
        newDAG.root = new DagNode(1);
        DagNode r2 = new DagNode(2);
        DagNode r3 = new DagNode(3);
        DagNode r4 = new DagNode(4);
        DagNode r5 = new DagNode(5);
        DagNode r6 = new DagNode(6);
        DagNode r7 = new DagNode(7);
        DagNode r8 = new DagNode(8);



        DagNode[] rootoutput = new DagNode[2];
        rootoutput[0] = r2;
        rootoutput[1] = r3;

        DagNode[] r2output = new DagNode[2];
        r2output[0] = r4;
        r2output[1] = r5;
        DagNode[] r2in = new DagNode[1];
        r2in[0] = newDAG.root;

        DagNode[] r3in = new DagNode[1];
        r3in[0] = newDAG.root;


        DagNode[] r4output = new DagNode[2];
        r4output[0] = r7;
        r4output[1] = r6;
        DagNode[] r4in = new DagNode[1];
        r4in[0] = r2;

        DagNode[] r5output = new DagNode[1];
        r5output[0] = r8;
        DagNode[] r5in = new DagNode[1];
        r5in[0] = r2;

        DagNode[] r6in = new DagNode[1];
        r6in[0] = r4;

        DagNode[] r7in = new DagNode[1];
        r7in[0] = r4;

        DagNode[] r8in = new DagNode[1];
        r8in[0] = r5;

        newDAG.addEdgesOutput(newDAG.root, rootoutput);
        newDAG.addEdgesOutput(r2, r2output);
        newDAG.addEdgesInput(r2, r2in);
        newDAG.addEdgesInput(r3, r3in);
        newDAG.addEdgesInput(r4, r4in);
        newDAG.addEdgesOutput(r4, r4output);
        newDAG.addEdgesOutput(r5, r5output);
        newDAG.addEdgesInput(r5, r5in);
        newDAG.addEdgesInput(r6, r6in);
        newDAG.addEdgesInput(r7, r7in);
        newDAG.addEdgesInput(r8, r8in);

        assertEquals("", 1, newDAG.findLCAList(newDAG.root, r8,newDAG.root));
        assertEquals("", 1, newDAG.findLCAList(newDAG.root, r7, r3));
    }


}