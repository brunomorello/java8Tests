package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumRoundsToCompleteAllTasksTest {

    private MinimumRoundsToCompleteAllTasks underTest = new MinimumRoundsToCompleteAllTasks();

    @Test
    void should_complete_all_tasks_in_4_rounds() {
        assertEquals(4, underTest.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
    }

    @Test
    void should_not_complete_all_task_and_return_minus_1() {
        assertEquals(-1, underTest.minimumRounds(new int[]{3,2,3}));
    }

    @Test
    void should_complete_all_tasks_in_2_rounds() {
        assertEquals(2, underTest.minimumRounds(new int[]{7,7,7,7,7,7}));
    }

    @Test
    void should_complete_all_tasks_in_20_rounds() {
        assertEquals(20, underTest.minimumRounds(new int[]{69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69}));
    }

}