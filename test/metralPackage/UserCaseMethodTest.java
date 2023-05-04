package metralPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserCaseMethodTest {
    User user;
    UserContent userContent;
    @BeforeEach
    public void startWith(){
        user = new User();

        int sizeBeforeRegisterUser = user.getUerSize();
        assertEquals(0, sizeBeforeRegisterUser);
        String firstName = "Joy";
        String lastName = "King Face";
        int age = 21;
        user.RegisterUser(firstName, lastName, age);

        int sizeBeforeAnotherUseRegisters = user.getUerSize();
        assertEquals(1, sizeBeforeAnotherUseRegisters);
        String firstName2 = "Ugochi";
        String lastName2 =  "King Face";
        int  age2 =  23;
        user.RegisterUser(firstName2, lastName2, age2);

        String firstName4 = "glory";
        String lastName4 = "utokutu";
        int age4 = 34;
        user.RegisterUser(firstName4, lastName4, age4);
    }
    @Test
    public void testThatObjectExist(){
        assertNotNull(user);
    }
    @Test
    public void testThatUserCanBeCreated(){;
        int sizeAfterCreatingUser = user.getUerSize();
        assertEquals(2, sizeAfterCreatingUser);
    }
    @Test
    public void testThatCountInCreaseTo2WhenAnotherUserRegisters(){
        int sizeAfterCreatingAnotherUser = user.getUerSize();
        assertEquals(2, sizeAfterCreatingAnotherUser);
    }
//    @Test
//    public void testThatUserCanBeFoundById(){
//        String User = user.findUserById(2);
//    }
    @Test
    public void testCalculateMenstrualCycle() {
        User user = new User();
        user.RegisterUser("Jane", "Doe", 25);
        List<String> expectedCycleDates = Arrays.asList("2023-04-29", "2023-05-27", "2023-06-24", "2023-07-22");
        List<String> actualCycleDates = user.calculateMenstrualCycle("2023-04-01", 4);
        assertEquals(expectedCycleDates, actualCycleDates);
    }
//    @Test
//    public void testThatYouCanFindUserByName(){
//        int getTheSizeOfTheUserRegistered = user.getUerSize();
//        assertEquals(3, getTheSizeOfTheUserRegistered);
//        String findUser = user.findUserByName("glory", "utokutu");
//        assertEquals("glory", findUser.getFirstName());
//    }
}