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
    //odstranjevaje in vracanje dolocenega elementa
    Tip remove(Tip e);
    //ali element obstaja v strukturi
    boolean exist(Tip e);

}
