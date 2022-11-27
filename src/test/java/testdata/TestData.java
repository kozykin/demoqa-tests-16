package testdata;

import com.github.javafaker.Faker;
import java.util.Random;

public class TestData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userPhone = faker.phoneNumber().subscriberNumber(10),
            userLocation = faker.address().fullAddress(),
            userGender = userGender(),
            userBirthDay = userBirthDay(),
            userBirthMonth = userBirthMonth(),
            userBirthYear = userBirthYear(),
            userSubject =userSubject(),
            userHobby = userHobby(),
            userPicture="tst.jpg",
            userState = "NCR",
            userCity = "Delhi";

    public static int randomizerInt(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max-min)+1)+min;
    }
    public static String userSubject(){
        String[] subject = {"English", "Chemistry", "Physics", "Maths", "Biology", "Economics", "Accounting"};
        int index = randomizerInt(0, subject.length-1);
        String userSubject = String.valueOf(subject[index]);
        return userSubject;
    }
    public static String userGender(){
        String[] userGender = {"Male", "Female", "Other"};
        int index = randomizerInt(0, userGender.length-1);
        return userGender[index];
    }

    public static String userHobby(){
        String[] userHobby = {"Sports", "Reading", "Music"};
        int index = randomizerInt(0, userHobby.length-1);
        return userHobby[index];
    }

    public static String userBirthMonth(){
        String[] userBirthMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int index = randomizerInt(0, userBirthMonth.length-1);
        return userBirthMonth[index];
    }
    public static String userBirthDay(){
        int userBirthDay = randomizerInt(1,28);
        for (int i=1; i<=9; i++){
            if (userBirthDay==i){
                String dayStr="0"+userBirthDay;
                return dayStr;
            }
        }
        return userBirthDay+"";
    }
    public static String userBirthYear(){
        int userBirthYear = randomizerInt(1920,2010);
        return userBirthYear+"";
    }


}
