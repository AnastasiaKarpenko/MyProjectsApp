package ws.tilda.anastasia.myprojects;

public interface MainContractor {

    interface MainView {

    }

    interface Presenter {
        void setUpPresenter(MainView mainView);
    }
}
