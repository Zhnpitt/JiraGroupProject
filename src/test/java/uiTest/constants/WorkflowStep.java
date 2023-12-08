package uiTest.constants;

public enum WorkflowStep {
    Open("Open"),
    ToDo("To Do"),
    InProgress("In Progress"),
    Resolved("Resolved"),
    Closed("Closed");


    private final String step;

    WorkflowStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return step;
    }

}
