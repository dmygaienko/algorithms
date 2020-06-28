//package com.mygaienko.common.algorithms.condingame.very_hard.shadows_of_knight2;


import java.util.*;


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

        boolean axisFound = false;
        
        List<BombDistance> bombDistances = new ArrayList<>();
        List<Point> positions = new ArrayList<>();

        private List<BombDistance> warmerColder = Arrays.asList(BombDistance.WARMER, BombDistance.COLDER);

        public Game(Map map, int maxTurns, Point position) {
            this.map = map;
            this.maxTurns = maxTurns;
            this.position = position;
            this.xMax = map.width - 1;
            this.yMax = map.height - 1;

            positions.add(position);
        }

        public Map getMap() {
            return map;
        }

        public void setMap(Map map) {
            this.map = map;
        }

        private void printPosition() {
            addPosition(position);
            System.out.println(position);
        }

        private void addPosition(Point position) {
            positions.add(position);
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
            bombDistances.add(bombDistance);

            if (!axisFound && oneWarmOneCold()) {
                axisFound = true;
                Point previousPosition = getPreviousPosition();
                addPosition(previousPosition);
                System.err.println("Axis found - " + previousPosition);
            }

            if (axisFound) {
                position = computeX(bombDistance);
            } else {
                position = computeY(bombDistance);
            }

            printPosition();
        }

        private boolean oneWarmOneCold() {
            if (positions.size() < 3) {
                return false;
            }

            int previosSpeed = getPreviosSpeedY();
            int lastSpeed = getLastSpeedY();
            return getLastTwoBombDistances().equals(warmerColder) &&
                    previosSpeed == lastSpeed && Math.abs(previosSpeed) == 1;
        }

        private int getLastSpeedY() {
            return getLastPosition().y - getPreviousPosition().y;
        }

        private int getLastSpeedX() {
            return getLastPosition().x - getPreviousPosition().x;
        }

        private int getPreviosSpeedY() {
            return getPreviousPosition().y - getPreviousPreviousPosition().y;
        }

        private List<BombDistance> getLastTwoBombDistances() {
            return bombDistances.subList(bombDistances.size() - 2, bombDistances.size());
        }

        private Point computeY(BombDistance bombDistance) {
            if (positions.size() > 0 && BombDistance.WARMER.equals(bombDistance)) {

                if (getPreviousPosition().y < getLastPosition().y) {
                    yMin = yMin + (int) Math.round((getLastPosition().y - yMin)/2d);
                    if (yMin < getPreviousPosition().y) {
                        yMin = getPreviousPosition().y;
                    }
                } else {
                    yMax = yMax - (int) Math.round((yMax - getLastPosition().y)/2d);
                    if (yMax > getPreviousPosition().y) {
                        yMax = getPreviousPosition().y;
                    }
                }

            } else if (positions.size() > 1 && BombDistance.COLDER.equals(bombDistance)) {

                if (getPreviousPosition().y < getLastPosition().y) {
                    yMax = yMax - (int) Math.round((yMax - getLastPosition().y)/2d);
                    if (yMax > getPreviousPosition().y) {
                        yMax = getPreviousPosition().y;
                    }
                } else {
                    yMin = yMin + (int) Math.round((getLastPosition().y - yMin)/2d);
                    if (yMin < getPreviousPosition().y) {
                        yMin = getPreviousPosition().y;
                    }
                }

            } else if (positions.size() > 1 && bombDistance.equals(BombDistance.SAME)) {
                if (getPreviousPosition().y < getLastPosition().y) {
                    yMax = getLastPosition().y;
                    yMin = getPreviousPosition().y;
                } else {
                    yMax = getPreviousPosition().y;
                    yMin = getLastPosition().y;
                }
            }
            int y = (int) Math.round(yMin + (yMax - yMin)/2d);

            if (y == getLastPosition().y) {
                y = y + (getLastSpeedY()/Math.abs(getLastSpeedY()));

                if (y < 0 || y == map.height) {
                    y = y - (getLastSpeedY()/Math.abs(getLastSpeedY()));
                }
            }

            System.err.println(String.format("xMin - %s, xMax - %s", xMin, xMax));
            System.err.println(String.format("yMin - %s, yMax - %s", yMin, yMax));
            return new Point(getLastPosition().x, y);
        }

        private Point computeX(BombDistance bombDistance) {
            if (positions.size() > 0 && BombDistance.WARMER.equals(bombDistance)) {

                if (getPreviousPosition().x < getLastPosition().x) {
                    xMin = xMin + (int) Math.round((getLastPosition().x - xMin)/2d);
                    if (xMin < getPreviousPosition().x) {
                        xMin = getPreviousPosition().x;
                    }
                } else if (getPreviousPosition().x > getLastPosition().x) {
                    xMax = xMax - (int) Math.round((xMax - getLastPosition().x)/2d);
                    if (xMax > getPreviousPosition().x) {
                        xMax = getPreviousPosition().x;
                    }
                }

            } else if (positions.size() > 1 && BombDistance.COLDER.equals(bombDistance)) {

                if (getPreviousPosition().x < getLastPosition().x) {
                    xMax = xMax - (int) Math.round((xMax - getLastPosition().x)/2d);
                    if (xMax > getPreviousPosition().x) {
                        xMax = getPreviousPosition().x;
                    }
                } else  if (getPreviousPosition().x > getLastPosition().x) {
                    xMin = xMin + (int) Math.round((getLastPosition().x - xMin)/2d);
                    if (xMin < getPreviousPosition().x) {
                        xMin = getPreviousPosition().x;
                    }
                }

            } else if (positions.size() > 1 && bombDistance.equals(BombDistance.SAME)) {
                if (getPreviousPosition().x < getLastPosition().x) {
                    xMax = getLastPosition().x;
                    xMin = getPreviousPosition().x;
                } else {
                    xMax = getPreviousPosition().x;
                    xMin = getLastPosition().x;
                }
            }
            int x = xMin + (int) Math.round((xMax - xMin)/2d);

            if (x == getLastPosition().x) {
                x = x + (getLastSpeedX()/Math.abs(getLastSpeedX()));

                if (x < 0 || x == map.width) {
                    x = x - (getLastSpeedX()/Math.abs(getLastSpeedX()));
                }
            }

            System.err.println(String.format("xMin - %s, xMax - %s", xMin, xMax));
            System.err.println(String.format("yMin - %s, yMax - %s", yMin, yMax));
            return new Point(x, getLastPosition().y);
        }

        private Point getLastPosition() {
            return positions.get(positions.size() - 1);
        }

        private Point getPreviousPosition() {
            return positions.get(positions.size() - 2);
        }

        private Point getPreviousPreviousPosition() {
            return positions.get(positions.size() - 3);
        }
    }

}
