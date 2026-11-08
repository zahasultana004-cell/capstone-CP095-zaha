
public class Main {

    public static void main(String[] args) {

        BugManager manager = new BugManager();

        // 1. Create bugs
        System.out.println("===== BUG TRACKING SYSTEM =====");

        Bug bug1 = manager.addBug(
            "Login Button Not Working",
            "User cannot login to the application",
            "High",
            "Unassigned"
        );

        Bug bug2 = manager.addBug(
            "Page Loading Slowly",
            "Dashboard takes too long to load",
            "Medium",
            "Unassigned"
        );

        System.out.println("\n1. BUG CREATION");
        System.out.println("Bug created with ID: " + bug1.getBugId());
        System.out.println("Bug created with ID: " + bug2.getBugId());

        // 2. Input validation
        System.out.println("\n2. INPUT VALIDATION");

        try {
            manager.addBug("", "Test description", "High", "Unassigned");
        } catch (IllegalArgumentException e) {
            System.out.println("Empty title rejected: " + e.getMessage());
        }

        try {
            manager.addBug("Payment Error", "Payment failed", "Urgent", "Unassigned");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid severity rejected: " + e.getMessage());
        }

        // 3. Assign developer
        System.out.println("\n3. DEVELOPER ASSIGNMENT");

        boolean assigned = manager.assignBug(1, "Rahul");

        System.out.println(assigned
            ? "Bug assigned to Rahul successfully!"
            : "Bug assignment failed!");

        // 4. Update bug status
        System.out.println("\n4. BUG STATUS UPDATE");

        boolean updated = manager.updateBugStatus(
            1, BugStatus.IN_PROGRESS
        );

        System.out.println(updated
            ? "Bug status updated to IN_PROGRESS!"
            : "Status update failed!");

        // 5. Search bug
        System.out.println("\n5. BUG SEARCH");

        Bug searchedBug = manager.searchBug(1);

        if (searchedBug != null) {
            System.out.println("Bug found successfully!");
            System.out.println(searchedBug);
        } else {
            System.out.println("Bug not found!");
        }

        // 6. Display all bugs
        System.out.println("\n6. DISPLAY ALL BUGS");

        for (Bug bug : manager.getAllBugs()) {
            System.out.println(bug);
            System.out.println("-------------------------");
        }

        System.out.println("===== TESTING COMPLETED =====");
    }
}
