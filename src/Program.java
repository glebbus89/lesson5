import models.TableModel;
import presenters.BokingPresenter;
import views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: Домашняя работа
     * Метод changeReservationTable должен заработать!
     * @param args аргументы командной строки
     */

    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BokingPresenter bokingPresenter = new BokingPresenter(model,view);
        bokingPresenter.updateTablesUI();

        view.reservationTable(new Date(), 3, "Станислав");

        view.changeReservationTable(101, new Date(), 1, "Станислав");
    }
}
