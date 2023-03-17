import entity.Node;
import service.CheckService;
import units.ReadJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String filePath="/home/lyq/IdeaProjects/Test2/src/main/resources/latlon.json";

    public static ArrayList<Node> data;

    static {
        try {
            data= ReadJson.getData(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean test1() throws IOException {
        return CheckService.check(new Node(119.037089, 32.259867), data);
    }

    public static boolean test2() throws IOException {
        return CheckService.check(new Node(118.821489,32.077388), data);
    }

    public static boolean test3() throws IOException {
        return CheckService.check(new Node(   118.882035, 32.041), data);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        while (true){
            if (s.equals("11")){
                System.out.println(test1());
            }
        }
    }

}
