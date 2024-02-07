package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
    @Test
    public void whenTestPosition() {
        Cell actual = Cell.F8;
        BishopBlack bishopBlack = new BishopBlack(actual);
        Cell expected = bishopBlack.position();
        assertThat(actual.equals(expected));
    }

    @Test
    public void whenTestCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell actual = bishopBlack.copy(Cell.A3).position();
        Cell expected = bishopBlack.position();
        assertThat(actual.equals(expected));
    }

    @Test
    public void whenTestWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actual = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, actual);
    }
}
