package models;

public class Manager extends Employee {
    private int teamSize;

    public Manager() {}

    public Manager(String name, String position, int teamSize) {
        super(name, position);
        this.teamSize = teamSize;
    }

    public int getTeamSize() { return teamSize; }
    public void setTeamSize(int teamSize) { this.teamSize = teamSize; }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Кількість підлеглих: " + teamSize;
    }
}
