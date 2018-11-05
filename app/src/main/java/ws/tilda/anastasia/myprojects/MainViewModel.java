package ws.tilda.anastasia.myprojects;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends AndroidViewModel {
    public final LiveData<List<ProjectModel>> projectListing;


    @Inject
    ProjectRepository mProjectRepository;

    public MainViewModel(Application application) {
        super(application);
//        MainApplication.getMainApplication().getMainComponent().inject(this);
        projectListing = mProjectRepository.getProjectList();
    }


    // Expose the LiveData Projects query so the UI can observe it.
    public LiveData<List<ProjectModel>> getProjectsListObservable() {
        return projectListing;
    }

}
