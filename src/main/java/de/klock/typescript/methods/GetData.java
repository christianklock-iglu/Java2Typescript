package de.klock.typescript.methods;

import de.klock.typescript.api.ApiMethod;
import de.klock.typescript.api.ApiRequest;

import java.util.Date;
import java.util.List;

public interface GetData extends ApiMethod<GetData.Request, GetData.Response> {

  class Request extends ApiRequest<Response> {
    private String string;
    private Integer iNumber;
    private Long lNumber;
    private Date date;
    private List<Date> dates;
  }

  class Response {
    private List<Pair> pairsList;
    private Pair[] pairsArray;
  }

  class Pair {
    private String key;
    private String value;
  }

}
