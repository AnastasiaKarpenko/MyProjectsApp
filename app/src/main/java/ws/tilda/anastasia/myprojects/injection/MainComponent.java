package ws.tilda.anastasia.myprojects.injection;

import javax.inject.Singleton;

import dagger.Component;
import ws.tilda.anastasia.myprojects.project_listing.MainPresenter;

@Singleton
@Component(modules = ProjectModule.class)
public interface MainComponent {

    void inject(MainApplication mainApplication);

    void inject(MainPresenter mainPresenter);
}
