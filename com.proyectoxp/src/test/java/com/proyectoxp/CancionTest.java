package com.proyectoxp;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class CancionTest extends TestCase{
    @Test
    public void testCancion() {
        Cancion cancion = new Cancion("Test Title", "3:30");
        assertEquals("Test Title", cancion.getTitulo());
        assertEquals("3:30", cancion.getDuracion());
    }

    @Test
    public void testCancionEmptyTitle() {
        Cancion cancion = new Cancion("", "3:30");
        assertEquals("", cancion.getTitulo());
        assertEquals("3:30", cancion.getDuracion());
    }

    @Test
    public void testCancionEmptyDuration() {
        Cancion cancion = new Cancion("Test Title", "");
        assertEquals("Test Title", cancion.getTitulo());
        assertEquals("", cancion.getDuracion());
    }

    @Test
    public void testCancionNullTitle() {
        Cancion cancion = new Cancion(null, "3:30");
        assertNull(cancion.getTitulo());
        assertEquals("3:30", cancion.getDuracion());
    }

    @Test
    public void testCancionNullDuration() {
        Cancion cancion = new Cancion("Test Title", null);
        assertEquals("Test Title", cancion.getTitulo());
        assertNull(cancion.getDuracion());
    }

    @Test
    public void testCancionLongDuration() {
        Cancion cancion = new Cancion("Test Title", "123:45");
        assertEquals("Test Title", cancion.getTitulo());
        assertEquals("123:45", cancion.getDuracion());
    }

    @Test
    public void testCancionLongTitle() {
        String longTitle = "A".repeat(1000);
        Cancion cancion = new Cancion(longTitle, "3:30");
        assertEquals(longTitle, cancion.getTitulo());
        assertEquals("3:30", cancion.getDuracion());
    }

    @Test
    public void testCancionSpecialCharacters() {
        Cancion cancion = new Cancion("Test @#$%^&*()", "3:30");
        assertEquals("Test @#$%^&*()", cancion.getTitulo());
        assertEquals("3:30", cancion.getDuracion());
    }
}