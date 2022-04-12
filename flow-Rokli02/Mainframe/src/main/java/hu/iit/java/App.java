package hu.iit.java;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        String[] csvText = {"Janika;20;blue", "Eper Kálmán;15;purple"};
        //String[] xmlText = {"<User><name>Janos</name><age>20</age><favouriteColour>purple</favouriteColour></User>"};

        Object[] result;
        FlowRunner runner = new FlowRunner();

        runner.addFlow(new BaseFlow_CsvXml(User.class, new XmlMapper()));
        runner.addFlow(new BaseFlow_XmlMemArr(User.class, new XmlMapper()));

        try {
            result = runner.run(csvText);
            System.out.println(Arrays.toString(result));
        } catch(NotValidInputDataException err) {
            System.err.println(err.getMessage());
        }
    }
}
