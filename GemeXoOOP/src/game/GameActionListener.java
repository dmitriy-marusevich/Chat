package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static game.GameBoard.nullSymbol;

public class GameActionListener implements ActionListener  {
    private boolean ex = false;
    private boolean LS_MOD =false;
    private int row; // номер ряда
    private  int cell; // номер клетки
    private GameButton button; // клетка выбора

    public GameActionListener(int row, int cell, GameButton gButton){ // передает ряд и номер клетки выбора
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard(); // получаем поле

        if(board.isTurnable(row, cell)){ // проверка занятости клетки
            updateByPlayersData(board); // ставим символ игрока

            if(board.isFull()){ // проверка заполнености поля
                board.getGame().showMessage("Ничья!"); // сообщение о ничьей
                board.emptyField(); // сброс поля

            } else{
                updateByAiData(board); // ставится символ ИИ
            }
        } else{
            board.getGame().showMessage("Некоректный ход!"); // клетка не пустая и поле не заполнено выводим сообщение
        }
    }

    /**
     * Ход человека
     * @param board GameBoard - ссылка на игровое поле
     */
    private void updateByPlayersData(GameBoard board){
        // обновить матрицу игры
        board.updateGameField(row, cell);

        // обновить содержимое кнопки
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSing()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Вы победили!");
            board.emptyField(); // сброс поля

        } else {
            board.getGame().passTurn();
        }
    }
    /**
     * Ход компьютера
     * @param board GameBoard - ссылка на игровое поле
     */
    private void updateByAiData(GameBoard board){
        Random rnd = new Random();

        // генерация координат компьютера
        if(LS_MOD) {
            int x, y;


            do {
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            } while (!board.isTurnable(x, y));
            // обновить матрицу игры
            board.updateGameField(x, y);

            // обновить содержимое кнопки
            int cellIndex = GameBoard.dimension * x + y;
            board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSing()));
//

        } else {
            int x = rnd.nextInt(GameBoard.dimension);
            int y = rnd.nextInt(GameBoard.dimension);
            do{
                for(int i = 0; i<GameBoard.dimension; i++) {
                    if (ex) {
                        break;
                    } else {
                        for (int j = 0; j < GameBoard.dimension; j++) {
                            if (board.isTurnable(i, j)) {
                                if (board.isBoxWin(i, j)) {
                                    x = i;
                                    y = j;
                                    ex = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            } while (!board.isTurnable(x, y));
            // обновить матрицу игры
            board.updateGameField(x, y);



            // обновить содержимое кнопки
            int cellIndex = GameBoard.dimension * x + y;
            board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSing()));

        } ex =false;
        //проверяем победу
        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Компьютер выиграл");
            board.emptyField();
        } else{
            // передать ход
            board.getGame().passTurn();
        }

    }

}
