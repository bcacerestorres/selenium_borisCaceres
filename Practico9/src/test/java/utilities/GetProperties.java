package utilities;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private Properties prop = new Properties();

    public GetProperties(){
        InputStream in =getClass().getResourceAsStream("/config.properties");
          try{
              prop.load(in);

          }
          catch (FileNotFoundException e){
              System.out.println("the properties file was not found");
          }
          catch(IOException e){
              System.out.println("can not read property file");
          }
    }

    public String getString(String propertyName){
     return prop.getProperty(propertyName);
    }


}
