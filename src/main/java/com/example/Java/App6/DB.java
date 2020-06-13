package com.example.Java.App6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {
    private HashMap<String, String> dataStore;
    private ArrayList<User>UserTable;

    public DB() {
        dataStore = new HashMap<>();
        dataStore.put("Sachin", "A great cricketer");
        dataStore.put("msd", "A great caption");

        UserTable = new ArrayList<>();
        UserTable.add(new User(4, "Dhoni", 38));
        UserTable.add(new User(2, "Rohit", 31));
        UserTable.add(new User(3, "Kohli", 31));
    }

    public String searchAWord(String word){
        return dataStore.get(word);
    }

    public List<User> searchUsersByUserName(String name){
        ArrayList<User> list = new ArrayList<>();
        for(User user: UserTable){
            if(user.getName().equals(name))
                list.add(user);
        }
        return list;
    }
    public User searchAUserByUserId(int id){
        for(User user: UserTable){
            if(user.getId()==id)
                return user;
        }
        return null;
    }
    public List<User> getAllUsers(){
        return UserTable;
    }


    public boolean addAUser(User user){
        UserTable.add(user);
        return true;
    }

    public boolean deleteAUser(int id){
        for(User user:UserTable){
            if(user.getId()==id) {
                UserTable.remove(user);
                return true;
            }

        }
        return false;
    }

    public boolean updateAUser(User inputUesr){
        for(User user:UserTable){
            if(user.getId()==inputUesr.getId()) {
                UserTable.remove(user);
                UserTable.add(inputUesr);
                return true;
            }

        }
        return false;
    }


}
