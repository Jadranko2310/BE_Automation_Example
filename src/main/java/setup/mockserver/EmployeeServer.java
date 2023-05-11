package setup.mockserver;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation for mock employee server.
 */

@Retention(RUNTIME)
@Target(METHOD)
public @interface EmployeeServer {
}
