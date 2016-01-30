package q1_DirectAddressTable;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter maximum possible size of table");
        int maxSize = sc.nextInt();

        DirectAddressingTable table = new DirectAddressingTable(maxSize);

        boolean running = true;

        do {
            System.out.println("press\n"
            		+	"1. insert\n"
            		+	"2. remove\n"
            		+	"3. search\n"
            		+	"0. exit");

            int option = sc.nextInt();            

            switch (option) {
	            case 1 : 	
	                System.out.println("Enter int key and string value");	
	                table.insert(sc.nextInt(), sc.next()); 	
	                break;                          	
	            case 2 :                 	
	                System.out.println("Enter int key");	
	                table.delete(sc.nextInt()); 	
	                break;                        	
	            case 3 : 	
	                System.out.println("Enter int key");	
	                System.out.println("Value = "+ table.search(sc.nextInt())); 	
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
