package q2_HashingWithChaining;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter maximum size of hash table");
        HashTable table = new HashTable(sc.nextInt());

        boolean running = true;

        do {

            System.out.println("Press\n"
            		+	"1. insert\n"
            		+	"2. remove\n"
            		+	"3. search\n"
            		+	"4. size\n"
            		+	"0. exit\n");

            int option = sc.nextInt();            

            switch (option) {
	            case 1 : 	
	                System.out.println("Enter key and value to be inserted");
	                table.insert(sc.next(), sc.nextInt()); 	
	                break;                          	
	            case 2 :                 	
	                System.out.println("Enter key to be deleted");	
	                table.delete(sc.next()); 	
	                break;                        	
	            case 3 : 	
	                System.out.println("Enter key to search");	
	                System.out.println("Value = "+ table.search(sc.next())); 	
	                break;                                   		
	            case 4 : 	
	                System.out.println("Current size of table = "+ table.getSize() );	
	                break;         	
	            case 0 :
	            	running = false;
	            	break;
            }

            table.print();                      

        } while (running); 
        
        sc.close();
    }
}
