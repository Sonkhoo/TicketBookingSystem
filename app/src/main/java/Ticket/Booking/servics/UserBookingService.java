package Ticket.Booking.servics;

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
     /**
      * This constructor is defined because the User needs to be passed
      * in order to maintain the state of the user
      * that is the user that is making the booking
      */
     UserBookingService(User user) {
         this.user = user;
     }
}
