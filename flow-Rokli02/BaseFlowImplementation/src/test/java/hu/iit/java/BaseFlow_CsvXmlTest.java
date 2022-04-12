package hu.iit.java;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseFlow_CsvXmlTest {
    private BaseFlow baseFlow;
    private final String EXAMPLE_CSV_TEST = "Jackson;53;purple";
    private final String EXAMPLE_XML_TEST = "<User><name>Jackson</name><age>53</age><favouriteColour>purple</favouriteColour></User>";

    @BeforeEach
    void init() {
        this.baseFlow = new BaseFlow_CsvXml(User.class, new XmlMapper());
    }

    @Test
    void setInputTest() {
        baseFlow.setInput(new Object[1]);
    }

    @Test
    void getOutputTest() {
        Object result = baseFlow.getOutput();

        assertNull(result);
    }

    @Test
    void doProcessInputMissingExceptionTest() {
        assertThrows(NotValidInputDataException.class, () -> {
            baseFlow.doProcess();
        });
    }

    @Test
    void doProcessNoDoubleConstructorExceptionTest() {
        String input = "Jackson;53.5;red";
        baseFlow.setInput(new String[] {input});

        assertThrows(NotValidInputDataException.class, () -> {
           baseFlow.doProcess();
        });
    }

    @Test
    void doProcessTest() {
        baseFlow.setInput(new String[] {EXAMPLE_CSV_TEST});
        baseFlow.doProcess();
        String[] result = (String[]) baseFlow.getOutput();

        assertNotNull(result[0]);
        assertEquals(EXAMPLE_XML_TEST, result);
    }
}