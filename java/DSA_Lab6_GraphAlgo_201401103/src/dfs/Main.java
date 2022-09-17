package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the total number of vertices in the graph");
		int totalVertices = sc.nextInt();
		
		ArrayList<Vertex> vertList = new ArrayList<Vertex>(totalVertices);
		
		for(int i = 1; i <= totalVertices; i++) {
			Vertex v = new Vertex();
			v.setKey(i);
			vertList.add(v);
		}
		
		System.out.println("Enter total number of edges in the tree");
		int totalEdges = sc.nextInt();
		
		System.out.println("Enter the two vertices between which the edge is present. vertex nos [1, " + totalVertices + "]");
		for(int i = 0; i < totalEdges; i++) {
			Vertex u = vertList.get(sc.nextInt() - 1);
			Vertex v = vertList.get(sc.nextInt() - 1);
			
			u.getAdjList().add(v);
			v.getAdjList().add(u);
		}
		
/*		System.out.println("Enter the root vertex");
		Vertex start = vertList.get(sc.nextInt() - 1);*/
		
		Graph G = new Graph();
		G.DFS(vertList);
		
//		G.print(vertList);
		
		sc.close();
	}

}
