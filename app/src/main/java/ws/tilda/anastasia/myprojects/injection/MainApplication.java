package ws.tilda.anastasia.myprojects.injection;

import android.app.Application;

public class MainApplication extends Application {

    private static MainApplication mMainApplication;
    MainComponent mainComponent;

    public static MainApplication getMainApplication() {
        return mMainApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mMainApplication = this;

        initMainComponent();

        mainComponent.inject(this);
    }

    private void initMainComponent() {
        mainComponent = DaggerMainComponent.builder()
                .projectModule(new ProjectModule(this))
                .build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
