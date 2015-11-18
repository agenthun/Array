package com.agenthun.movetosiliconvalley;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by agenthun on 15/11/18.
 */
public class FindBestLine {
    class Line {
        double epsilon = 0.0001;
        double slope;
        double intercept;
        boolean infiniteSlope = false;

        public Line(Point p, Point q) {
            if (Math.abs(p.x - q.x) > epsilon) {
                slope = (p.y - q.y) / (p.x - q.x);//斜率
                intercept = p.y - slope * p.x;
            } else {
                infiniteSlope = true;
                intercept = p.x;
            }
        }

        public boolean isEqual(double a, double b) {
            return (Math.abs(a - b) < epsilon);
        }

        @Override
        public boolean equals(Object o) {
            Line l = (Line) o;
            if (isEqual(l.slope, slope) &&
                    isEqual(l.intercept, intercept) &&
                    (infiniteSlope == l.infiniteSlope)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int s1 = (int) (slope * 1000);
            int in = (int) (intercept * 1000);
            return s1 | in;
        }
    }

    Line findBestLine(Point[] points) {
        Line bestLine = null;
        HashMap<Line, Integer> lineCount = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                if (!lineCount.containsKey(line)) {
                    lineCount.put(line, 1);
                }
                lineCount.put(line, lineCount.get(line) + 1);
                if (bestLine == null ||
                        lineCount.get(line) > lineCount.get(bestLine)) {
                    bestLine = line;
                }
            }
        }
        return bestLine;
    }
}
