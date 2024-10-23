package OOP.Sprint3.Uppgift1ac;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ImagePresenter imagePresenter = new ImagePresenter(Paths.get("pictures/picture-1-400x300.jpg"));
        imagePresenter.init();
    }


}
