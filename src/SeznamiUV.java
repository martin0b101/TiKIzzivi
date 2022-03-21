import java.util.Scanner;

public class SeznamiUV {

    private Sklad<String> sklad;

    public SeznamiUV(){
        sklad = new Sklad<String>();
    }
    public String processInput(String input){
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK";
        switch (token){
            case  "push":
                if (sc.hasNext()) {
                    String multiWords = sc.next();
                    if (multiWords.charAt(0) == '"'){
                        multiWords = String.format("%s", multiWords);
                        while (sc.hasNext()){
                            multiWords = String.format("%s %s", multiWords, sc.next());
                        }
                        sklad.push(multiWords.substring(1, multiWords.length()-1));
                    }
                    else {
                        sklad.push(multiWords);
                    }
                }
                else {
                    result = "Error: please specify a string";
                }
                break;
            case "pop":
                if (!sklad.isEmpty())
                    result = sklad.pop();
                else
                    result = "Error: stack is empty";
                break;
            case "reset":
                while (!sklad.isEmpty()){
                    sklad.pop();
                }
                break;
            case "count":
                result = String.format("%d", sklad.size());
                break;
            case "isTop":
                if (sc.hasNext()){
                    if (sklad.top() == null){
                        result = "Error: stack is empty";
                        break;
                    }
                    else if (sklad.top().equals(sc.next())){
                        break;
                    }
                    else {
                        result = "Error: wrong element";
                    }
                }else {
                    result = "Error: please specify a string";
                }
                break;
            case "search":
                if (sc.hasNext()){
                    result = String.format("%d",sklad.search(sc.next()));
                }
                else {
                    result = "Error: please specify a string";
                }
                break;
        }
        return result;
    }
}
