package model.player;

public class PlayerImpl implements Player {

    private String name;
    private final PlayerColor color;
    private int boardPosition;

    public PlayerImpl(final String name, final PlayerColor color) {
        if ("".equals(name)) {
            throw new IllegalStateException();
        }
        this.name = name;
        this.color = color;
        this.boardPosition = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int getBoardPosition() {
        return boardPosition;
    }

    @Override
    public void addPosition(final int diceValue) {
        this.boardPosition += diceValue;
    }

    @Override
    public void resetPosition() {
        this.boardPosition = 0;
    }

    @Override
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "PlayerImpl [name=" + name + ", color=" + color + ", boardPosition=" + boardPosition + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + boardPosition;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayerImpl other = (PlayerImpl) obj;
        if (boardPosition != other.boardPosition) {
            return false;
        }
        if (color != other.color) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
