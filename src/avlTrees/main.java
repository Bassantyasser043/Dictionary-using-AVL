package avlTrees;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class main {
	public static void main(String[] args) throws FileNotFoundException {
		String operation;
		rotations_height_print N=new rotations_height_print();
		insertion nodeinsert=new insertion();
		deletion  nodedelete=new deletion();
		load  nodeload=new load();
		batchlookup look=new batchlookup();
		Scanner input=new Scanner(System.in);
		boolean temp=false;
		while(!temp) {
			System.out.println("Enter your desired operation: (insert - delete - height - print - load - search - batchlook) or (exit) to end the program: ");
			 operation=input.next(); 
				switch(operation) {
				case "load":
					System.out.println("Enter link of the file you want to load");
					String link=input.next();
					File file = new File(link);
					Scanner sc = new Scanner(file);
					while (sc.hasNextLine())
						nodeinsert.root=nodeinsert.Insertion(nodeinsert.root,sc.nextLine());
					break;
				case "batchlook":
						System.out.println("Enter link of the file you want to look");
						int found=0;
						String batchlink=input.next();
						File fil = new File(batchlink);
						Scanner c = new Scanner(fil);
						while (c.hasNextLine()){
							N.root=N.search(nodeinsert.root,c.nextLine());
							if(nodeinsert.root != null) {
								System.out.println("YES "+N.root.element);
								found++;
							}else {
								System.out.println("NO"+N.root.element);
							}
						}
						System.out.println(found);
						break;
				case "insert":
					System.out.println("Enter the element: ");
					String item=input.next();
					nodeinsert.root=nodeinsert.Insertion(nodeinsert.root,item);
					break;

					case "height":
					System.out.println(N.Height(nodeinsert.root));
					break; 
				case "print":
				  N.printAvlTree( nodeinsert.root,  N.Height(nodeinsert.root));
				  break;
				case "delete":
					System.out.println("Enter the element that you want to delete : ");
					String itemdeleted=input.next();
					nodeinsert.root=nodedelete.Deletion( nodeinsert.root, itemdeleted);
					if(nodeinsert.root != null) {
						System.out.println("element deleted is done..");
					}else {
						System.out.println("Not Found");
					}
					break;
				case"search":
					System.out.println("Enter the element that you want to search for : ");
					String itemsearch=input.next();
					N.root=N.search(nodeinsert.root,itemsearch);
					if(N.root!=null) {
						System.out.println(""+N.root.element);
					}
					break;
				case"exit":
					System.exit(0);
//					temp=true;
//					break;
					
			    default:
			    	System.out.println("It IS Not Available. Please Enter The Right Operation: ");
			    	break;
					
				}
		
			
		}
		
			
		
	}

}
