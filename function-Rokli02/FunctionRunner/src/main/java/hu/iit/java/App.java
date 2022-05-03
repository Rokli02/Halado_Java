package hu.iit.java;

import java.util.ArrayList;
import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        ConvertRunner runner = new ConvertRunner(new ArrayList<>());
        String[] word = new String[] {"Roli;21;purple", "András;12;yellow", "Richard;30;purple", "Andrew;23;blue", "Réka;15;red"};

        runner.addConverter(Converter::getCsvToXmlConverter);
        runner.addConverter(Converter::getXmlToObjConverter);
        runner.addConverter(Converter::getObjToAggResConverter);
        runner.addConverter(Converter::getAggResToXml);
        runner.addConverter(Converter::getAggResToCsv);

        runner.run(word);
        System.out.println(Arrays.toString(runner.getResult()));
    }

}
