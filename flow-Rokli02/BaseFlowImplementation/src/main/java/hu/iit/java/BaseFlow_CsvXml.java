package hu.iit.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BaseFlow_CsvXml implements BaseFlow{
    private String[] flow;
    private String[] processedFlow;
    private Class<?> baseClass;
    private ObjectMapper mapper;

    BaseFlow_CsvXml(Class baseClass, ObjectMapper mapper) {
        this.processedFlow = null;
        this.baseClass = baseClass;
        this.mapper = mapper;
    }

   @Override
    public void setInput(Object[] obj) {
        flow = Arrays.stream(obj).map(value -> value.toString()).toArray(String[]::new);

    }

    @Override
    public Object[] getOutput() {
        return this.processedFlow;
    }

    @Override
    public void doProcess() throws NotValidInputDataException {
        try {
            this.processedFlow = new String[flow.length];
        } catch (NullPointerException err) {
            throw new NotValidInputDataException("Input is not set!");
        }
        int processedFlowIndex = 0;
        for(String value: flow) {
            Object[] csvPropsBefore = value.split(";");
            Object[] csvProps = new Object[csvPropsBefore.length];
            Class[] parameterTypes = new Class[csvPropsBefore.length];

            int index = 0;

            for (Object obj : csvPropsBefore) {
                if(obj.toString().matches("^-?\\d+[.]\\d+$")){
                    csvProps[index] = Double.parseDouble(obj.toString());
                }
                else if(obj.toString().matches("^-?\\d+$")){
                    csvProps[index] = Integer.parseInt(obj.toString());
                }
                else {
                    csvProps[index] = obj;
                }

                parameterTypes[index] = csvProps[index].getClass();
                index++;
            }

            try {

                Object csvToObject = baseClass.getConstructor(parameterTypes).
                        newInstance(csvProps);
                this.processedFlow[processedFlowIndex] = mapper.writeValueAsString(csvToObject);

            } catch (Exception err) {
                throw new NotValidInputDataException("Some problems occured during the conversion!");
            }
            processedFlowIndex++;
        }

    }
}
