package ws.tilda.anastasia.myprojects.project_listing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProjectListingModelTest {
    ProjectListingModel mProjectListingModel;
    Boolean check;

    @Before
    public void setUp() throws Exception {
        mProjectListingModel = new ProjectListingModel();
    }

    @Test
    public void getProjectListObservable() {
    }

    @Test
    public void isNetworkAvailable() {
        mProjectListingModel.isNetworkAvailable().subscribe(check -> {
            this.check = check;
        });

        assertTrue(check);
    }
}