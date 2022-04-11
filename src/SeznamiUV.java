import java.util.HashMap;
import java.util.Scanner;

public class SeznamiUV {

    HashMap<String, Seznam<String>> seznami;
    Seznam<String> seznam;

    String weUseThisDataStructure;

    public SeznamiUV(){
        seznami = new HashMap<>();
        seznami.put("pv", new PrioritetnaVrsta<>());
        seznami.put("sk", new Sklad<>());
        seznami.put("bst", new BinarnoIskalnoDrevo<>());
    }
    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK";
        switch (token) {


            case "use":
                if (sc.hasNext()) {
                    String use = sc.next();
                    weUseThisDataStructure = use;
                    seznam = seznami.get(use);
                    if (null == seznam)
                        result = "Error: please specify a correct data structure type (pv, sk, bst)";
                } else result = "Error: please specify a data structure type (pv, sk, bst)";
                break;

            //Stack
            case "add":
                if (sc.hasNext()) {
                    String multiWords = sc.next();
                    if (multiWords.charAt(0) == '"') {
                        multiWords = String.format("%s", multiWords);
                        while (sc.hasNext()) {
                            multiWords = String.format("%s %s", multiWords, sc.next());
                        }
                        seznam.add(multiWords.substring(1, multiWords.length() - 1));
                    } else {
                        seznam.add(multiWords);
                    }
                } else {
                    result = "Error: please specify a string";
                }
                break;
            case "remove_first":
                if (!seznam.isEmpty())
                    result = seznam.removeFirst();
                else
                    if (weUseThisDataStructure.equals("pv")){
                        result = "Error: priority queue is empty";
                    }else if(weUseThisDataStructure.equals("bst")){
                        result = "Error: binary search tree is empty";
                    }
                    else {
                        result = "Error: stack is empty";
                    }
                break;
            case "reset":
                while (!seznam.isEmpty()) {
                    seznam.removeFirst();
                }
                break;
            case "size":
                result = String.format("%d", seznam.depth());
                break;
            case "get_first":
                if (seznam.getFirst() == null) {
                    if (weUseThisDataStructure.equals("pv")){
                        result = "Error: priority queue is empty";
                    }else if(weUseThisDataStructure.equals("bst")){
                        result = "Error: binary search tree is empty";
                    }else {
                        result = "Error: stack is empty";
                    }
                    break;
                } else{

                    result = seznam.getFirst();

                    break;
                }

            case "isEmpty":
                if (seznam.isEmpty())
                    if (weUseThisDataStructure.equals("pv")){
                        result = "Error: priority queue is empty";
                    }else if(weUseThisDataStructure.equals("bst")){
                        result = "Error: binary search tree is empty";
                    }else {
                        result = "Error: stack is empty";
                    }
                else
                if (weUseThisDataStructure.equals("pv")){
                    result = "Error: priority queue is not empty";
                }else if(weUseThisDataStructure.equals("bst")){
                    result = "Error: binary search tree is not empty";
                }else {
                    result = "Error: stack is not empty";
                }
                break;

            case "depth":
                result = String.format("%d", seznam.depth());
                break;
            case "exist":
                if (sc.hasNext()){
                    if (seznam.exist(sc.next())){
                        result = "Element exist";
                    }else{
                        result = "Element does not exist";
                    }
                }else{
                    result = "Error: please specify a string";
                }
                break;
            case "remove":
                if (sc.hasNext()){
                    String removeThis = sc.next();
                    if (seznam.exist(removeThis)){
                        result = seznam.remove(removeThis);
                    }else{
                        result = "Error: can not remove element that does not exist";
                    }
                }else{
                    result = "Error: please specify a string";
                }
                break;

        }
        return result;
    }
}
