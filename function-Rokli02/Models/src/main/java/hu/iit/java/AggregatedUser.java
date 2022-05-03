package hu.iit.java;

import java.util.HashMap;
import java.util.Map;

public class AggregatedUser {
    private int numOfUser;
    private double ageAverage;
    private int smallestAge;
    private int largestAge;
    private String mostOccurringColor;

    public AggregatedUser(int numOfUser, double ageAverage, int smallestAge, int largestAge, String mostOccurringColor) {
        this.numOfUser = numOfUser;
        this.ageAverage = ageAverage;
        this.smallestAge = smallestAge;
        this.largestAge = largestAge;
        this.mostOccurringColor = mostOccurringColor;
    }

    public AggregatedUser(User[] users) {
        if(users.length < 1) {
            return;
        }

        this.numOfUser = users.length;
        double ageSum = 0;
        this.smallestAge = users[0].getAge();
        this.largestAge = 0;
        Map<String, Integer> colors = new HashMap();

        for(User user : users) {
            ageSum += user.getAge();
            if(this.smallestAge > user.getAge()) {
                this.smallestAge = user.getAge();
            }
            if(this.largestAge < user.getAge()) {
                this.largestAge = user.getAge();
            }
            if(!colors.containsKey(user.getFavoriteColor())){
                colors.put(user.getFavoriteColor(), 1);
            } else {
                colors.put(user.getFavoriteColor(), colors.get(user.getFavoriteColor()) + 1);
            }
        }
        this.ageAverage = ageSum / users.length;

        int largestCount = 0;
        for(String colorName : colors.keySet()){
            if(colors.get(colorName) > largestCount) {
                largestCount = colors.get(colorName);
                this.mostOccurringColor = colorName;
            }
        }
    }

    public int getNumOfUser() {
        return numOfUser;
    }

    public double getAgeAverage() {
        return ageAverage;
    }

    public int getSmallestAge() {
        return smallestAge;
    }

    public int getLargestAge() {
        return largestAge;
    }

    public String getMostOccurringColor() {
        return mostOccurringColor;
    }

    @Override
    public String toString() {
        return "AggregatedUser{" +
                "numOfUser=" + numOfUser +
                ", ageAverage=" + ageAverage +
                ", smallestAge=" + smallestAge +
                ", largestAge=" + largestAge +
                ", mostOccuringColor='" + mostOccurringColor + '\'' +
                '}';
    }
}
