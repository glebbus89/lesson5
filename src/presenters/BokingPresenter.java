package presenters;


import models.Table;
import models.TableModel;
import views.BookingView;

import java.util.Collection;
import java.util.Date;

public class BokingPresenter implements ViewObserver {

    private final Model tableModel;

    private final View bookingView;

    public BokingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }

    public Collection<Table> loadTables(){
        return tableModel.loadTables();
    }
    public void updateTablesUI(){
        bookingView.showTables(loadTables());
    }

    public void updateReservationResultUI(int reservationId){
        bookingView.printReservationTableResult(reservationId);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int raservationNo = tableModel.reservationTable(orderDate,tableNo,name);
        updateReservationResultUI(raservationNo);
    }

    public void printReservationTableResultChange(int reservationNo){
        bookingView.printReservationTableResult(reservationNo);
    }

    @Override
    public void onChangereservationTable(int oldReservation, Date orderDate, int tableNo, String name) {
        int reservatioNo = tableModel.changeReservationTable(oldReservation,orderDate, tableNo,name);
        printReservationTableResultChange(reservatioNo);

    }
}
