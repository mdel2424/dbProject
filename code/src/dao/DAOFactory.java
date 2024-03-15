package dao;

import java.util.HashMap;
import java.util.Map;

public class DAOFactory {

    private static final Map<String, GenericDAO> daoMap = new HashMap<>();

    static {
        // Initialize DAOs here
        daoMap.put("hotelChain", new HotelChainDAO());
        daoMap.put("hotel", new HotelDAO());
        daoMap.put("booking", new BookingDAO());
        daoMap.put("employee", new EmployeeDAO());
        daoMap.put("reservation", new ReservationDAO());
        daoMap.put("room", new RoomDAO());
        daoMap.put("booking", new BookingDAO());
        
    }

    public static GenericDAO getDAO(String daoType) {
        return daoMap.get(daoType);
    }
}
