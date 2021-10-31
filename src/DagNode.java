public class DagNode {

        int data;
        DagNode[] input;
        DagNode[] output;

        public DagNode(int key){
            data = key;
            input = null;
            output = null;
        }
}
