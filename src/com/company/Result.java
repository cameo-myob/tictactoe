package com.company;

public abstract class Result {

    enum Status {
        WIN ("Congratulations, you've won the game!"),
        DRAW ("Oh no, it's a draw!"),
        ERROR ("Something went wrong, please input another move:"),
        CONTINUE ("Move confirmed, here is the current board:");

        Status (String message){
            this.message = message;
        }

        public String getMessage(){
            return this.message;
        }

        private String message;
    }
    
    private final GameBoard board;
    private final Status status;

    @Override
    public boolean equals(Object other){
        return other instanceof Result &&
                this.getStatus().equals(((Result) other).getStatus());
    }

    public Result(GameBoard gb, Status s){
        this.board = gb;
        this.status = s;
    }

    Status getStatus(){
        return this.status;
    }

    GameBoard getBoard(){
        return this.board;
    }


    public static class Draw extends Result {
        public Draw(GameBoard gb) {
            super(gb, Status.DRAW);
        }

    }

    public static class Win extends Result {
        public Win(GameBoard gb) {
            super(gb, Status.WIN);
        }
    }

    public static class Error extends Result {
        public Error(GameBoard gb) {
            super(gb, Status.ERROR);
        }
    }

    public static class Success extends Result {
        public Success(GameBoard gb) {
            super(gb, Status.CONTINUE);
        }
    }

}
