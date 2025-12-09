package exercice.un;

import java.io.Serializable;

public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double score;

    public Record(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getScore() { return score; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setScore(double score) { this.score = score; }

    @Override
    public String toString() {
        return "Record{id=" + id + ", name='" + name + "', score=" + score + "}";
    }
}

