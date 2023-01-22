package src;

public class Students {
    public int SID;
    public String Name;
    public String Program;
    public String Address;

    public Students(int SID, String name, String program, String address) {
        this.SID = SID;
        Name = name;
        Program = program;
        Address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
                "SID=" + SID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
