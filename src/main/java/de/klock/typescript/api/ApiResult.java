package de.klock.typescript.api;

public interface ApiResult<T> {
  boolean isOk();

  T getResponse();

  Problem getProblem();
}
