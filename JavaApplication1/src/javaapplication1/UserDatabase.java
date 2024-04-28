/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Administrator
 */
public class UserDatabase {
    private static String[] usernames;
    private static String[] passwords;
    private static int size;
    
    public UserDatabase(int capacity) {
        usernames = new String[capacity];
        passwords = new String[capacity];
        size = 0;
    }
    
    public void addUser(String username, String password) {
        if (size < usernames.length) {
            usernames[size] = username;
            passwords[size] = password;
            size++;
        } else {
            System.out.println("Database is full, cannot add more users.");
        }
    }
    
    public static boolean authenticate(String username, String password) {
        for (int i = 0; i < size; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
    

}

