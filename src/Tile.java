public abstract class Tile
{
    // A chess board has 64 tiles i.e. (8x8)
    //to represent a tile number we use a tile coordinate:
    int tileCoordinateNumber;
    Tile(int tileCoordinateNumber)
    {
        this.tileCoordinateNumber = tileCoordinateNumber;
    }
    public abstract boolean isTileOccupancy();
    public abstract Piece getPiece();

    //sub-classes that represent an empty tile or an occupied tile.
    public static final class EmptyTile extends Tile {
        EmptyTile(int coord) {
            super(coord);
        }

        @Override
        public boolean isTileOccupancy() {
            return false;
        }

        public Piece getPiece() {
            // Since there is no piece on an empty tile hence an empty tile will return null
            return null;
        }
    }
        public static final class OccupiedTile extends Tile
        {
            Piece pieceOnThatTile;
            OccupiedTile(int tileCoordinateNumber, Piece pieceOnThatTile)
            {
                super(tileCoordinateNumber);
                this.pieceOnThatTile = pieceOnThatTile;
            }
            @Override
            public boolean isTileOccupancy() {
                return true;
            }

            @Override
            public Piece getPiece()
            {
                return this.pieceOnThatTile;
            }
        }

}
