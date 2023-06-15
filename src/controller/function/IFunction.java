package controller.function;

public interface IFunction {

        void setNext(final IFunction nextTChain);

        double handle(String functionName, String value);
}
