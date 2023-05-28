package request.cases;

import request.IRequest;

public class defaultHandler  implements IRequest {
    private IRequest nextInIRequest;
    @Override
    public void setNext(IRequest nextIRequest) {
        this.nextInIRequest = nextIRequest;
    }

    @Override
    public String handle(String expression) {
        return null;
    }
}
