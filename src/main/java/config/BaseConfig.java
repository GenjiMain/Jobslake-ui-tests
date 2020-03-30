package config;

import java.util.Properties;

public class BaseConfig {
	private Properties configFile;

    public BaseConfig()
    {
        configFile = new java.util.Properties();

        try {
            configFile.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch(Exception ex){
            ex.printStackTrace();
        }
    } 
    
    public String getProperty(String key)
    {
        return configFile.getProperty(key).trim();
    }
}
