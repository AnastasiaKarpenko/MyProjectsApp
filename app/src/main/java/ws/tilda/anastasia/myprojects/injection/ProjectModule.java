package ws.tilda.anastasia.myprojects.injection;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ws.tilda.anastasia.myprojects.MainAdapter;
import ws.tilda.anastasia.myprojects.ProjectModel;
import ws.tilda.anastasia.myprojects.ProjectRepository;
import ws.tilda.anastasia.myprojects.injection.MainApplication;

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
            projectModel.setTitle("Project " + i);
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
