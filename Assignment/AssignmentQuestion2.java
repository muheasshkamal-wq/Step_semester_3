class LibraryMember {
    String memberId;
    int borrowLimit;
    int booksBorrowed;

    LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    void displayInfo() {
        System.out.println("General Member | Books Borrowed: " + booksBorrowed);
    }
}


// StudentMember extends LibraryMember
class StudentMember extends LibraryMember {
    String course;

    StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    void displayInfo() {
        System.out.println("Student Member | Course: " + course +
                           " | Books Borrowed: " + booksBorrowed);
    }
}


// HonorsStudentMember extends StudentMember
class HonorsStudentMember extends StudentMember {
    int bonusLimit;

    HonorsStudentMember(String memberId, int borrowLimit,
                        String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    void displayInfo() {
        System.out.println("Honors Student Member | Course: " + course +
                           " | Bonus Limit: " + bonusLimit +
                           " | Books Borrowed: " + booksBorrowed);
    }
}


// FacultyMember directly extends LibraryMember
class FacultyMember extends LibraryMember {
    String department;

    FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    void displayInfo() {
        System.out.println("Faculty Member | Department: " + department +
                           " | Books Borrowed: " + booksBorrowed);
    }
}


// Main class
public class Main {

    // Identifies the inheritance generation using instanceof
    static String classifyGeneration(LibraryMember member) {

        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof StudentMember) {
            return "Student branch";
        }

        return "General Member";
    }


    // Adds books borrowed by all members
    static int getTotalBooksBorrowed(LibraryMember[] members) {

        int total = 0;

        for (LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }


    public static void main(String[] args) {

        LibraryMember generalMember =
            new LibraryMember("STU1", 3);

        StudentMember studentMember =
            new StudentMember("STU2", 3, "CSE");

        HonorsStudentMember honorsMember =
            new HonorsStudentMember("STU3", 3, "ECE", 2);

        FacultyMember facultyMember =
            new FacultyMember("STU4", 5, "Physics");


        // Display information
        generalMember.displayInfo();
        studentMember.displayInfo();
        honorsMember.displayInfo();
        facultyMember.displayInfo();


        // Classify members
        System.out.println(
            classifyGeneration(honorsMember)
        );

        System.out.println(
            classifyGeneration(facultyMember)
        );


        // Mixed array
        LibraryMember[] members = {
            generalMember,
            studentMember,
            honorsMember,
            facultyMember
        };

        System.out.println(
            "Total Books Borrowed: " +
            getTotalBooksBorrowed(members)
        );
    }
}
