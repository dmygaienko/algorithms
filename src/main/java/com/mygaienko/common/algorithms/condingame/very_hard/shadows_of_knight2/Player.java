//package com.mygaienko.common.algorithms.condingame.very_hard.shadows_of_knight2;


import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Game game = initGame(in);

        // game loop
        while (true) {

            BombDistance bombDistance = BombDistance.valueOf(in.next()); // Current distance to the bomb compared to previous distance (COLDER, WARMER, SAME or UNKNOWN)

            System.err.println(bombDistance);
            game.play(bombDistance);

        }

    }
    enum BombDistance {
        UNKNOWN, SAME, WARMER, COLDER
    }

    public static class Point {

        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isHigher(Point center) {
            return y < center.y;
        }

        public boolean isLieLeftTo(Point center) {
            return x < center.x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static class Map {
        int width;
        int height;

        public Map(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "Map{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }

        public Point getCenter() {
            return new Point(getWidth() / 2, getHeight() / 2);
        }
    }

    private static Game initGame(Scanner in) {
        return new Game(
                initMap(in),
                initMaxTurns(in),
                initFirstPosition(in));
    }

    private static int initMaxTurns(Scanner in) {
        int N = in.nextInt(); // maximum number of turns before game over.
        System.err.println("N: " + N);
        return N;
    }

    private static Point initFirstPosition(Scanner in) {
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        return new Point(X0, Y0);
    }

    private static Map initMap(Scanner in) {
        int width = in.nextInt(); // width of the building.
        int height = in.nextInt(); // height of the building.
        Map map = new Map(width, height);
        System.err.println("building: " + map);
        return map;
    }

    public static class Game {
        Map map;
        int maxTurns;
        Point position;

        int xMin = 0;
        int xMax;

        int yMin = 0;
        int yMax;

        AtomicBoolean axisFound = new AtomicBoolean(false);
        List<BombDistance> bombDistances = new ArrayList<>();
        List<Point> positions = new ArrayList<>();
        private List<BombDistance> warmerColder = Arrays.asList(BombDistance.WARMER, BombDistance.COLDER);

        public Game(Map map, int maxTurns, Point position) {
            this.map = map;
            this.maxTurns = maxTurns;
            this.position = position;
            this.xMax = map.width - 1;
            this.yMax = map.height - 1;
        }

        public Map getMap() {
            return map;
        }

        public void setMap(Map map) {
            this.map = map;
        }

        private void printPosition() {
            System.out.println(position);
        }

        private boolean notValid(Point position, Map map) {
            boolean result = position.getX() < 0 ||
                    position.getX() >= map.getWidth() ||
                    position.getY() < 0 ||
                    position.getY() >= map.getHeight();

            System.err.println("Position: " + position + " map: "  + map + " result: " + result);
            return result;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "map=" + map +
                    ", maxTurns=" + maxTurns +
                    ", position=" + position +
                    '}';
        }

        public void play(BombDistance bombDistance) {
            if (positions.size() > 0 && BombDistance.WARMER.equals(bombDistance)) {

                if (getPreviousPosition().x < getLastPosition().x) {
                    xMin = xMin + (getLastPosition().x - xMin)/2;
                } else {
                    xMax = xMax - (getLastPosition().x - xMax)/2;
                }

            } else if (positions.size() > 0 && BombDistance.COLDER.equals(bombDistance)) {

                if (getPreviousPosition().x < getLastPosition().x) {
                    xMax = xMax - (getLastPosition().x - xMax)/2;
                } else {
                    xMin = xMin + (getLastPosition().x - xMin)/2;
                }

            } else if (positions.size() > 0 && bombDistance.equals(BombDistance.SAME)) {
                if (getPreviousPosition().x < getLastPosition().x) {
                    xMax = getLastPosition().x;
                    xMin = getPreviousPosition().x;
                } else {
                    xMax = getPreviousPosition().x;
                    xMin = getLastPosition().x;
                }
            }

            int x = xMin + (xMax - xMin)/2;

            position = new Point(x, getLastPosition().y);
            positions.add(position);
            printPosition();
        }

        private Point getLastPosition() {
            return positions.get(positions.size() - 1);
        }

        private Point getPreviousPosition() {
            return positions.get(positions.size() - 2);
        }
    }

}
