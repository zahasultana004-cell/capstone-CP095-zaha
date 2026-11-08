
import java.time.LocalDateTime;

public class Bug {

    private int bugId;
    private String title;
    private String description;
    private String severity;
    private BugStatus status;
    private String assignedDeveloper;
    private LocalDateTime createdDate;

    public Bug(int bugId, String title, String description,
               String severity, String assignedDeveloper) {

        this.bugId = bugId;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = BugStatus.NEW;
        this.assignedDeveloper = assignedDeveloper;
        this.createdDate = LocalDateTime.now();
    }

    public int getBugId() {
        return bugId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public BugStatus getStatus() {
        return status;
    }

    public void setStatus(BugStatus status) {
        this.status = status;
    }

    public String getAssignedDeveloper() {
        return assignedDeveloper;
    }

    public void setAssignedDeveloper(String assignedDeveloper) {
        this.assignedDeveloper = assignedDeveloper;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "Bug ID: " + bugId +
               "\nTitle: " + title +
               "\nDescription: " + description +
               "\nSeverity: " + severity +
               "\nStatus: " + status +
               "\nAssigned Developer: " + assignedDeveloper +
               "\nCreated Date: " + createdDate;
    }

}
