package hu.iit.java;

import java.util.List;
import java.util.function.UnaryOperator;

public class ConvertRunner {
    List<UnaryOperator<Object[]>> list;
    Object[] endResult;

    public ConvertRunner(List<UnaryOperator<Object[]>> list) {
        this.list = list;
    }

    public void addConverter(UnaryOperator<Object[]> function){
        this.list.add(function);
    }

    public void run(Object[] input) {
        if(list.isEmpty()){
            this.endResult = null;
            return;
        }
        endResult = new Object[input.length];
        Object[] localVar = input;

        for(UnaryOperator<Object[]> func : list) {
            try {
                localVar = func.apply(localVar);
            } catch (ErrorDuringConversionException err) {
                this.endResult = new Object[] {"Couldn't convert!\nSome problems occurred meanwhile!\n\t"+err.getMessage()};
                return;
            }
        }

        this.endResult = localVar;
    }

    public Object[] getResult() {
        return endResult;
    }
}
