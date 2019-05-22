package com.cloud.murphy;

import lombok.extern.log4j.Log4j2;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author hang.su01
 * @since 2019-05-21 22:46
 */
@Log4j2
public class testHadoop extends MurphyApplicationTests {

    @Test
    public void testHadoop() throws IOException, URISyntaxException {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://39.98.246.17:9000");
        FileSystem fs = FileSystem.get(uri,conf);
        Path resP = new Path("/Users/bianlifeng/Desktop/file/learning.txt");
        Path destP = new Path("/");
        if(!fs.exists(destP)){
            fs.mkdirs(destP);
        }
        fs.copyFromLocalFile(resP, destP);
        fs.close();

    }

}
