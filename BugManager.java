
import java.util.ArrayList;
import java.util.List;

public class BugManager {

    private List<Bug> bugs = new ArrayList<>();
    private int nextBugId = 1;

    // Generate unique Bug ID
    public int generateBugId() {
        return nextBugId++;
    }

    // Add a new bug with input validation
    public Bug addBug(String title, String description,
                      String severity, String assignedDeveloper) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Bug title cannot be empty!");
        }

        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty!");
        }

        if (severity == null ||
            !(severity.equalsIgnoreCase("High") ||
              severity.equalsIgnoreCase("Medium") ||
              severity.equalsIgnoreCase("Low"))) {

            throw new IllegalArgumentException(
                "Severity must be High, Medium, or Low!"
            );
        }

        int bugId = generateBugId();

        Bug bug = new Bug(
            bugId,
            title.trim(),
            description.trim(),
            severity.trim(),
            assignedDeveloper
        );

        bugs.add(bug);

        return bug;
    }

    // Assign bug to a developer
    public boolean assignBug(int bugId, String developerName) {

        if (developerName == null || developerName.trim().isEmpty()) {
            return false;
        }

        for (Bug bug : bugs) {
            if (bug.getBugId() == bugId) {
                bug.setAssignedDeveloper(developerName.trim());
                bug.setStatus(BugStatus.ASSIGNED);
                return true;
            }
        }

        return false;
    }

    // Search bug using Bug ID
    public Bug searchBug(int bugId) {

        for (Bug bug : bugs) {
            if (bug.getBugId() == bugId) {
                return bug;
            }
        }

        return null;
    }

    // Update bug status
    public boolean updateBugStatus(int bugId, BugStatus newStatus) {

        if (newStatus == null) {
            return false;
        }

        Bug bug = searchBug(bugId);

        if (bug != null) {
            bug.setStatus(newStatus);
            return true;
        }

        return false;
    }

    // Display all bugs
    public List<Bug> getAllBugs() {
        return bugs;
    }
}
