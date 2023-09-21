package presenters;

import java.util.Date;

public interface ViewObserver {
    void onReservationTable(Date orderDate, int tableNo, String name);
    void onChangereservationTable(int oldreservationDate, Date reservationDate,int tableNo, String name);

}
