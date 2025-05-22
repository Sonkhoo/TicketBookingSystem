package Ticket.Booking.entities;

import java.util.List;
import java.util.Map;

public class Train {

    private String trainId;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String, Integer> stationTime;
    private List<String> stations;
}
