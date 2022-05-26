package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player first = new Player(1, "first", 1);
    private Player second = new Player(2, "second", 2);
    private Player third = new Player(3, "third", 3);
    private Player fourth = new Player(4, "fourth", 3);
    private Player fifth = new Player(5, "fifth", 100);

    @BeforeEach
    void setUp() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
    }

    @Test
    void shouldWinFirstPlayer() {
        int actual = game.round(fourth.getName(), second.getName());

        assertEquals(1, actual);
    }

    @Test
    void shouldWinSecondPlayer() {
        int actual = game.round(first.getName(), second.getName());

        assertEquals(2, actual);
    }

    @Test
    void shouldDraw() {
        int actual = game.round(third.getName(), fourth.getName());

        assertEquals(0, actual);
    }

    @Test
    void shouldThrowException() {
        assertThrows(RuntimeException.class,
                () -> game.round(third.getName(), fifth.getName())
);
    }
}