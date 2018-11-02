package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    List<ProjectModel> projectsList = new ArrayList<>();

    public void setProjectList() {
        List<ProjectModel> dummyProjectList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.title = "Project " + i;
            dummyProjectList.add(projectModel);
        }
        projectsList.addAll(dummyProjectList);
    }

    public List<ProjectModel> getProjectsList() {
        return projectsList;
    }
}
