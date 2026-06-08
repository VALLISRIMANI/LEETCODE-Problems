class MyHashSet {
    private final int SIZE = 1000;
    private List<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int idx = hash(key);
        if (!buckets[idx].contains(key)) {
            buckets[idx].add(key);
        }
    }
    
    public void remove(int key) {
        int idx = hash(key);
        buckets[idx].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int idx = hash(key);
        return buckets[idx].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

/*
Suppose SIZE = 10 for simplicity
Each index is a bucket (LinkedList<Integer>)

buckets[0] -> [ ]          // empty
buckets[1] -> [1, 11, 21]  // keys that hash to 1
buckets[2] -> [2]          // single element
buckets[3] -> [ ]          // empty
buckets[4] -> [14]         // one element
buckets[5] -> [25, 35]     // collision handled by chaining
buckets[6] -> [ ]          // empty
buckets[7] -> [7]          // one element
buckets[8] -> [18]         // one element
buckets[9] -> [29, 39]     // multiple elements
*/