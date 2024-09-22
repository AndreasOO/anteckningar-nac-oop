import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        char ch = 1;
//        System.out.println((char) (ch+96));

        int num = 420;

        String numStr = String.valueOf(num);
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < numStr.length(); i++) {
            res.add(numStr.substring(0, i + 1));
        }

        String[] res2 = res.stream().map(String::new).toArray(String[]::new);


        for (String ele : res2) {
            System.out.println(ele);
            
        }






    }


}