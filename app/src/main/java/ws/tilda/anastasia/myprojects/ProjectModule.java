package ws.tilda.anastasia.myprojects;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectModule {
    MainApplication mMainApplication;

    public ProjectModule(MainApplication application) {
        mMainApplication = application;
    }

    @Provides
    @Singleton
    List<ProjectModel> providesProjectList() {
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
    ProjectRepository providesProjectRepository(List<ProjectModel> projectModelList) {
        return new ProjectRepository(projectModelList);
    }

    @Provides
    @Singleton
    MainAdapter providesMainAdapter () {
        return new MainAdapter(mMainApplication.getApplicationContext());
    }
}
