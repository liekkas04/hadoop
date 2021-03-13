package org.example;

import com.hdfs.hdfs.Hdfs;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        if (args.length<4 || args[0]==null)
        {
            throw new Exception("参数错误");
        }
        else if(args[0].equals("-r")){
            Hdfs.redHdfs(args[1],args[2],args[3]);
        }
        else if(args[0].equals("-r")){
            Hdfs.writeHdfs(args[1],args[2],args[3]);
        }
        else {
            System.out.println("参数错误");
        }

    }
}
