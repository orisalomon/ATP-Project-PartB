package Server;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {
    private static Configurations instance = null;
    private static final Properties prop = new Properties();

    private Configurations() {
        // private constructor, prevents other
        // classes from instancing it
        InputStream input = null;
        try {
            input = getClass().getResourceAsStream("/config.properties");

            prop.load(input);
        }

        catch (Exception e){e.printStackTrace();}
        finally {
            if(input != null){
                try{
                    input.close();
                }
                catch (Exception e){e.printStackTrace();}
            }
        }
    }

    public static Configurations getInstance(){
        if(instance == null){
            instance = new Configurations();
        }
        return instance;
    }

    public int getThreadPoolSize() {
        // get initial threads num
        return Integer.parseInt(prop.getProperty("threadPoolSize"));
    }

    public String getGenAlgorithm() throws Exception {
        // get initial generating algorithm
        return prop.getProperty("mazeGeneratingAlgorithm");
    }

    public String getSolverAlgorithm() throws Exception {
        // get initial generating algorithm
        return prop.getProperty("mazeSearchingAlgorithm");
    }

    public void setThreadPoolSize(int size) throws Exception {
        if (size < 1){throw new Exception("Thread pool size must be equal or greater than 1!");}
        FileOutputStream out = new FileOutputStream("config.properties");
        // set initial threads num
        prop.setProperty("threadPoolSize",Integer.toString(size));
        prop.store(out,null);
        out.close();
    }

    public void setGenAlgorithm(String generator) throws Exception {
        // set initial generating algorithm

        if(generator.equals("My") || generator.equals("Empty") || generator.equals("Simple")){
            FileOutputStream out = new FileOutputStream("config.properties");
            prop.setProperty("mazeGeneratingAlgorithm",generator);
            prop.store(out,null);
            out.close();
        }
        else{throw new Exception("Not valid generator algorithm.");}

    }

    public void setSolverAlgorithm(String solver) throws Exception {
        // set initial generating algorithm

        if(solver.equals("BFS") || solver.equals("DFS") || solver.equals("BEST")){
            FileOutputStream out = new FileOutputStream("config.properties");
            prop.setProperty("mazeSearchingAlgorithm",solver);
            prop.store(out,null);
            out.close();
        }
        else{throw new Exception("Not valid solver algorithm.");}
    }

}