package ws.tilda.anastasia.myprojects;

import android.app.Application;

public class MainApplication extends Application {

    private static MainApplication mMainApplication;
    MainComponent mMainComponent;

    public static MainApplication getMainApplication() {
        return mMainApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mMainApplication = this;
        initializeComponents();
        mMainComponent.inject(this);
    }

    private void initializeComponents() {
        mMainComponent = DaggerMainComponent.builder()
                .projectModule(new ProjectModule(this))
                .build();
    }

    public MainComponent getMainComponent() {
        return  mMainComponent;
    }
}
