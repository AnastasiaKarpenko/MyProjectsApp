package ws.tilda.anastasia.myprojects.project_listing;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import ws.tilda.anastasia.myprojects.injection.MainApplication;

public class MainPresenter extends AndroidViewModel implements MainContractor.Presenter {

    public final LiveData<List<ProjectModel>> projectListings;

    @Inject
    ProjectRepository projectRepository;

    MainContractor.MainView mainView;

    @Inject
    public MainPresenter(Application application) {
        super(application);
        MainApplication.getMainApplication().getMainComponent().inject(this);
        projectListings = projectRepository.getProjectList();
    }

    @Override
    public void setUpPresenter(MainContractor.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public LiveData<List<ProjectModel>> getProjectListObservable() {
        return projectListings;
    }

}
