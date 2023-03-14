package units;

import entity.Node;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ReadJson {

    //读取json文件
    public static ArrayList<Node> getData(String fileName) throws IOException {
        ArrayList<Node> list=new ArrayList<>();

        File file=new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取文件相应的channel，channel中会有相关数据
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
        // 将channel的数据读取到buffer
        channel.read(buffer);
        String s = new String(buffer.array());
        //删除无关的字符
        s=s.replaceAll("\\["," ");
        s=s.replaceAll("]"," ");
        s=s.replaceAll("\\s*|\r|\n|\t","");

        String[] split = s.split(",");
        for (int i = 0; i < split.length; i+=2) {
            list.add(new Node(split[i],split[i+1]));
        }

        fileInputStream.close();

        return list;
    }



}
