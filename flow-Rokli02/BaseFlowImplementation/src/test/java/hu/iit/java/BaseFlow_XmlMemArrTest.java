package hu.iit.java;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseFlow_XmlMemArrTest {
    private BaseFlow baseFlow;
    private final String EXAMPLE_XML_TEST = "<User><name>Jackson</name><age>53</age><favouriteColour>purple</favouriteColour></User>";
    private final String EXAMPLE_OBJ_TEST = "User{name='Jackson', age=53, favouriteColour='purple'}";

    @BeforeEach
    void init() {
        this.baseFlow = new BaseFlow_XmlMemArr(User.class, new XmlMapper());
    }

    @Test
    void setInputTest() {
        baseFlow.setInput(new String[] {EXAMPLE_XML_TEST});
    }

    @Test
    void getOutputTest() {
        Object result = baseFlow.getOutput();

        assertNull(result);
    }

    @Test
    void doProcessWithoutInputExceptionTest() {
        assertThrows(NotValidInputDataException.class, () -> {
                baseFlow.doProcess();
        });
    }

    @Test
    void doProcessText() {
        User user;

        baseFlow.setInput(new String[] {EXAMPLE_XML_TEST});
        baseFlow.doProcess();
        Object[] objectArray = baseFlow.getOutput();
        user = (User) objectArray[0];

        assertNotNull(user);
        assertEquals(EXAMPLE_OBJ_TEST, user.toString());
    }
}