package q2_HashingWithChaining;

public class HashTable {
    private int maxSize, currentSize; 
    private HashNode[] table;

    public HashTable(int maxSize) {
        currentSize = 0;
        this.maxSize = maxSize;
        table = new HashNode[maxSize];
        
        for (int i = 0; i < maxSize; i++)
            table[i] = null;
    } 

    public int getSize() {
        return currentSize;
    }

    public int search(String key) {
        int hashKey = (hash_function(key) % maxSize);
        if (table[hashKey] == null)
            return -1;
        else {
            HashNode entry = table[hashKey];
            while (entry != null && !entry.getKey().equals(key))
                entry = entry.getNext();

            if (entry == null)
                return -1;
            else
                return entry.getValue();
        }
    }

    public void insert(String key, int value) {
        int hashKey = (hash_function(key) % maxSize);
        if (table[hashKey] == null)
            table[hashKey] = new HashNode(key, value);
        else {
            HashNode entry = table[hashKey];
            while (entry.getNext() != null && !entry.getKey().equals(key))
                entry = entry.getNext();

            if (entry.getKey().equals(key))
                entry.setValue(value);

            else
                entry.setNext(new HashNode(key, value));
        }
        currentSize++;
    }

    public void delete(String key) {
        int hashKey = (hash_function(key) % maxSize);
        if (table[hashKey] != null) {
            HashNode prevEntry = null;
            HashNode entry = table[hashKey];

            while (entry.getNext() != null && !entry.getKey().equals(key)) {
                prevEntry = entry;
                entry = entry.getNext();
            }

            if (entry.getKey().equals(key)) {
                if (prevEntry == null)
                    table[hashKey] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
                currentSize--;
            }
        }
    }

    private int hash_function(String x) {
        int hashKey = x.hashCode();
        hashKey %= maxSize;
        
        if (hashKey < 0)
            hashKey += maxSize;
        
        return hashKey;
    }

    public void print() {
        for (int i = 0; i < maxSize; i++) {
            System.out.print((i + 1) + ": ");
            HashNode curr = table[i];

            while (curr != null) {
                System.out.print(curr.getValue() + " ");
                curr = curr.getNext();
            }            
        }
    }
}
