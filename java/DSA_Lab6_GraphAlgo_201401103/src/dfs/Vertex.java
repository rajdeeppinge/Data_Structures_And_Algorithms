package dfs;

import java.util.ArrayList;

public class Vertex {
	private char colour;
	private int key, dtime, ftime;
	private Vertex predecessor;
	private ArrayList<Vertex> adjList;
	
	public Vertex() {
		adjList = new ArrayList<Vertex>();
	}

	public char getColour() {
		return colour;
	}

	public void setColour(char colour) {
		this.colour = colour;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getDtime() {
		return dtime;
	}

	public void setDtime(int dtime) {
		this.dtime = dtime;
	}

	public int getFtime() {
		return ftime;
	}

	public void setFtime(int ftime) {
		this.ftime = ftime;
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
