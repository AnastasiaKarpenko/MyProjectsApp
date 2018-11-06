package ws.tilda.anastasia.myprojects.project_listing;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import ws.tilda.anastasia.myprojects.injection.MainApplication;

public class MainPresenter extends AndroidViewModel implements MainContractor.Presenter {

    public final LiveData<List<ProjectModel>> projectListing;

    @Inject
    ProjectRepository mProjectRepository;

    MainContractor.MainView mMainView;

    @Inject
    public MainPresenter(Application application) {
        super(application);
        MainApplication.getMainApplication().getMainComponent().inject(this);
        projectListing = mProjectRepository.getProjectList();
    }


    // Expose the LiveData Projects query so the UI can observe it.
    public LiveData<List<ProjectModel>> getProjectsListObservable() {
        return projectListing;
    }

    @Override
    public void setUpPresenter(MainContractor.MainView mainView) {
        mMainView = mainView;
    }
}
