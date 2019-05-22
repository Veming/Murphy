package com.cloud.murphy;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringHadoopHDFSApp {

    private ApplicationContext context;
    private FileSystem fileSystem;

    /**
     * 创建HDFS文件夹
     * @throws Exception
     */
    @Test
    public void testMkdirs() throws Exception {
        fileSystem.mkdirs(new Path("/"));

    }

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("config/hadoop-config.xml");

        fileSystem = (FileSystem) context.getBean("fileSystem");
    }

    @After
    public void tearDown() throws IOException {
        context = null;
        fileSystem.close();
    }
}