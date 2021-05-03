package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public class MyCompressorOutputStream extends OutputStream implements Serializable {
    OutputStream out;

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

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

            acc+= Math.pow(2,pow)*b[i];
            pow++;
            i++;
        }
        write(acc);
    }
}
