package ws.tilda.anastasia.myprojects;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectModule {

    public ProjectModule(Application application) {

    }

    @Provides
    @Singleton
    List<ProjectModel> provideProjectList() {
        List<ProjectModel> dummyProjectList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.title = "Project " + i;
            dummyProjectList.add(projectModel);
        }
        return dummyProjectList;
    }

    @Provides
    @Singleton
    ProjectRepository providesProjectRepository(List<ProjectModel> projectList) {
        return new ProjectRepository(projectList);
    }
}
