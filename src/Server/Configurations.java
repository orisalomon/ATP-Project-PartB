package Server;

import algorithms.mazeGenerators.EmptyMazeGenerator;

import java.util.Properties;

public class Configurations {
    private static Configurations instance = null;
    private Properties prop;

    private Configurations() {
        // private constructor, prevents other
        // classes from instancing it
        prop = new Properties();
    }

    public static Configurations getInstance(){
        if(instance == null){
            instance = new Configurations();
        }
        return instance;
    }

    public static int getThreadPoolSize() throws Exception {
        // get initial threads num
        int threadNum = Integer.parseInt(instance.prop.getProperty("threadPoolSize"));
        if (threadNum < 1){throw new Exception("Thread pool size must be equal or greater than 1!");}
        return threadNum;
    }

    public static String getGenAlgorithm() throws Exception {
        // get initial generating algorithm
        return instance.prop.getProperty("mazeGeneratingAlgorithm");
    }

    public static String getSolverAlgorithm() throws Exception {
        // get initial generating algorithm
        return instance.prop.getProperty("mazeSearchingAlgorithm");
    }

    public static void setThreadPoolSize(int size) throws Exception {
        // set initial threads num
        instance.prop.setProperty("threadPoolSize",Integer.toString(size));
    }

    public static void setGenAlgorithm(String generator) throws Exception {
        // set initial generating algorithm
         instance.prop.setProperty("mazeGeneratingAlgorithm",generator);
    }

    public static void setSolverAlgorithm(String solver) throws Exception {
        // set initial generating algorithm
        instance.prop.setProperty("mazeSearchingAlgorithm",solver);
    }

}