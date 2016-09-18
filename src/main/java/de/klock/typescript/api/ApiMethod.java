package de.klock.typescript.api;

public interface ApiMethod<RQ extends ApiRequest<RS>, RS> {
  RS execute(RQ request);
}
