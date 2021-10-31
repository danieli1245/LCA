import java.util.*;

public class DAG {

    DagNode root;

    public void addEdgesInput(DagNode x, DagNode[] inputArray){
        x.input = inputArray;
    }
    public void addEdgesOutput(DagNode x, DagNode[] outputArray){
        x.output = outputArray;
    }
    public int findLCAList(DagNode root, DagNode value1, DagNode value2){
        if(root == null){
            return -1;
        }
        if((root.data == value1.data) || (root.data == value2.data)){
            return root.data;
        }
        if(value1.data == value2.data){
            return value1.data;
        }
        ArrayList<Integer> LCAList = new ArrayList<>();
        int i = 0;
        while(i < value1.input.length){
            int j = 0;
            while(j < value2.input.length){
                if(value1.input[i].data == value2.input[j].data){
                    LCAList.add(value1.input[i].data);
                    j++;
                }
                else{
                    j++;
                }
            }
            i++;
        }
        if(LCAList.size() == 0){
            if(value1.data > value2.data){
                LCAList.add(findLCAList(root, value1.input[0], value2));
            }
            else{
                LCAList.add(findLCAList(root, value1, value2.input[0]));
            }
        }

        return Collections.max(LCAList);
    }

}


