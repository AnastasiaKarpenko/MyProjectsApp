package ws.tilda.anastasia.myprojects;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    public final LiveData<List<ProjectModel>> projectsListings;

    List<ProjectModel> projectsList = new ArrayList<>();

    MainViewModel(Application application) {
        super(application);
        projectsListings = ProjectRepository.getInstance().getProjectList();
    }

    public LiveData<List<ProjectModel>> getProjectsListObservable() {
        return projectsListings;
    }


}
