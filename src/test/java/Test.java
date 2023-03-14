import entity.Node;
import service.CheckService;
import units.ReadJson;

import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public static final String filePath="/home/lyq/IdeaProjects/Test2/src/main/resources/latlon.json";


    public static boolean test1(String s) throws IOException {
        ArrayList<Node> data = ReadJson.getData(s);
        return CheckService.check(new Node(119.037089, 32.259867), data);
    }

    public static boolean test2(String s) throws IOException {
        ArrayList<Node> data = ReadJson.getData(s);
        return CheckService.check(new Node(118.821489,32.077388), data);
    }

    public static boolean test3(String s) throws IOException {
        ArrayList<Node> data = ReadJson.getData(s);
        return CheckService.check(new Node(   118.882035, 32.041), data);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(test1(filePath));
        System.out.println(test2(filePath));
        System.out.println(test3(filePath));
        System.out.println(2e-10);
    }


}
