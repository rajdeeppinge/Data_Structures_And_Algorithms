package advancedQ5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		JobManagement job = new JobManagement();
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add a job\n"
					+	"2: To finish the job currently working on\n"
					+	"3: To print the jobs in queue\n"
					+	"0: To Exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter the priority of the job to be added");
					int priority = sc.nextInt();
					job.insertJob(priority);
				case 3:
					job.printJobList();
					break;
				case 2:
					System.out.println("The job currently working on has been finished");
					System.out.println("The job that has been taken up has priority: " + job.finishJob());
					break;
				case 0:
					process = false;
					break;
				default:
					break;
			}
		}
		while(process);
		
		sc.close();
	}
}