package ru.stqa.pft.annotate.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.annotate.model.ProposeData;

public class TaskPerformingTests extends TestBase {

  @Test
  public void testTaskPerforming() {
    app.getNavigationHelper().gotoInterface();
    app.getTaskHelper().initTask();
    app.getTaskHelper().selectionRussianText();
    app.getTaskHelper().chooseErrorType();
    app.getTaskHelper().chooseSeverity();
    app.getTaskHelper().submitAnnotate();
    app.getTaskHelper().gotoProposeGlossaryTerms();
    app.getTaskHelper().selectionEnglishText();
    app.getTaskHelper().fillProposedTranslationField(new ProposeData("о которой"));
    app.getTaskHelper().submitProposeGlossaryTerms();
    app.getTaskHelper().gotoFinishOrReport();
    app.getTaskHelper().chooseTaskFluency();
    app.getTaskHelper().fillTaskComment(new ProposeData("привет"));
    app.getTaskHelper().submitFinishOrReport();
    app.getTaskHelper().acceptFinishingJob();
  }

}
