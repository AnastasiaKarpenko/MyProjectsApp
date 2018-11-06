package ws.tilda.anastasia.myprojects.project_listing;

import android.arch.lifecycle.LiveData;

import java.util.List;

public interface MainContractor {

    interface MainView {

    }

    interface Presenter {
        void setUpPresenter(MainView mainView);
        public LiveData<List<ProjectModel>> getProjectListObservable();
    }
}
