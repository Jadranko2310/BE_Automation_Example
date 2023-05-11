package helpers;

import java.util.Properties;

/**
 * Enables reading values from properties.
 */
@SuppressWarnings("unused")
public class FileControlUtil {
  public Properties properties;

  public static final String ENDPOINTS_DATA_PROPERTIES = "Endpoints.properties";
  public static final String USER_DATA_PROPERTIES = "UserDetails.properties";
  public static final String RESPONSE_MESSAGE = "ResponseMessage.properties";


  public FileControlUtil(String file) throws Exception {
    properties = new Properties();
    properties.load(getClass().getResourceAsStream("/" + file));
  }


  public String getValue(String propertyKey) {
    return  properties.getProperty(propertyKey);
  }
}
