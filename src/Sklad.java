import java.util.Stack;

public class Sklad<Tip> {
    private Element<Tip> vrh;
    private int sizeOfSkald = 0;
    class Element<Tip> {
        public Tip vrednost;
        public Element<Tip> vezava;
        public Element(Tip e) {
            vrednost = e;
        }
    }
    public Sklad() {
    }
    public void push(Tip e)
    {
        Element<Tip> novVrh = new Element<Tip>(e);
        novVrh.vezava = vrh;
        vrh = novVrh;
        sizeOfSkald++; //dodam element
    }
    public Tip pop()
    {
        if (null == vrh) {
            throw new java.util.NoSuchElementException();
        }
        Tip e = vrh.vrednost;
        vrh = vrh.vezava;
        sizeOfSkald--;
        return e;
    }

    public boolean isEmpty()
    {
        return (null == vrh);
    }

    public Tip top(){
        if (this.vrh == null)
            return null;
        return vrh.vrednost;
    }

    public int size(){
        return sizeOfSkald;
    }
}