package edu.neu.coe.info6205.life.GA;

import edu.neu.coe.info6205.life.base.Point;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GATest {

    @Test
    public void testToInt(){
        String a = "[[[0],[0],[0],[0],[0],[1],[0],[0],[0],[0]],[[1],[1],[0],[1],[0],[0],[1],[1],[1],[1]],[[0],[1],[1],[1],[0]";
        int[] b = GA.toInt(a);
        for(int i=0; i<b.length; i++) {
            System.out.print(b[i]);
        }
        assertEquals("0000010000110100111101110", GA.toInt(a));
    }

    @Test
    public void testToPoints(){
        int[] a = {1,0,0,1,1,0,1,1,0,1,1,1,1,1,0,0,0,0,0,1};
        List<Point> points = GA.toPoints(a,4, 5);

        for (Point point: points) {
            System.out.println(point.getX() +","+ point.getY());
        }
    }
}
