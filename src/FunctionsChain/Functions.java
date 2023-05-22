package FunctionsChain;

public class Functions {
    final FChain cosecHandler;
    final FChain sinHandler;
    final FChain cosHandler;
    final FChain tanHandler;
    final FChain secHandler;
    final FChain cotHandler;
    final FChain defaultHandler;

    public Functions(){
        sinHandler = new SinHandler();
        cosHandler = new CosHandler();
        tanHandler = new TanHandler();
        cosecHandler = new CosecHandler();
        secHandler = new SecHandler();
        cotHandler = new CotHandler();
        defaultHandler = new DefaultHandler();

        sinHandler.setNext(cosHandler);
        cosHandler.setNext(tanHandler);
        tanHandler.setNext(cosecHandler);
        cosecHandler.setNext(secHandler);
        secHandler.setNext(cotHandler);
        cotHandler.setNext(defaultHandler);
    }
    public double startFunctionsChain(String expression){
        return sinHandler.handle(expression);
    }
}
