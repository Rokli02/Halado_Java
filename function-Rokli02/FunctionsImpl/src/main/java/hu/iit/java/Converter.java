package hu.iit.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private Converter() { }

    public static Object[] getCsvToXmlConverter(Object[] inputArray) {
        ObjectMapper mapper = new XmlMapper();
        List<Object> result = new ArrayList();

        for(Object input: inputArray) {
            String[] splitProps = input.toString().split(";");
            if (splitProps.length <= 1) {
                throw new ErrorDuringConversionException("Error during csv to xml!");
            }
            User userToConvert;

            try {
                userToConvert = new User(splitProps[0], Integer.parseInt(splitProps[1]), splitProps[2]);
                result.add(mapper.writeValueAsString(userToConvert));
            } catch (NumberFormatException | JsonProcessingException err) {
                throw new ErrorDuringConversionException("Error during csv to xml!");
            }
        }

        return result.toArray();
    }

    public static Object[] getXmlToObjConverter(Object[] inputArray) {
        ObjectMapper mapper = new XmlMapper();
        List<Object> result = new ArrayList();

        for(Object input: inputArray) {
            try {
                result.add(mapper.readValue(input.toString(), User.class));
            } catch (JsonProcessingException e) {
                throw new ErrorDuringConversionException("Error during xml to object");
            }
        }

        return result.toArray();
    }

    public static Object[] getObjToAggResConverter(Object[] inputArray) {
        List<Object> result = new ArrayList();
        User[] users = new User[inputArray.length];

        for(int i = 0; i < users.length; i++) {
            users[i] = (User) inputArray[i];
        }

        try {
            AggregatedUser aggUser = new AggregatedUser(users);
            result.add(aggUser);
        } catch (RuntimeException err) {
            throw new ErrorDuringConversionException("Error during object To aggregated result!");
        }

        return result.toArray();
    }

    public static Object[] getAggResToCsv(Object[] inputArray) {
        List<Object> result = new ArrayList();

        for(Object input : inputArray) {
            AggregatedUser aggUser;
            try {
                aggUser = (AggregatedUser) input;
            } catch (RuntimeException err) {
                throw new ErrorDuringConversionException("Error during aggregated result to csv");
            }
            StringBuilder text = new StringBuilder();

            text.append(aggUser.getNumOfUser());
            text.append(";");

            text.append(aggUser.getAgeAverage());
            text.append(";");

            text.append(aggUser.getSmallestAge());
            text.append(";");

            text.append(aggUser.getLargestAge());
            text.append(";");

            text.append(aggUser.getMostOccurringColor());

            result.add(text.toString());
        }

        return result.toArray();
    }

    public static Object[] getAggResToXml(Object[] inputArray) {
        List<Object> result = new ArrayList();
        ObjectMapper mapper = new XmlMapper();

        for(Object input : inputArray) {
            try {
                result.add(mapper.writeValueAsString(input));
            } catch (JsonProcessingException e) {
                throw new ErrorDuringConversionException("Error during aggregated result to xml");
            }
        }

        return result.toArray();
    }
}
