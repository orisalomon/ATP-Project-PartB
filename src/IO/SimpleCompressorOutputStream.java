package IO;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleCompressorOutputStream extends OutputStream {
    OutputStream out;

    public SimpleCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        int i;// current index in b.
        boolean isZero = true;

        for(i=0;i<24;i++){
            write(b[i]);
        }

        boolean countZeros = true;
        int zeros = 0;
        int ones = 0;
        for(i=24;i<b.length;i++){


            if(b[i] == 0){
                zeros++;
                if(zeros>255){
                    zeros-=255;
                    write(255);
                    write(0);
                }

                if(!countZeros){
                    countZeros = true;
                    write(ones);
                    ones = 0;
                }
            }

            else{
                ones++;
                if(ones>255){
                    ones-=255;
                    write(255);
                    write(0);
                }

                if(countZeros){
                    countZeros = false;
                    write(zeros);
                    zeros = 0;
                }
            }
        }

    }
}
