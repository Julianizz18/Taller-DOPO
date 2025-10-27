public class SubmarineCapsule extends Machine {
    private int depth;
    private Machine mothership;

    public SubmarineCapsule(Position pos, Machine mothership, int depth) {
        super(pos);
        this.mothership = mothership;
        this.depth = depth;
    }

    @Override
    public void destroy() {
        if (depth < 8000) {
            super.destroy();
            causeOfDestruction = "Se auto destruyó";
        }
    }

    public void autoDestroyIfMothershipDestroyed() {
        if (mothership != null && mothership.isDestroyed()) {
            destroy();
        }
    }

    @Override
    public boolean isWeak() {
        return false;
    }

    public boolean isImmune() {
        return depth >= 8000;
    }
}
