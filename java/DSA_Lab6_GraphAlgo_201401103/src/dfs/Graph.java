package dfs;

import java.util.ArrayList;

public class Graph {
	static int time;
	
	public Graph() {
		time = 0;
	}
	
	public void DFS(ArrayList<Vertex> vertList) {
		for(int i = 0; i < vertList.size(); i++) {
			Vertex curr = vertList.get(i);
			curr.setColour('w');
			curr.setPredecessor(null);
		}
		
		for(int i = 0; i < vertList.size(); i++) {
			Vertex curr = vertList.get(i);
			if(curr.getColour() == 'w') {
				DFS_visit(curr);
			}
		}
	}
	
	public void DFS_visit(Vertex curr) { 
		System.out.print(curr.getKey() + " ");
		
		time += 1;
		curr.setDtime(time);
		curr.setColour('g');
		
		for(int i = 0; i < curr.getAdjList().size(); i++) {
			Vertex v = curr.getAdjList().get(i);
			if(v.getColour() == 'w') {
				v.setPredecessor(curr);
				DFS_visit(v);
			}
		}
		
		curr.setColour('b');
		time += 1;
		curr.setFtime(time);
	}
}
