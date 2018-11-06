package ws.tilda.anastasia.myprojects.injection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ws.tilda.anastasia.myprojects.project_listing.MainAdapter;
import ws.tilda.anastasia.myprojects.project_listing.ProjectListingModel;

@Module
public class ProjectModule {
    Application mApplication;

    public ProjectModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    ProjectListingModel provideProjectListModel() {
        return new ProjectListingModel();
    }

    @Provides
    @Singleton
    MainAdapter providesMainAdapter() {
        return new MainAdapter(mApplication.getApplicationContext());
    }
}
