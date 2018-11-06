package ws.tilda.anastasia.myprojects.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ws.tilda.anastasia.myprojects.project_listing.MainAdapter;
import ws.tilda.anastasia.myprojects.project_listing.ProjectRepository;

@Module
public class ProjectModule {
    MainApplication mMainApplication;

    public ProjectModule(MainApplication application) {
        mMainApplication = application;
    }


    @Provides
    @Singleton
    ProjectRepository providesProjectRepository() {
        return new ProjectRepository();
    }

    @Provides
    @Singleton
    MainAdapter providesMainAdapter() {
        return new MainAdapter(mMainApplication.getApplicationContext());
    }
}
