package com.mygaienko.common.algorithms.condingame.very_hard.shadows_of_knight2;


import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


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

            System.err.println(bombDir);
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

            if ("COLDER".equals(bombDir) || "SAME".equals(bombDir)) {
                game.changeDirection();
            }

        }

    }

    enum State {

        UP {
            Point jumpFrom(Point previousPoint, Map map, Game game) {
                return new Point(previousPoint.getX(), previousPoint.getY() - game.speed);
            }

            public State change(boolean clockwise) {
                return clockwise ? RIGHT : LEFT;
            }
        },
        DOWN {
            Point jumpFrom(Point previousPoint, Map map, Game game) {
                return new Point(previousPoint.getX(), previousPoint.getY() + game.speed);
            }

            public State change(boolean clockwise) {
                return clockwise ? LEFT : RIGHT;
            }
        },
        RIGHT {
            Point jumpFrom(Point previousPoint, Map map, Game game) {
                return new Point(previousPoint.getX() + game.speed, previousPoint.getY());
            }

            public State change(boolean clockwise) {
                return clockwise ? DOWN : UP;
            }
        },
        LEFT {
            Point jumpFrom(Point previousPoint, Map map, Game game) {
                return new Point(previousPoint.getX() - game.speed, previousPoint.getY());
            }

            public State change(boolean clockwise) {
                return clockwise ? UP : DOWN;
            }

        };

        abstract Point jumpFrom(Point previousPoint, Map map, Game game);

        public abstract State change(boolean clockwise);
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

    enum Action { KEEP_DIRECTION, CHANGE_DIRECTION }

    public static class Game {
        Map map;
        int maxTurns;
        Point position;
        State state;

        int speed;

        boolean clockwise = true;

        Queue<Action> actionQueue = new LinkedBlockingQueue<>(4);

        List<Action> halfTurn = initHalfTurn();
        List<Action> fullTurn = initFullTurn();

        private List<Action> initHalfTurn() {
            return Arrays.asList(Action.CHANGE_DIRECTION, Action.CHANGE_DIRECTION);
        }

        private List<Action> initFullTurn() {
            return Arrays.asList(Action.CHANGE_DIRECTION, Action.CHANGE_DIRECTION, Action.CHANGE_DIRECTION, Action.CHANGE_DIRECTION);
        }

        public Game(Map map, int maxTurns, Point position) {
            this.map = map;
            this.maxTurns = maxTurns;
            this.position = position;
            this.speed = map.getHeight() < map.getWidth() ? map.getHeight()/4 : map.getWidth()/4;

        }

        public boolean addToActionHistory(Action action){
            System.err.println("actionQueue: " + actionQueue + " new Action: " + action);
            if (actionQueue.size() == 4) {
                actionQueue.poll();
            }
            boolean add = actionQueue.add(action);
            System.err.println("actionQueue: " + actionQueue);
            return add;
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
            System.err.println("State: " + state);
            this.state = state;
            Point nextPosition = state.jumpFrom(position, map, this);
            safelyGoToPoint(nextPosition, Action.KEEP_DIRECTION);
        }

        public void keepDirection() {
            System.err.println("keepDirection");
            Point nextPosition = state.jumpFrom(position, map, this);
            safelyGoToPoint(nextPosition, Action.KEEP_DIRECTION);
        }

        public void changeDirection() {
            System.err.println("changeDirection: actionQueue" + actionQueue);

            List<Action> queueView = new ArrayList<>(actionQueue);
            if (queueView.equals(fullTurn)) {
                System.err.println("actionQueue.containsAll(fullTurn)" + actionQueue);
                actionQueue.clear();
                this.clockwise = !clockwise;
            } else if (queueView.subList(2, 4).equals(halfTurn) && speed > 1) {
                System.err.println("actionQueue.containsAll(halfTurn");
                speed = speed/2;
            }
            this.state = state.change(clockwise);
            Point nextPosition = state.jumpFrom(position, map, this);
            System.err.println("changeDirection: nextPosition" + nextPosition);
            safelyGoToPoint(nextPosition, Action.CHANGE_DIRECTION);
        }

        private Point goToEdge(Point position, Map map) {
            System.err.println("goToEdge: position: " + position);
            int x = position.getX();
            int y = position.getY();

            if (x < 0) {
                x = 0;
            } else if (x >= map.getWidth()) {
                x = map.getWidth() - 1;
            }

            if (y < 0) {
                y = 0;
            } else if (y >= map.getHeight()) {
                y = map.getHeight() - 1;
            }

            Point point = new Point(x, y);
            System.err.println("goToEdge: position: " + position + " point: " + point);
            return point;
        }

        private void safelyGoToPoint(Point nextPosition, Action action) {
            System.err.println("safelyGoToPoint: nextPosition: " + nextPosition + " action: " + action );
            if (notValid(nextPosition, map)) {
                Point validNextPosition = goToEdge(nextPosition, map);

                boolean result = validNextPosition.equals(position);
                System.err.println("validNextPosition: " + validNextPosition + " position: " + position + " result " + result );
                if (result) {
                    changeDirection();
                } else {
                    printAndAddToHistory(action, validNextPosition);
                }


            } else {
                printAndAddToHistory(action, nextPosition);
            }
        }

        private void printAndAddToHistory(Action action, Point validNextPosition) {
            position = validNextPosition;
            System.out.println(position);
            addToActionHistory(action);
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

    }

}
