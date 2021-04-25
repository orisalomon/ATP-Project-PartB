package IO;

import java.io.IOException;
import java.io.InputStream;

public class SimpleDecompressorInputStream extends InputStream {
    InputStream in;

    public SimpleDecompressorInputStream(InputStream in) {
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
        boolean isZero = true;

        for (i=0;i<24;i++){
            readTo[i] = (byte)read();
        }
        while(i<readTo.length){
            if(isZero){
                 int count =read();
                 totalRead++;
                 for(int j=0;j<count;j++){
                     readTo[i++] = 0;
                 }
                 isZero = false;
            }
            else{
                int count =read();
                totalRead++;
                for(int j=0;j<count;j++){
                    readTo[i++] = 1;
                }
                isZero = true;
            }
        }
        return totalRead;
    }
}

