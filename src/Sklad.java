import java.util.ArrayList;
import java.util.Stack;

public class Sklad<Tip extends Comparable> implements Seznam<Tip> {
    private Element<Tip> vrh;
    //private int sizeOfSkald = 0;
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
        //sizeOfSkald++; //dodam element
    }
    public Tip pop()
    {
        if (null == vrh) {
            throw new java.util.NoSuchElementException();
        }
        Tip e = vrh.vrednost;
        vrh = vrh.vezava;
        //sizeOfSkald--;
        return e;
    }

    public boolean isEmpty()
    {
        return (null == vrh);
    }
/*
    @Override
    public Tip remove(Tip e) {
        Element<Tip> temp = vrh;
        ArrayList<Tip> saveHere = new ArrayList<>();
        Tip toRemove = null;
        while (null != temp){
            if (!temp.vrednost.equals(e)){
                saveHere.add(temp.vrednost);
            }else {
                toRemove = temp.vrednost;
            }
            temp = temp.vezava;
            pop();
        }
        for (Tip t:saveHere) {
            push(t);
        }
        return toRemove;
    }*/

    @Override
    public Tip remove(Tip e) {
        if (vrh.vrednost == null){
            return null;
        }
        if (exist(e)){
            if (vrh.vrednost.equals(e)){
                removeFirst();
            }else{
                Element<Tip> temp = vrh;
                while (temp != null){
                    if (temp.vezava.vrednost.equals(e)){
                        Tip returnThis = temp.vezava.vrednost;
                        temp.vezava = temp.vezava.vezava;
                        return returnThis;
                    }
                    temp = temp.vezava;
                }
            }
            return e;
        }
        return e;
    }

    @Override
    public boolean exist(Tip e) {
        int elemntExist = search(e);
        if (elemntExist > -1)
            return true;
        return false;
    }

    public Tip top(){
        if (this.vrh == null)
            return null;
        return vrh.vrednost;
    }

    @Override
    public void add(Tip e) {
        push(e);
    }

    @Override
    public Tip removeFirst() {
        return pop();
    }

    @Override
    public Tip getFirst() {
        return top();
    }

    public int size(){
        int result = 0;
        Element<Tip> temp = vrh;
        while (null != temp) {
            ++result;
            temp = temp.vezava;
        }
        return result;
    }

    @Override
    public int depth() {
        return size();
    }

    public int search(Tip e){
        int r = 0;
        Element<Tip> temp = vrh;
        while (null != temp){
            if (temp.vrednost.equals(e)){
                return r;
            }
            temp = temp.vezava;
            r++;
        }
        return -1;
    }
}