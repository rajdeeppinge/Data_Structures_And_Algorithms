package q1_DirectAddressTable;

class DirectAddressingTable {
	private String[] arr ;

    public DirectAddressingTable(int maxSize) {
        arr = new String[maxSize + 1];
    }

    public void insert(int k, String d) {
        arr[k] = d;
    }

   public void delete(int k) {
        arr[k] = null;
    }

    public String search(int k) {
        return arr[k];
    }

    public void print() {
        System.out.println("Direct Addressing Table:");
        int size = arr.length;
        for (int i = 0; i < size; i++)
            if (arr[i] != null)
                System.out.println(i +" "+ arr[i]);
        System.out.println();        
    }
}