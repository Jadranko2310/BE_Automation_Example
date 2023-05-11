package helpers;


import com.google.gson.Gson;

/**
 * Converts java Object to Json.
 */

@SuppressWarnings("unused")
public class BodyConverterUtil {

  @SuppressWarnings("unused")
  public static String convertToJson(Object jsonBody) {
    return new Gson().toJson(jsonBody);  // Converting object to JSON body
  }
}
