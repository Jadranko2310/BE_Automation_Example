package setup.mockserver;

/**
 * Mockserver with start and tearDown methods.
 */
public interface ImockServer {
    
  void start() throws Exception;

  void tearDown() throws Exception;
}
