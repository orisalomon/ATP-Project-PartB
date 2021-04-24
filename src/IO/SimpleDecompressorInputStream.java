package IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SimpleDecompressorInputStream extends InputStream {
    InputStream in;

    public SimpleCompressorOutputStream(OutputStream out) {
        this.in = out;
    }

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {
        boolean isZero = true;
        for (byte myByte: b
        ) {
            if(isZero) {
                for (byte i = 0; i < myByte; i++) {
                    in.write(0);
                }
                isZero = false;
            }
            else {
                for (byte i = 0; i < myByte; i++) {
                    in.write(1);
                }
                isZero = true;
            }
        }
    }
}
