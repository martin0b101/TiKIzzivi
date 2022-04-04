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
    public String processInput(String input){
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK";
        switch (token){
            //Stack
            case  "s_add":
                if (sc.hasNext()) {
                    String multiWords = sc.next();
                    if (multiWords.charAt(0) == '"'){
                        multiWords = String.format("%s", multiWords);
                        while (sc.hasNext()){
                            multiWords = String.format("%s %s", multiWords, sc.next());
                        }
                        sklad.add(multiWords.substring(1, multiWords.length()-1));
                    }
                    else {
                        sklad.add(multiWords);
                    }
                }
                else {
                    result = "Error: please specify a string";
                }
                break;
            case "s_remove_first":
                if (!sklad.isEmpty())
                    result = sklad.removeFirst();
                else
                    result = "Error: stack is empty";
                break;
            case "reset":
                while (!sklad.isEmpty()){
                    sklad.removeFirst();
                }
                break;
            case "s_size":
                result = String.format("%d", sklad.depth());
                break;
            case "s_get_first":
                if (sc.hasNext()){
                    if (sklad.top() == null){
                        result = "Error: stack is empty";
                        break;
                    }
                    else if (sklad.getFirst().equals(sc.next())){
                        break;
                    }
                    else {
                        result = "Error: wrong element";
                    }
                }else {
                    result = "Error: please specify a string";
                }
                break;
            case "s_isEmpty":
                if (sklad.isEmpty())
                    result = "Stack is empty";
                else
                    result = "Stack is not empty";
                break;
            case "search":
                if (sc.hasNext()){
                    result = String.format("%d",sklad.search(sc.next()));
                }
                else {
                    result = "Error: please specify a string";
                }
                break;

            //Priority queue
            case "pq_add":
                if (sc.hasNext()){
                    String val = sc.next();
                    vrsta.add(val);
                }
                else
                    result = "Error: please specify a string";
                break;
            case "pq_remove_first":
                if (!vrsta.isEmpty())
                    result = vrsta.removeFirst();
                else
                    result = "Error: priority queue is empty";
                break;
            case "pq_get_first":
                if (!vrsta.isEmpty())
                    result = vrsta.getFirst();
                else
                    result = "Error: priority queue is empty";
                break;
            case "pq_size":
                result = String.format("%d", vrsta.size());
                break;
            case "pq_depth":
                result = String.format("%d", vrsta.depth());
                break;
            case "pq_isEmpty":
                if (vrsta.isEmpty())
                    result = "Priority queue is empty";
                else
                    result = "Priority queue is not empty";
                break;
        }
        return result;
    }
}
