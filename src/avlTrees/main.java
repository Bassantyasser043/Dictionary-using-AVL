package avlTrees;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class main {
	public static int size=0;
	public static void main(String[] args) throws FileNotFoundException {
		String operation;
		rotations_height_print N=new rotations_height_print();
		insertion nodeinsert=new insertion();
		deletion  nodedelete=new deletion();
		Scanner input=new Scanner(System.in);
		boolean temp=false;
		while(!temp) {
			System.out.println("Enter your desired operation: (insert - size - delete - height - print - load - search - batchlook) or (exit) to end the program: ");
			 operation=input.next(); 
				switch(operation) {
				case "load":
					System.out.println("Enter link of the file you want to load");
					String link=input.next();
					File file = new File(link);
					Scanner sc = new Scanner(file);
					while (sc.hasNextLine()){
						nodeinsert.root=nodeinsert.Insertion(nodeinsert.root,sc.nextLine());
					    size++;}
					break;
				case "batchlook":
						System.out.println("Enter link of the file you want to look");
						int found=0;
						String batchlink=input.next();
						File fil = new File(batchlink);
						Scanner c = new Scanner(fil);
						while(c.hasNextLine()){
							N.root=N.search(nodeinsert.root,c.nextLine());
							if(N.root!=null) {
								System.out.println("Yes "+N.root.element);
								found++;
							}
							else System.out.println("NO ");
						}
						System.out.println(found);
					break;
				case "insert":
					System.out.println("Enter the element: ");
					String item=input.next();
					N.root=N.search(nodeinsert.root,item);
					if(N.root==null) {
						nodeinsert.root=nodeinsert.Insertion(nodeinsert.root,item);
						System.out.println("done insertion");
						size++;
					}


					break;

					case "height":
					System.out.println(N.Height(nodeinsert.root));
					break; 
				case "print":
				  N.printAvlTree( nodeinsert.root,  N.Height(nodeinsert.root));
				  break;
				case "delete":
					if(nodeinsert.root != null) {
						System.out.println("Enter the element that you want to delete : ");
						String itemdeleted=input.next();

						N.root=N.search(nodeinsert.root,itemdeleted);
						if(N.root!=null) {
							nodeinsert.root=nodedelete.Deletion( nodeinsert.root, itemdeleted);
							System.out.println("done");
							size--;
						}

					}else {
						System.out.println("Empty Tree");
					}
					break;

				case"search":
					System.out.println("Enter the element that you want to search for : ");
					String itemsearch=input.next();
					N.root=N.search(nodeinsert.root,itemsearch);
					if(N.root!=null) {
						System.out.println(N.root.element);
					}
					break;
					case"size":
						System.out.println("Size of the dictionary: "+size);
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
