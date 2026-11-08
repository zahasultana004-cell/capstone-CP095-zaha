
bugs = []

while True:
    print("\n====== BUGBOARD ======")
    print("1. Log New Bug")
    print("2. Assign Developer")
    print("3. Update Bug Status")
    print("4. View All Bugs")
    print("5. Search Bug")
    print("6. View Reopen Counts")
    print("7. Open Bugs by Age")
    print("8. Module with Most Bugs")
    print("9. Exit")

    choice = input("Enter your choice: ")

    if choice == "9":
        print("Thank you for using BugBoard!")
        break
    elif choice in ["1", "2", "3", "4", "5", "6", "7", "8"]:
        print("Feature will be added next.")
    else:
        print("Invalid choice!")

