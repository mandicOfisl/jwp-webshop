package hr.algebra.lmandic.webshop.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author C
 */
public class PropertiesRepo {
    private static final String root = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    
    public static Properties getSqlProperties() {
        Properties sqlProps = new Properties();
        try {
            sqlProps.load(new FileInputStream(root + "/properties/sqlQueries.properties"));
        } catch (IOException e) {
            e.printStackTrace();                 
        }
        return sqlProps;
    }
}
