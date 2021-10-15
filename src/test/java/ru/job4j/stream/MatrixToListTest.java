package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void whenMatrixConvertToList() {
        Integer[][] source = {
                            {1, 5, 8},
                            {8, 12, 15},
                            {18, 22, 25, 78}
        };
        MatrixToList ml = new MatrixToList();
        List<Integer> rsl = ml.convertMatrixToList(source);
        List<Integer> expected = List.of(1, 5, 8, 8, 12, 15, 18, 22, 25, 78);
        assertThat(rsl, is(expected));
    }

}