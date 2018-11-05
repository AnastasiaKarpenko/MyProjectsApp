package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    List<ProjectModel> projectsList = new ArrayList<>();

    public void setProjectList() {

    }

    public List<ProjectModel> getProjectsList() {
        return projectsList;
    }
}
