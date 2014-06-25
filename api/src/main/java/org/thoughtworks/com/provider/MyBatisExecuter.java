package org.thoughtworks.com.provider;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisExecuter {
    SqlSessionFactory sqlSessionFactory;

    public MyBatisExecuter() throws IOException {
        String configFile = "org/thoughtworks/com/provider/config.xml";
        InputStream configStream = null;

        configStream = Resources.getResourceAsStream(configFile);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configStream);

    }

    public SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
