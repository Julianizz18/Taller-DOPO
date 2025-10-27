public class Sailor {
    private String name;
    private int rank;

    public Sailor(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sailor sailor = (Sailor) obj;
        return rank == sailor.rank && name.equals(sailor.name);
    }
}