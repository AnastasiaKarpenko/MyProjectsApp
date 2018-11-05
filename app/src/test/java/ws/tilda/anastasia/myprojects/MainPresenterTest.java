package ws.tilda.anastasia.myprojects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class MainPresenterTest {
    @Mock
    MainContractor.MainView mMainView;

    @Mock
    MainPresenter mMainPresenter;

    @Before
    public void setUpMainPresenter() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProjectsListObservable() {
        mMainPresenter.getProjectsListObservable();
        verify(mMainPresenter).getProjectsListObservable();
    }

    @Test
    public void setUpPresenter() {
        mMainPresenter.setUpPresenter(mMainView);
        verify(mMainPresenter).setUpPresenter(mMainView);
    }
}