package com.yinwq.chunting.thread.t4_1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/11 19:47
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public synchronized static void doPost(String username, String password){

        try {
            usernameRef = username;
            if(username.equals("a")){
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username = " + usernameRef + " password = " + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
