package ws.tilda.anastasia.myprojects.project_listing;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ProjectListingModelTest {
    ProjectListingModel mProjectListingModel;
    Boolean check;
    List<ProjectModel> projectModelList;

    @Before
    public void setUp() throws Exception {
        mProjectListingModel = new ProjectListingModel();
    }

    @Test
    public void getProjectListObservable() {
        mProjectListingModel.getProjectListObservable().subscribe(projectModelList -> {
            this.projectModelList = projectModelList;
        });
        assertNotNull(projectModelList);
    }

    @Test
    public void isNetworkAvailable() {
        mProjectListingModel.isNetworkAvailable().subscribe(check -> {
            this.check = check;
        });

        assertTrue(check);
    }
}