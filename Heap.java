package algo;

import java.util.Arrays;

public class Heap {

    private Element[] heaps;
    private int heap_size;

    public Heap() {
        heaps = new Element[10]; 
        heap_size = 0;
    }

    public void insertMaxHeap(Element item) {
        int i;
        i = heap_size + 1;
        while ((i != 1) && (item.key > heaps[i / 2].key)) {
            heaps[i] = heaps[i / 2];
            i /= 2;
        }
        heaps[i] = item;
        heap_size++;

        if (heap_size == heaps.length - 1) {
            heaps = Arrays.copyOf(heaps, heaps.length * 2);
        }
    }
    public Element delete_max_heap()
    {
    	int parent, child;
    	Element item, temp;
    	item = heaps[1];
    	temp=heaps[heap_size--];
    	parent=1;
    	child=2;
    	while(child<=heap_size) {
    		if((child<heap_size)&&heaps[child].key<heaps[child+1].key)
    			child++;
    		if(temp.key>=heaps[child].key) break;
    		
    		heaps[parent]=heaps[child];
    		parent=child;
    		child*=2;
    	}
    	heaps[parent]=temp;
    	return item;
    }
    public void heap_sort(Element a[],int n) {
    	int i;
    	for(i=0;i<n;i++) {
    		insertMaxHeap(a[i]);
    	}
    	for (i = (n - 1); i >= 0; i--) {
    		a[i] = delete_max_heap();
    	}
    }
    public static void main(String[] args) {
    	 Element[] list = {new Element(23), new Element(56), new Element(11),
                 new Element(9), new Element(56), new Element(99),
                 new Element(27), new Element(34)};
    	Heap h=new Heap();
    	h.heap_sort(list, 8);
    	for (int i = 0; i < 8; i++) {
    		System.out.println(list[i].key+"\n");
    		
    	}
    	System.out.println("\n");
   }
    
}
