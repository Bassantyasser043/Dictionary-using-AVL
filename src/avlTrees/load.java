package avlTrees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class load {
    public void load(String link) throws FileNotFoundException {
        insertion nodeinsert=new insertion();
        File file = new File(link);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
            nodeinsert.root=nodeinsert.Insertion(nodeinsert.root,sc.nextLine());

    }
}
