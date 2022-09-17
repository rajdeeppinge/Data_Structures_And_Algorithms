package bfs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	private Vertex start;
	
	public Graph(Vertex start) {
		this.start = start;
	}
	
	public void BFS(ArrayList<Vertex> vertList) {
		for(int i = 0; i < vertList.size(); i++) {
			Vertex curr = vertList.get(i);
			curr.setColour('w');
			curr.setDistance(Integer.MAX_VALUE);
			curr.setPredecessor(null);
		}
		
		start.setColour('g');
		start.setDistance(0);
		start.setPredecessor(null);
		
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		Vertex curr = start;
		
		if(curr != null) {
			queue.addLast(curr);
		}
		
		while(!queue.isEmpty()) {
			curr = queue.removeFirst();
			for(int i = 0; i < curr.getAdjList().size(); i++) {
				Vertex v = curr.getAdjList().get(i);
				if(v.getColour() == 'w') {
					v.setColour('g');
					v.setDistance(curr.getDistance() + 1);
					v.setPredecessor(curr);
					queue.addLast(v);
				}
			}
			
			curr.setColour('b');
		}
	}
	
	public void print(ArrayList<Vertex> vertList) {
		for(int i = 0; i < vertList.size(); i++) {
			Vertex curr = vertList.get(i);
			System.out.print(curr.getKey() + ": ");
			print_path(curr);
			System.out.println();
		}
	}
	
	public void print_path(Vertex v) {
		if(start == v) {
			System.out.print(start.getKey() + " ");
		}
		
		else if(v.getPredecessor() == null) {
			System.out.print("No path from start to v");
		}
		
		else {
			print_path(v.getPredecessor());
			System.out.print(v.getKey() + " ");
		}
	}
}
