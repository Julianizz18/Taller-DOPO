public class SubmarineCapsule extends Machine {
    private int depth;
    private Machine mothership;
    private boolean destroyed;

    public SubmarineCapsule(Position pos, Machine mothership, int depth) {
        super(pos);
        this.mothership = mothership;
        this.depth = depth;
        this.destroyed = false;
    }

    public void destroy() {
        if (depth < 8000) {
            destroyed = true;
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isWeak() {
        return false;
    }

    public void regesInstructions() {
        
    }
}

