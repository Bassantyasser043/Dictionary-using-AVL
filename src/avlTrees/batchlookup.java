package avlTrees;

import java.io.File;
import java.util.Scanner;

public class batchlookup {
    rotations_height_print N=new rotations_height_print();
    public int batch(node nodeinsert,String elem){
        int found=0;
        N.root=N.search(nodeinsert.root,elem);
            if(nodeinsert.root != null) {
                System.out.println("YES");
                found++;
            }else {
                System.out.println("NO");
            }
        return found;
    }
}
