import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        char ch = 1;
//        System.out.println((char) (ch+96));

        String bis = "11010101010101";

        bis = bis.replaceAll("0", "");

        System.out.println(Integer.parseUnsignedInt(bis, 2));
        System.out.println(Long.parseLong(bis, 2));


    }


}