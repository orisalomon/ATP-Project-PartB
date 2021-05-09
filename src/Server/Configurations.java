package Server;


import java.io.FileInputStream;
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
            input = new FileInputStream("./resources/config.properties");
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
        int threadNum = Integer.parseInt(instance.prop.getProperty("threadPoolSize"));
        return threadNum;
    }

    public String getGenAlgorithm() throws Exception {
        // get initial generating algorithm
        return instance.prop.getProperty("mazeGeneratingAlgorithm");
    }

    public String getSolverAlgorithm() throws Exception {
        // get initial generating algorithm
        return instance.prop.getProperty("mazeSearchingAlgorithm");
    }

    public void setThreadPoolSize(int size) throws Exception {
        if (size < 1){throw new Exception("Thread pool size must be equal or greater than 1!");}
        // set initial threads num
        instance.prop.setProperty("threadPoolSize",Integer.toString(size));
    }

    public void setGenAlgorithm(String generator) throws Exception {
        // set initial generating algorithm

        if(generator.equals("My") || generator.equals("Empty") || generator.equals("Simple")){
            instance.prop.setProperty("mazeGeneratingAlgorithm",generator);
        }
        else{throw new Exception("Not valid generator algorithm.");}


    }

    public void setSolverAlgorithm(String solver) throws Exception {
        // set initial generating algorithm

        if(solver.equals("BFS") || solver.equals("DFS") || solver.equals("BEST")){
            instance.prop.setProperty("mazeSearchingAlgorithm",solver);
        }
        else{throw new Exception("Not valid solver algorithm.");}
    }

}