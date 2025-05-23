package Ticket.Booking.servics;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Ticket.Booking.entities.User;

public class UserBookingService {
    /*
     * Login
     * Signup
     * Fetch Bookings
     * Cancel Booking
     * Book Tickets
     */
    private User user;
    private List<User> userList ;
    private static final ObjectMapper ObjectMapper = new ObjectMapper();
    
     /**
      * This constructor is defined because the User needs to be passed
      * in order to maintain the state of the user
      * that is the user that is making the booking
      */

    private static final String userPath = "src/main/java/Ticket/Booking/localDB/users.json";

     UserBookingService(User user) throws IOException {
         this.user = user;
         File users = new File(userPath);
            try {
                /*
                 * This line of code reads the contents of the users.json file into a Java List   of User objects using the ObjectMapper from the Jackson library.
                ObjectMapper is a class that provides functionality for converting between Java objects and JSON data. The readValue() method is used to deserialize JSON data into a Java object.In this specific case, the readValue() method is being used to read the contents of the users.json file (represented by the users variable) into a Java List of User objects, which is then assigned to the userList variable.The new TypeReference<List<User>>() {} part is an anonymous subclass of TypeReference that provides the type information needed to deserialize the JSON data into a List of User objects.
                 */
                userList = ObjectMapper.readValue(users, new TypeReference<List<User>>() {});
            } 
            catch (IOException e) {
                // Handle the exception, for example:
                System.err.println("Error reading users file: " + e.getMessage());
            }
     }

    public boolean Login(String userId, String password) {
        Optional<User> user = userList.stream().filter(u -> u.getUserId().equals(userId) && u.getPassword().equals(password)).findFirst();
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
