public class Race {
    String leader = "";
    int distance = 0;
    public Race() {
        this.leader = "";
        this.distance = 0;
    }
    public Race(String name, int distance) {
        this.leader = name;
        this.distance = distance;
    }

    void identifyLeader(String newName, int newSpeed) {
        int newDistance = newSpeed * 24;
        if (newDistance > distance) {
            leader = newName;
            distance = newDistance;
        }
    }
}