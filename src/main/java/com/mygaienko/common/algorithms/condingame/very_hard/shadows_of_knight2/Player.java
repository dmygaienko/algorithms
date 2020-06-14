package com.mygaienko.common.algorithms.condingame.very_hard.shadows_of_knight2;


import java.util.*;



/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Game game = initGame(in);

        // game loop
        while (true) {

            String bombDir = in.next(); // Current distance to the bomb compared to previous distance (COLDER, WARMER, SAME or UNKNOWN)


            if ("UNKNOWN".equals(bombDir)) {

                if (game.getPosition().isHigher(game.getMap().getCenter())) {
                    game.goDirection(State.DOWN);
                } else {
                    game.goDirection(State.UP);
                }

            }

            if ("WARMER".equals(bombDir)) {
                game.keepDirection();
            }

            if ("COLDER".equals(bombDir)) {
                game.changeDirection();
            }

        }

    }

    enum State {

        UP {
            Point jumpFrom(Point previousPoint, Map map) {
                return new Point(previousPoint.getX(), previousPoint.getY() - map.getHeight()/4);
            }

            public State change() {
                return RIGHT;
            }
        },
        DOWN {
            Point jumpFrom(Point previousPoint, Map map) {
                return new Point(previousPoint.getX(), previousPoint.getY() + map.getHeight()/4);
            }

            public State change() {
                return LEFT;
            }
        },
        RIGHT {
            Point jumpFrom(Point previousPoint, Map map) {
                return new Point(previousPoint.getX() + map.getWidth()/4, previousPoint.getY());
            }

            public State change() {
                return DOWN;
            }
        },
        LEFT {
            Point jumpFrom(Point previousPoint, Map map) {
                return new Point(previousPoint.getX() - map.getWidth()/4, previousPoint.getY());
            }

            public State change() {
                return UP;
            }

        };

        abstract Point jumpFrom(Point previousPoint, Map map);

        Point jumpFromAndPrint(Point previousPoint, Map map) {
            Point nextPoint = jumpFrom(previousPoint, map);
            System.out.println(nextPoint);
            return nextPoint;
        }

        public abstract State change();
    }

    private static void jumpToPoint(Point center) {
        System.out.println(center.getX()+ " " + center.getY());
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
        State state;

        public Game(Map map, int maxTurns, Point position) {
            this.map = map;
            this.maxTurns = maxTurns;
            this.position = position;
        }

        public Map getMap() {
            return map;
        }

        public int getMaxTurns() {
            return maxTurns;
        }

        public Point getPosition() {
            return position;
        }

        public void setMap(Map map) {
            this.map = map;
        }

        public void setMaxTurns(int maxTurns) {
            this.maxTurns = maxTurns;
        }

        public void setPosition(Point position) {
            this.position = position;
        }

        public State getState() {
            return state;
        }

        public void goDirection(State state) {
            this.state = state;
            this.position = state.jumpFromAndPrint(position, map);
        }

        public void keepDirection() {
            this.position = state.jumpFromAndPrint(position, map);
        }

        public void changeDirection() {
            this.state = state.change();
            this.position = state.jumpFromAndPrint(position, map);
        }

        @Override
        public String toString() {
            return "Game{" +
                    "map=" + map +
                    ", maxTurns=" + maxTurns +
                    ", position=" + position +
                    '}';
        }


    }

}
