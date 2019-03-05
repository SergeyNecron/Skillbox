package task2;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String ACCESS_TOKEN = "";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        MyThread thread = new MyThread(client);
        thread.start();
//        try {
//            InputStream in = new FileInputStream("/home/op/Yandex.Disk/Projects/Skillbox/src/task2/1.txt");
//            client.files().uploadBuilder("/proverka.txt").uploadAndFinish(in);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
