package dev.alexferreira.tddproject.ui.view;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import dev.alexferreira.tddproject.R;
import dev.alexferreira.tddproject.application.RoboletricApplication;
import dev.alexferreira.tddproject.ui.contract.MainContract;

@RunWith(RobolectricTestRunner.class)
@Config(application = RoboletricApplication.class, sdk = 28)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Mock
    private MainContract.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mainActivity = Robolectric.buildActivity(MainActivity.class, new Intent()).create().start().get();
        mainActivity.setPresenter(presenter);
    }

    @Test
    public void whenSelectFab_callPresenter() {
        mainActivity.findViewById(R.id.fab_add).performClick();

        Mockito.verify(presenter).selectAddReceita();
    }
}