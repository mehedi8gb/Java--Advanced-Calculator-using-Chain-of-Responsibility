package controller.request;

public interface IRequest {
    void setNext(IRequest nextIRequest);
    String handle(String expression);
}
