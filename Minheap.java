package algo;

import java.util.Arrays;

public class Minheap {

    private hopelement[] heaps;
    private int heap_size;

    public Minheap() {
        heaps = new hopelement[10]; 
        heap_size = 0;
    }

    public void insertMinHeap(hopelement item) {
        int i;
        i = heap_size + 1;
        while ((i != 1) && (item.key < heaps[i / 2].key)) {
            heaps[i] = heaps[i / 2];
            i /= 2;
        }
        heaps[i] = item;
        heap_size++;

        if (heap_size == heaps.length - 1) {
            heaps = Arrays.copyOf(heaps, heaps.length * 2);
        }
    }

    public hopelement deleteMinHeap() {
        int parent, child;
        hopelement item, temp;
        item = heaps[1];
        temp = heaps[heap_size--];
        parent = 1;
        child = 2;
        while (child <= heap_size) {
            if ((child < heap_size) && heaps[child].key > heaps[child + 1].key)
                child++;
            if (temp.key <= heaps[child].key)
                break;

            heaps[parent] = heaps[child];
            parent = child;
            child *= 2;
        }
        heaps[parent] = temp;
        return item;
    }

    public void heap_sort(hopelement a[], int n) {
        int i;
        for (i = 0; i < n; i++) {
            insertMinHeap(a[i]);
        }
        for (i = 0; i < n; i++) {
            a[i] = deleteMinHeap();
        }
    }

    public static void main(String[] args) {
    	
    }

    
}