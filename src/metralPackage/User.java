package metralPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<UserContent> userContentList = new ArrayList<>();
    public int getUerSize() {
        return userContentList.size();
    }
    public void RegisterUser(String firstName, String lastName, int age){
        int id = getUerSize() + 1;
        UserContent content = new UserContent(firstName, lastName, age, id);
            userContentList.add(content);
    }
    public String findUserById(int id) {
        for (UserContent usercontent : userContentList) {
            if (usercontent.getId() == id)
                return String.format("""
                        ======================
                        First Name: %s
                        LastName: %s
                        Age: %d
                        ======================
                        """, usercontent.getFirstName(), usercontent.getLastName(),
                        usercontent.getAge());
        }
        return null;
    }
    public List<String> calculateMenstrualCycle(String lastDayString, int months) {
        List<String> cycleDates = new ArrayList<>();
        LocalDate lastDay = LocalDate.parse(lastDayString);
        LocalDate nextCycle = lastDay;
        for (int i = 1; i <= months; i++) {
            nextCycle = nextCycle.plusDays(28);
            int diffDays = (int) ChronoUnit.DAYS.between(lastDay, nextCycle);
            int extraDays = diffDays % 28;
            nextCycle = nextCycle.minusDays(extraDays);
            String formattedDate = nextCycle.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            cycleDates.add(formattedDate);
            lastDay = nextCycle;
        }
        return cycleDates;
    }

    public String findUserByName(String firstName, String lastName, int age) {
        for (UserContent userContent: userContentList) {
            if (userContent.getFirstName().equals(firstName) && userContent.getLastName().equals(lastName)
            && userContent.getAge() == age)
                return String.format("""
                        =======================
                        FirstName: %s
                        LastName: %s
                        Age: %d
                        =======================
                        """, userContent.getFirstName(), userContent.getLastName(), userContent.getAge());
        }
        return null;
    }

    public void delete(int id) {
        userContentList.removeIf(usercontent -> usercontent.getId() == id);
    }
}


