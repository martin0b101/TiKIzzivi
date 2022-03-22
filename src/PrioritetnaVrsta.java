public class PrioritetnaVrsta<Tip extends Comparable> implements Seznam<Tip> {

    private Tip[] heap;
    private int end = 0;

    public PrioritetnaVrsta(){
        this(100);
    }
    public PrioritetnaVrsta(int maxSize){
        heap = (Tip[]) new Object[maxSize];
    }

    @Override
    public void add(Tip e) {

    }

    @Override
    public Tip removeFirst() {
        return null;
    }

    @Override
    public Tip getFirst() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int depth() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
