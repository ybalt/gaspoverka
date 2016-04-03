package gaspoverka.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Config {

    private static Config _instance = null;
    static Properties config;

    public Config() {
        config = new Properties();
        this.load();
    }

    public static Properties getConfig() {
        return config;
    }

    public void save() {
        String filename = "./config.ini";
        DataOutputStream dos;
        try {
            dos = new DataOutputStream(new FileOutputStream(filename, false));
            config.store(dos, "config");
            dos.close();
        } catch (Exception e) {
        }

    }

    public void load(){
         String filename = "./config.ini";
         DataInputStream dis;
         try {
            dis = new DataInputStream(new FileInputStream(filename));
            config.load(dis);
            dis.close();
        } catch (Exception e) {
        }
   }

    public synchronized static Config getInstance() {
        if (_instance == null) {
            _instance = new Config();
        }
        return _instance;
    }
}
