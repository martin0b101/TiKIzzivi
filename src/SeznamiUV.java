import java.util.HashMap;
import java.util.Scanner;

public class SeznamiUV {

    HashMap<String, Seznam<String>> seznami;
    Seznam<String> seznam;


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
                    seznam = seznami.get(sc.next());
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
                    result = "Error: stack is empty";
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
                if (sc.hasNext()) {
                    if (seznam.getFirst() == null) {
                        result = "Error: stack is empty";
                        break;
                    } else if (seznam.getFirst().equals(sc.next())) {
                        break;
                    } else {
                        result = "Error: wrong element";
                    }
                } else {
                    result = "Error: please specify a string";
                }
                break;
            case "isEmpty":
                if (seznam.isEmpty())
                    result = "Stack is empty";
                else
                    result = "Stack is not empty";
                break;
            case "search":
                if (sc.hasNext()) {
                    result = String.format("%d", seznam.exist(sc.next()));
                } else {
                    result = "Error: please specify a string";
                }
                break;
        }
        return token;
    }
}
