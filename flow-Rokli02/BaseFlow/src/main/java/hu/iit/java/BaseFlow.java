package hu.iit.java;

public interface BaseFlow {
    void setInput(Object[] obj);
    Object[] getOutput();
    void doProcess() throws NotValidInputDataException;
}
