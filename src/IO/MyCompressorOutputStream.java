package IO;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
    OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        int i;// current index in b.

        // compress meta-data
        for(i=0;i<24;i++){
            write(b[i]);
        }

        int acc = 0;
        int pow = 0;
        // compress maze
        while(i<b.length){
            if(pow == 8){write(acc);pow=0;acc=0;}

            acc+= Math.pow(b[i],pow);
            pow++;
            i++;
        }
    }
}
