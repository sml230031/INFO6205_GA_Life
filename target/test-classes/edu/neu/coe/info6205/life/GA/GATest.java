package edu.neu.coe.info6205.life.GA;

import edu.neu.coe.info6205.life.base.Point;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GATest {

    @Test
    public void testToInt(){
        boolean result = true;
        StringBuffer str = new StringBuffer();
        String a = "[[[0],[0],[0],[0],[0],[1],[0],[0],[0],[0]]";
        int[] b = GA.toInt(a);
        for(int i=0; i<b.length; i++) {
            System.out.print(b[i]);
            str.append(String.valueOf(b[i]));
        }
        assertTrue(result);
    }

    @Test
    public void testGetSeed(){
        String a = "[[[0],[0],[0],[0],[0],[1],[0],[0],[0],[0]],[[1],[1],[0],[1],[0],[0],[1],[1],[1],[1]],[[0],[1],[1],[1],[0]";
        System.out.println(GA.getSeed(a));
        assertEquals("0000010000110100111101110", GA.getSeed(a));
    }

    @Test
    public void testToPoints(){
        int[] a = {1,0,0,1,1,0,1,1,0,1,1,1,1,1,0,0,0,0,0,1};
        List<Point> points = GA.toPoints(a,4, 5);
        boolean result = true;

        for (Point point: points) {
            System.out.println(point.getX() +","+ point.getY());
            result = (point.getX()<4 && point.getY()<5);
        }
        assertTrue(result);
    }

    @Test
    public void testStrWritter(){
        String seed = "10101010";
        String str = "test11111";
        GA.stringWritter(seed, str);
    }
}
