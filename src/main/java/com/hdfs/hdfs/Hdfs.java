package com.hdfs.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Hdfs {
    public static void redHdfs(String hostUrl,String hdfsPath,String fileName) throws  Exception{
        Configuration cfg=new Configuration();
        cfg.set("fs.default.name",hostUrl);
        FileSystem fileSystem= FileSystem.get(cfg);
        if (!fileSystem.exists(new Path(hdfsPath))){
            throw new Exception("文件不存在");
        }
        FSDataInputStream in =fileSystem.open(new Path(hdfsPath));
        FileOutputStream out=new FileOutputStream(fileName);
        IOUtils.copyBytes(in,out,2048);
        fileSystem.close();
    }
    public static void writeHdfs(String hostUrl,String localFile,String fileName) throws Exception{
        Configuration cfg= new Configuration();
        cfg.set("fs.default.name",hostUrl);
        FileSystem fileSystem=FileSystem.get(cfg);
        if(!fileSystem.exists(new Path(localFile))){
            throw new Exception("文件已经存在");
        }
        FSDataOutputStream out=fileSystem.create(new Path(localFile));
        FileInputStream in =new FileInputStream(fileName);
        IOUtils.copyBytes(in,out,2048);

    }
}
