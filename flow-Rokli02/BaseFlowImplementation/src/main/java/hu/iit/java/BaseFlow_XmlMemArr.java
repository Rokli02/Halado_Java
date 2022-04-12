package hu.iit.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class BaseFlow_XmlMemArr implements BaseFlow {
    private Object[] flow;
    private Object[] processedFlow;
    private Class<?> baseClass;
    private ObjectMapper mapper;

    BaseFlow_XmlMemArr(Class baseClass, ObjectMapper mapper) {
        this.processedFlow = null;
        this.baseClass = baseClass;
        this.mapper = mapper;
    }

    @Override
    public void setInput(Object[] obj) {
        flow = obj;
    }

    @Override
    public Object[] getOutput() {
        return this.processedFlow;
    }

    @Override
    public void doProcess() throws NotValidInputDataException  {
        try {
            this.processedFlow = new Object[flow.length];
        } catch (NullPointerException err) {
            throw new NotValidInputDataException("Input is not set!");
        }
        int processedFlowIndex = 0;
        for (Object value: flow){
            try {
                this.processedFlow[processedFlowIndex] = mapper.readValue(value.toString(), baseClass);
            } catch (RuntimeException | JsonProcessingException excp) {
                throw new NotValidInputDataException(String.format("Input is not an xml object!\n\t%s",excp.getMessage()));
            }
            processedFlowIndex++;
        }
    }
}
