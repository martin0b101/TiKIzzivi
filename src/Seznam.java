public interface Seznam<Tip> {
    //add element
    void add(Tip e);
    //remove first element
    Tip removeFirst();
    //get first element
    Tip getFirst();
    //get size of
    int size();
    int depth();
    boolean isEmpty();
}
