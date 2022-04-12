package hu.iit.java;

public class BaseFlow_MemArrAggRes implements BaseFlow{
    private Object[] flow;
    private Object[] processedFlow;
    private Class<?> baseClass;

    BaseFlow_MemArrAggRes(Class baseClass) {
        this.processedFlow = null;
        this.baseClass = baseClass;
    }

    @Override
    public void setInput(Object[] obj) {
        for(Object value: obj) {
            if (!baseClass.isInstance(value)) {
                throw new NotValidInputDataException(String.format("Memory array is not right object, it should be: %s, but is: %s",
                        baseClass.getName(), value.getClass().getName()));
            }
        }

        this.flow = obj.clone();
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
