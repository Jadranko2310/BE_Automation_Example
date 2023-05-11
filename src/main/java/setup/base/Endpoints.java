package setup.base;


import helpers.FileControlUtil;

/**
 * Providing the endpoints defined in properties files.
 */
public class Endpoints {


  public static final FileControlUtil fileControlEndpoints;

  static {
    try {
      fileControlEndpoints = new FileControlUtil(FileControlUtil.ENDPOINTS_DATA_PROPERTIES);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static final String BASE_URI = fileControlEndpoints.getValue("BASE_URI");
  public static final String EMPLOYEE = fileControlEndpoints.getValue("EMPLOYEE");
  public static final String NEW_EMPLOYEE = fileControlEndpoints.getValue("NEW_EMPLOYEE");
  public static final String LOG_IN = fileControlEndpoints.getValue("LOG_IN");
}
