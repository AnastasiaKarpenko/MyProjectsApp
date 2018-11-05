package ws.tilda.anastasia.myprojects;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    public final LiveData<List<ProjectModel>> projectListing;

    public MainViewModel(Application application) {
        super(application);
        projectListing = ProjectRepository.getInstance().getProjectList();
    }

    public LiveData<List<ProjectModel>> getProjectsListObservable() {
        return projectListing;
    }


}
