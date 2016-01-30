package bfs;

import java.util.ArrayList;

public class Vertex {
	private char colour;
	private int key, distance;
	private Vertex predecessor;
	private ArrayList<Vertex> adjList;
	
	public Vertex() {
		adjList = new ArrayList<Vertex>();
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public char getColour() {
		return colour;
	}

	public void setColour(char colour) {
		this.colour = colour;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public ArrayList<Vertex> getAdjList() {
		return adjList;
	}

	public void setAdjList(ArrayList<Vertex> adjList) {
		this.adjList = adjList;
	}
	
}
