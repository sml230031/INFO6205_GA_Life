package edu.neu.coe.info6205.life.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Point;
import io.jenetics.*;
import io.jenetics.engine.*;
import io.jenetics.util.IntRange;
import io.jenetics.engine.Limits.*;
import io.jenetics.engine.EvolutionStatistics.*;
import static io.jenetics.engine.EvolutionResult.toBestPhenotype;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;




public class GA {

    int rows;
    int cols;

    public GA(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public static List<Point> toPoints(int[][] gt){

        Game game = new Game();
        List<Point> points = new ArrayList<>();
        for(int i=0; i < gt.length; i++)
            for(int j=0; j < gt[i].length; j++){
//                System.out.println(gt[i][j]);
                if (gt[i][j] == 1){
                    points.add(new Point(i,j));
                }
            }
        if (points.isEmpty()){
                points.add(new Point(1,1));
        }
        return points;
    }

    public static List<Point> toPoints(int[] nums, int rows, int cols){
        List<Point> points = new ArrayList<>();
        int index=0;
        for(int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                index = i*cols+j;
                if (nums[index] == 1) {
                    points.add(new Point(i, j));
                }
            }

        }
        return points;
    }

    public static Long eval(int[][] gt){
        List<Point> points = toPoints(gt);
        Game.MaxGenerations = 100;
        return Game.run(0L, points, Game.MaxGenerations).generation;
    }


    public List<Point> run(String[] args) {
        final Engine<IntegerGene, Long> engine = Engine.builder(GA::eval, Codecs.ofMatrix(IntRange.of(0, 1), this.rows, this.cols)).optimize(Optimize.MAXIMUM).populationSize(200000).alterers(
                new Mutator<>(0.2),
                new MeanAlterer<>(0.35)).build();

        final EvolutionStatistics<Integer, ?> statistics = EvolutionStatistics.ofNumber();

        final Phenotype<IntegerGene, Long> result = engine.stream().limit(Limits.bySteadyFitness(5)).limit(Limits.byExecutionTime(Duration.ofMillis(500))).limit(1000).collect(toBestPhenotype());
        System.out.println(result);
        System.out.println(result.toString());

        String p = result.toString();
        int[] nums = toInt(result.toString());

        return toPoints(nums, rows, cols);


    }

    public static int[] toInt(String string){

        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(string);
        String str = m.replaceAll("").trim();

        int[] result = new int[str.length()];

        char[] chars = str.toCharArray();
        for (int i=0; i < str.length(); i++){
            char a = chars[i];
            result[i] = Integer.parseInt(String.valueOf(a));
        }
        return result;
    }


//    public static List<Point> toPoints(String str){
//
//    }
}

