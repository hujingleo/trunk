package impl;

import sun.applet.Main;

/**
 * Created by hujin on 2017/5/1.
 */
public class Time
{
    public static void main(String[] args){
        Long time = System.currentTimeMillis();
        String t =String.valueOf(time);
System.out.print(t);
    }
}
