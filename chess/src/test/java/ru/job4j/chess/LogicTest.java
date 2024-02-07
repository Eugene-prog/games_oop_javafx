package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        PawnBlack pawnBlack = new PawnBlack(Cell.E7);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.F8, Cell.D6);
        });
        assertThat(exception.getMessage()).
                isEqualTo("Cell is occupied by a figure, no move possible");
    }

    @Test
    public void whenMoveImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        PawnBlack pawnBlack = new PawnBlack(Cell.E7);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.F8, Cell.D8);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from F8 to D8");
    }
}