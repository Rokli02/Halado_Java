package hu.iit.java;

public class BaseFlow_AggResXml implements BaseFlow{
    private String[] flow;
    private String[] processedFlow;
    //private Class<?> baseClass;

    BaseFlow_AggResXml() {
        this.processedFlow = null;
    }

    @Override
    public void setInput(Object[] obj) {
        this.flow = (String[]) obj;
    }

    @Override
    public Object[] getOutput() {
        return this.processedFlow;
    }

    @Override
    public void doProcess() throws NotValidInputDataException {
        this.processedFlow = this.flow.clone();
    }
}
