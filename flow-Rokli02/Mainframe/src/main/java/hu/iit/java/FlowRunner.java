package hu.iit.java;

import java.util.ArrayList;
import java.util.List;

public class FlowRunner {
    private List<BaseFlow> flows = new ArrayList();

    public FlowRunner() {}

    void addFlow(BaseFlow newFlow) {
        flows.add(newFlow);
    }

    int length() {
        return flows.size();
    }

    Object[] run(Object[] obj) {
        if (length() < 1) {
            return null;
        }

        Object[] result = new Object[obj.length];
        flows.get(0).setInput(obj);

        for(int i = 0; i < length(); i++) {
            flows.get(i).doProcess();

            if (i < length() - 1) {
                flows.get(i + 1).setInput(flows.get(i).getOutput());
            } else {
                result = flows.get(i).getOutput();
            }
        }
        return result;
    }
}
