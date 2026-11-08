

from datetime import datetime

bugs = []
next_id = 1

while True:
    print("\n====== BUGBOARD ======")
    print("1. Log a Bug")
    print("2. Assign Developer")
    print("3. Update Bug Status")
    print("4. View All Bugs")
    print("5. View Reopen Counts")
    print("6. Open Bugs by Age")
    print("7. Module with Most Bugs")
    print("8. Exit")

    choice = input("Enter your choice: ")

    
    if choice == "1":
        print("\n--- LOG A NEW BUG ---")

        title = input("Enter bug title: ").strip()
        module = input("Enter module: ").strip()
        severity = input("Enter severity (Low/Medium/High): ").strip()
        steps = input("Enter steps to reproduce: ").strip()

        if not title or not module or not steps:
            print("Error: All fields are required!")

        elif severity.lower() not in ["low", "medium", "high"]:
            print("Error: Severity must be Low, Medium or High!")

        else:
            bug = {
                "id": next_id,
                "title": title,
                "module": module,
                "severity": severity,
                "steps": steps,
                "developer": "Unassigned",
                "status": "NEW",
                "reopen_count": 0,
                "status": "NEW",
                "reopen_count": 0,
                "created_at": datetime.now()
            }

            bugs.append(bug)
            next_id += 1

            print("Bug created successfully! ID:", bug["id"])

    
    elif choice == "2":
        print("\n--- ASSIGN DEVELOPER ---")

        bug_id = input("Enter bug ID: ").strip()
        developer = input("Enter developer name: ").strip()

        found = False

        for bug in bugs:
            if str(bug["id"]) == bug_id:
                found = True

                if not developer:
                    print("Error: Developer name cannot be empty!")

                elif bug["status"] not in ["NEW", "ASSIGNED", "REOPENED"]:
                    print("Error: Cannot assign bug in this status!")

                else:
                    bug["developer"] = developer
                    bug["status"] = "ASSIGNED"
                    print("Bug assigned successfully!")
                break

        if not found:
            print("Error: Bug ID not found!")

    
    elif choice == "3":
        print("\n--- UPDATE BUG STATUS ---")

        bug_id = input("Enter bug ID: ").strip()

        print("Statuses: NEW, ASSIGNED, FIXED, VERIFIED, CLOSED, REOPENED")
        new_status = input("Enter new status: ").strip().upper()

        allowed = {
            "NEW": [],
            "ASSIGNED": ["FIXED"],
            "FIXED": ["VERIFIED", "REOPENED"],
            "VERIFIED": ["CLOSED", "REOPENED"],
            "CLOSED": ["REOPENED"],
            "REOPENED": []
        }

        found = False

        for bug in bugs:
            if str(bug["id"]) == bug_id:
                found = True

                current = bug["status"]

                if new_status not in allowed:
                    print("Error: Invalid status!")

                elif new_status not in allowed[current]:
                    print("Error: Status change not allowed!")

                else:
                    bug["status"] = new_status

                    if new_status == "REOPENED":
                        bug["reopen_count"] += 1

                    print("Bug status updated to", new_status)

                break

        if not found:
            print("Error: Bug ID not found!")

    
    elif choice == "4":
        print("\n--- ALL REPORTED BUGS ---")

        if not bugs:
            print("No bugs have been reported yet.")

        else:
            for bug in bugs:
                print("--------------------------")
                print("Bug ID:", bug["id"])
                print("Title:", bug["title"])
                print("Module:", bug["module"])
                print("Severity:", bug["severity"])
                print("Steps:", bug["steps"])
                print("Developer:", bug["developer"])
                print("Status:", bug["status"])
                print("Reopen Count:", bug["reopen_count"])
                print("Created At:", bug["created_at"])

    
    elif choice == "5":
        print("\n--- BUG REOPEN COUNTS ---")

        if not bugs:
            print("No bugs have been reported yet.")

        else:
            for bug in bugs:
                print("--------------------------")
                print("Bug ID:", bug["id"])
                print("Title:", bug["title"])
                print("Reopened:", bug["reopen_count"], "times")

    
    elif choice == "6":
        print("\n--- OPEN BUGS BY AGE ---")

        open_bugs = []

        for bug in bugs:
            if bug["status"] != "CLOSED":
                open_bugs.append(bug)

        if not open_bugs:
            print("No open bugs found.")

        else:
            open_bugs.sort(key=lambda bug: bug["created_at"])

            for bug in open_bugs:
                age = datetime.now() - bug["created_at"]
                minutes = int(age.total_seconds() // 60)

                print("--------------------------")
                print("Bug ID:", bug["id"])
                print("Title:", bug["title"])
                print("Status:", bug["status"])
                print("Age:", minutes, "minutes")

    
    elif choice == "7":
        print("\n--- MODULE WITH MOST BUGS ---")

        if not bugs:
            print("No bugs found.")

        else:
            counts = {}

            for bug in bugs:
                module = bug["module"]
                counts[module] = counts.get(module, 0) + 1

            highest = max(counts.values())

            print("Bug counts by module:")

            for module, count in counts.items():
                print(module, ":", count)

            print("\nModule(s) with most bugs:")

            for module, count in counts.items():
                if count == highest:
                    print(module, "-", count, "bugs")

    elif choice == "8":
        print("Thank you for using BugBoard!")
        break

    else:
        print("Invalid choice! Please enter a number from 1 to 8.")
        
    input("\nPress Enter to return to the menu...")

