package q2_HashingWithChaining;

public class HashNode {
    private String key;
    private int value;
    private HashNode next;
    
    HashNode(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public HashNode getNext() {
		return next;
	}

	public void setNext(HashNode next) {
		this.next = next;
	}	
}
