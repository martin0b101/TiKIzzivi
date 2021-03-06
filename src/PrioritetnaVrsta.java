
public class PrioritetnaVrsta<Tip extends Comparable> implements Seznam<Tip> {

    private Object[] heap;
    private int end = 0;


    public PrioritetnaVrsta(){
        this(100);
    }
    public PrioritetnaVrsta(int maxSize){
        heap = new Object[maxSize];
    }


    private void swap(int a, int b) {
        Object tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    private void bubbleUp() {
        int eltIdx = end - 1;
        while (eltIdx >= 0) {
            Tip elt = (Tip) heap[eltIdx];
            int childIdx = eltIdx * 2 + 1;
            if (childIdx < end) {
                Tip child = (Tip) heap[childIdx];
                if (childIdx + 1 < end && child.compareTo(heap[childIdx+1]) < 0)
                    child = (Tip) heap[++childIdx];
                if (elt.compareTo(child) >= 0)
                    return;
                swap(eltIdx, childIdx);
            }
            eltIdx = eltIdx % 2 == 1 ? (eltIdx - 1) / 2 : (eltIdx - 2) / 2;
        }
    }

    private void bubbleDown(int start) {
        int eltIdx = start;
        int childIdx = eltIdx * 2 + 1;
        while (childIdx < end) {
            Tip elt = (Tip) heap[eltIdx];
            Tip child = (Tip) heap[childIdx];
            if (childIdx + 1 < end && child.compareTo(heap[childIdx+1]) < 0)
                child = (Tip) heap[++childIdx];
            if (elt.compareTo(child) >= 0)
                return;
            swap(eltIdx, childIdx);
            eltIdx = childIdx;
            childIdx = eltIdx * 2 + 1;
        }
    }

    private void resizeHeap(){
        //povecaj tabelo prepisi vse elemente
        Object[] tableSmall = heap;
        int sizeOfSmallTable = tableSmall.length;
        Object[] newTable = new Object[2*sizeOfSmallTable];
        heap = newTable;
        end = 0;
        for (int i = 0; i < sizeOfSmallTable; i++) {
            add((Tip) tableSmall[i]);
        }
    }

    @Override
    public void add(Tip e) {
        //if (end == )
        if (heap.length == end){
            resizeHeap();
        }
        heap[end++] = e;
        bubbleUp();

    }

    @Override
    public Tip removeFirst() {
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();
        Tip elt = (Tip) heap[0];
        swap(0, --end);
        bubbleDown(0);
        return elt;
    }

    @Override
    public Tip getFirst() {
        if(this.isEmpty())
            return null;
        return (Tip) heap[0];
    }

    @Override
    public int size() {
        return end;
    }

    @Override
    public int depth() {
        if(end==0)
            return 0;
        return (int) (Math.log(end) / Math.log(2)) +1;
    }

    @Override
    public boolean isEmpty() {
        return end==0;
    }

    @Override
    public Tip remove(Tip e) {
        if (isEmpty()){
            return null;
        }
        if (getFirst().equals(e)){
            Tip deleteFirst = getFirst();
            removeFirst();
            return deleteFirst;
        }else{
            for (int i = 0; i < end; i++) {
                //najdem element
                if (heap[i].equals(e)){
                    Tip deleteThis = (Tip) heap[i];
                    //ga zamenjam z zadnjim
                    swap(i, --end);
                    bubbleDown(i);
                    return deleteThis;
                }
            }
        }
        return null;
    }

    @Override
    public boolean exist(Tip e) {
        if (isEmpty()){
            return false;
        }else {
            for (int i = 0; i < end; i++) {
                if (heap[i].equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }
}
