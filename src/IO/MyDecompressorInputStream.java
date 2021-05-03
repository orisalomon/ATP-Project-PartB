package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class MyDecompressorInputStream extends InputStream  implements Serializable {

    InputStream in;

    public MyDecompressorInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    @Override
    public int read(byte[] readTo) throws IOException {
        int i;
        int totalRead = 0;

        for (i = 0; i < 24; i++) {
            readTo[i] = (byte) read();
            totalRead++;
        }

        while(i<readTo.length){
            int num = read();
            num = num<0? num+256: num;
            totalRead++;
            for(int j=0;j<8 && i<readTo.length;j++){
                readTo[i++] = (byte)(num%2);
                num = num/2;
            }
        }
        return totalRead;
    }
}
