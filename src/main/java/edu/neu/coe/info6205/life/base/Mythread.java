/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.base;

import edu.neu.coe.info6205.life.GA.GA;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/*
 * @author asus
 */
public class Mythread implements Callable {
     private int row;
     private int col;
     public Mythread(int row ,int col) {
         this.row=row;
         this.col=col;
     }


     @Override
     public List<Point> call(){
         GA ga =new GA(row,col);
         List<Point> points=new ArrayList<>();
         points=ga.run();
         return points;


     }
}
