package service;

import entity.Node;

import java.util.ArrayList;

public class CheckService {


    //从node节点做射线，判断射线和多边形的相交次数，偶数在外，奇数在内
    public static boolean check(Node node, ArrayList<Node> list){
        int n = list.size();
        //相交次数
        int num = 0;
        Node left, right;
        Node p = node;

        left = list.get(0);
        for(int i = 1; i <=n; ++i){

            //如果点重合则一定在范围中
            if(p.equals(left)){
                return true;
            }

            right = list.get(i % n);

            //判断p是否在left和right中间

            if(p.getX() < Math.min(left.getX(), right.getX()) || p.getX() > Math.max(left.getX(), right.getX())){
                left = right;
                continue;
            }


            if(p.getX() > Math.min(left.getX(), right.getX()) && p.getX() < Math.max(left.getX(), right.getX())){
                if(p.getY() <= Math.max(left.getY(), right.getY())){
                    //若x相等，y在left和right的y之间，则代表node在线上
                    if(left.getX() == right.getX() && p.getY() >= Math.min(left.getY(), right.getY())){
                        return true;
                    }

                    //若y相等，并且某一边的y和node的y相等，则代表也在线上，否则，则必有一交点
                    if(left.getY() == right.getY()){
                        if(left.getY() == p.getY()){
                            return true;
                        }else{
                            ++num;
                        }
                    }else{
                        //y的交叉点
                        double mid = (p.getX() - left.getX()) * (right.getY() - left.getY()) / (right.getX() - left.getX()) + left.getY();
                        if(Math.abs(p.getY() - mid) < 2e-10){
                            return true;
                        }

                        if(p.getY() < mid){
                            ++num;
                        }
                    }
                }
            }else{
                //光线穿过顶点的情况
                if(p.getX() == right.getX() && p.getY() <= right.getY()){
                    Node k = list.get((i+1) % n);
                    //x位于left和k之间
                    if(p.getX() >= Math.min(left.getX(), k.getX()) && p.getX() <= Math.max(left.getX(), k.getX())){
                        ++num;
                    }else{
                        num += 2;
                    }
                }
            }
            left = right;
        }

        if(num % 2 == 0){
            return false;
        } else {
            return true;
        }

    }
}
