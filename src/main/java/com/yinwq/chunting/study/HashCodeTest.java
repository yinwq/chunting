package com.yinwq.chunting.study;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/6/28 11:11
 */
public class HashCodeTest {

    public static void main(String[] args) {
        String str1 = "通话";
        String str2 = "重地";
        System. out. println(String. format("str1：%d | str2：%d",  str1. hashCode(),str2. hashCode()));
        System. out. println(str1. equals(str2));

        Set set = new Set();
        set.add(1);
        set.add(1);
        System.err.println(set);
    }

    static class Set{
        Object[] objects = new Object[1];
        int size = 0;

        boolean add(Object o){
            for(int i=0; i<size; i++){
                if(objects[i].hashCode() == o.hashCode())
                    if(objects[i].equals(o))
                        return false;
            }
            objects[size++] = o;
            return true;
        }

        public static void main(String[] args) {

        }
    }
}
