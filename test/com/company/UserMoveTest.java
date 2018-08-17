package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMoveTest {

    @Test
    void checkReturnIntArray(){
        UserMove move = new UserMove("1,1");
        int[] result = {1,1};
        assertArrayEquals(result, move.getMove());
    }

}