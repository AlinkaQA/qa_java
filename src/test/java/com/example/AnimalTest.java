package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getFamily_ReturnsExpectedString() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test(expected = Exception.class)
    public void getFood_ThrowsException_WhenTypeIsUnknown() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Растениеядное");
    }

    @Test
    public void getFood_ReturnsCorrectFood_ForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    public void getFood_ReturnsCorrectFood_ForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }
}
