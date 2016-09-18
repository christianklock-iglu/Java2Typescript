package de.klock.typescript.transpiler;

import de.klock.typescript.api.ApiMethod;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ApiMethodUtils {

  public static RequestResponseHolder findRequestAndResponseClass(Class<? extends ApiMethod> apiMethodClass) {
    Type[] genericInterfaces = apiMethodClass.getGenericInterfaces();
    ParameterizedType apiMethodType = getApiMethodype(genericInterfaces);
    Class<?> requestClass = (Class<?>) apiMethodType.getActualTypeArguments()[0];
    Class<?> responseClass = (Class<?>) apiMethodType.getActualTypeArguments()[1];
    return new RequestResponseHolder(requestClass, responseClass);
  }

  private static ParameterizedType getApiMethodype(Type[] genericInterfaces) {
    for (Type genericInterface : genericInterfaces) {
      if (genericInterface instanceof ParameterizedType) {
        ParameterizedType pt = (ParameterizedType) genericInterface;
        if (pt.getRawType() instanceof Class) {
          if (ApiMethod.class.isAssignableFrom((Class<?>) pt.getRawType())) {
            return pt;
          }
        }
      }
    }
    throw new RuntimeException("ApiMethod interface not found");
  }

  public static class RequestResponseHolder {
    private Class<?> requestClass;
    private Class<?> responseClass;

    public RequestResponseHolder(Class<?> requestClass, Class<?> responseClass) {
      this.requestClass = requestClass;
      this.responseClass = responseClass;
    }

    public Class<?> getRequestClass() {
      return requestClass;
    }

    public Class<?> getResponseClass() {
      return responseClass;
    }
  }

}
