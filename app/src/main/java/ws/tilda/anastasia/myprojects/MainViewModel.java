package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends AndroidViewModel {
    public final LiveData<List<ProjectModel>> projectListing;


    @Inject
    ProjectRepository mProjectRepository;

    public MainViewModel(MainApplication application) {
        super(application);
        projectListing = mProjectRepository.getProjectList();
    }


    // Expose the LiveData Projects query so the UI can observe it.
    public LiveData<List<ProjectModel>> getProjectsListObservable() {
        return projectListing;
    }

}
