//package com.mygaienko.common.algorithms.condingame.very_hard.shadows_of_knight2;


import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
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

            game.addBombDistance(bombDistance);

            System.err.println(bombDistance);
            if (BombDistance.UNKNOWN.equals(bombDistance)) {

                if (game.getPosition().isHigher(game.getMap().getCenter())) {
                    game.makeFirstMove(State.DOWN);
                } else {
                    game.makeFirstMove(State.UP);
                }

            }

            if (BombDistance.WARMER.equals(bombDistance)) {
                game.keepDirection();
            }

            if (BombDistance.COLDER.equals(bombDistance)) {
                game.changePointToMoveFrom();
            }

            if (BombDistance.SAME.equals(bombDistance)) {
                game.goToCentrePoint();
            }

        }

    }
    enum BombDistance {
        UNKNOWN, SAME, WARMER, COLDER
    }

    enum State {

        UP {
            Point jumpFrom(Point previousPoint, Map map, Game game) {
                return new Point(previousPoint.getX(), previousPoint.getY() - getSpeed(game.speed));
            }

            public State makeAturn() {
                return RIGHT;
            }

            public State turnAround() {
                return DOWN;
            }

            int getSpeed(Speed speed) {
                return speed.verticalSpeed;
            }

            Speed pressBrake(Speed speed) {
                speed.verticalSpeed = Game.safelyPressBrake(speed.verticalSpeed);
                return speed;
            }

            Speed pressGas(Speed speed, Game game) {
                speed.verticalSpeed = speed.verticalSpeed * 2;
                return speed;
            }


        },
        DOWN {
            Point jumpFrom(Point previousPoint, Map map, Game game) {
                return new Point(previousPoint.getX(), previousPoint.getY() + getSpeed(game.speed));
            }

            public State makeAturn() {
                return LEFT;
            }

            public State turnAround() {
                return UP;
            }

            int getSpeed(Speed speed) {
                return speed.verticalSpeed;
            }

            Speed pressBrake(Speed speed) {
                speed.verticalSpeed = Game.safelyPressBrake(speed.verticalSpeed);
                return speed;
            }

            Speed pressGas(Speed speed, Game game) {
                speed.verticalSpeed = speed.verticalSpeed * 2;
                return speed;
            }

        },
        RIGHT {
            Point jumpFrom(Point previousPoint, Map map, Game game) {
                return new Point(previousPoint.getX() + getSpeed(game.speed), previousPoint.getY());
            }

            public State makeAturn() {
                return DOWN;
            }

            public State turnAround() {
                return LEFT;
            }

            int getSpeed(Speed speed) {
                return speed.horizontalSpeed;
            }

            Speed pressBrake(Speed speed) {
                speed.horizontalSpeed = Game.safelyPressBrake(speed.horizontalSpeed);
                return speed;
            }

            Speed pressGas(Speed speed, Game game) {
                speed.horizontalSpeed = speed.horizontalSpeed * 2;
                return speed;
            }

        },
        LEFT {
            Point jumpFrom(Point previousPoint, Map map, Game game) {
                return new Point(previousPoint.getX() - getSpeed(game.speed), previousPoint.getY());
            }

            public State makeAturn() {
                return UP;
            }

            public State turnAround() {
                return RIGHT;
            }

            int getSpeed(Speed speed) {
                return speed.horizontalSpeed;
            }

            Speed pressBrake(Speed speed) {
                speed.horizontalSpeed = Game.safelyPressBrake(speed.horizontalSpeed);
                return speed;
            }

            Speed pressGas(Speed speed, Game game) {
                speed.horizontalSpeed = speed.horizontalSpeed * 2;
                return speed;
            }


        };

        abstract Point jumpFrom(Point previousPoint, Map map, Game game);

        abstract State makeAturn();

        abstract State turnAround();

        abstract int getSpeed(Speed speed);

        abstract Speed pressBrake(Speed speed);

        abstract Speed pressGas(Speed speed, Game game);

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

    public static class Speed {
        int horizontalSpeed;
        int verticalSpeed;

        public Speed(int horizontalSpeed, int verticalSpeed) {
            this.horizontalSpeed = horizontalSpeed;
            this.verticalSpeed = verticalSpeed;
        }

        @Override
        public String toString() {
            return "{" +
                    "hor=" + horizontalSpeed +
                    ",vert=" + verticalSpeed +
                    '}';
        }

        public Speed copy() {
            return new Speed(horizontalSpeed, verticalSpeed);
        }
    }


    public static class Game {
        Map map;
        int maxTurns;
        Point position;
        State state;
        Speed speed;

        AtomicBoolean axisFound = new AtomicBoolean(false);

        Queue<BombDistance> bombDistanceQueue = new LinkedBlockingQueue<>(4);
        Queue<Speed> speedQueue = new LinkedBlockingQueue<>(4);

        List<Point> positionQueue = new ArrayList<>();

        private List<BombDistance> warmerColder = Arrays.asList(BombDistance.WARMER, BombDistance.COLDER);

        public Game(Map map, int maxTurns, Point position) {
            this.map = map;
            this.maxTurns = maxTurns;
            this.position = position;
            this.speed = new Speed(getStartHorizontalSpeed(), getStartVerticalSpeed());
        }

        private int getStartVerticalSpeed() {
            return map.getHeight() / 2;
        }

        private int getStartHorizontalSpeed() {
            return map.getWidth() / 2;
        }

        public static int safelyPressBrake(int speed) {
            return speed >= 2 ? (int) Math.round((double) speed / 2) : 1;
        }

        public boolean addToSpeedHistory(Speed speed){
            if (speedQueue.size() == 4) {
                speedQueue.poll();
            }
            return speedQueue.add(speed);
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

        public void makeFirstMove(State state) {
            System.err.println("State: " + state);
            this.state = state;
            Point nextPosition = new Point(position.getX(), map.getCenter().getY());
            System.err.println("First move nextPosition: " + nextPosition);
            printAndAddToHistory(nextPosition);
        }

        public void keepDirection() {
            System.err.println("keepDirection");
            speed = state.pressBrake(speed);
            Point nextPosition = state.jumpFrom(position, map, this);
            safelyGoToPoint(nextPosition);
        }

        public void changePointToMoveFrom() {
            System.err.println("changePointToMoveFrom: bombDistanceQueue" + bombDistanceQueue);
            Point nextPosition;

            state = state.turnAround();

            List<BombDistance> bombDistanceView = new ArrayList<>(bombDistanceQueue);
            if ((bombDistanceView.subList(bombDistanceView.size() - 2, bombDistanceView.size()).equals(warmerColder) && speedLowTwoTimes())
                || twoWarmOneCold()) {
                nextPosition = state.jumpFrom(position, map, this);
                nextPosition = makeFoundAxisMove(nextPosition);
            } else {
                if (state.getSpeed(speed) == getHalfOfMap()) {
                    speed = state.pressBrake(speed);
                }

                System.err.println("changePointToMoveFrom: turnAround and pressBrake: speed " + speed + " state " + state);
                nextPosition = state.jumpFrom(position, map, this);
            }

            System.err.println("changePointToMoveFrom: nextPosition " + nextPosition);
            safelyGoToPoint(nextPosition);
        }

        private boolean twoWarmOneCold() {
            List<Speed> speedsView = new ArrayList<>(speedQueue);
            List<BombDistance> bombDistanceView = new ArrayList<>(bombDistanceQueue);

            if (speedsView.size() < 2 || bombDistanceView.size() < 2) {
                return false;
            }

            return state.getSpeed(speedsView.get(speedsView.size() - 2)) == 2 && bombDistanceView.get(bombDistanceView.size() - 2).equals(BombDistance.WARMER)
                && state.getSpeed(speedsView.get(speedsView.size() - 1)) == 1 && bombDistanceView.get(bombDistanceView.size() - 1).equals(BombDistance.COLDER);
        }

        private int getHalfOfMap() {
            int result;
            if (isVertical()) {
                result = map.height/2;
            } else {
                result = map.width/2;
            }
            return result;
        }

        private Point getBeforePreviousPosition() {
            return positionQueue.get(positionQueue.size() - 2);
        }

        private Point getPreviousPosition() {
            return positionQueue.get(positionQueue.size() - 1);
        }

        private Point makeFoundAxisMove(Point nextPosition) {
            System.err.println("axis found - " + nextPosition);
            this.state = nextPosition.isLieLeftTo(map.getCenter()) ? State.RIGHT : State.LEFT;
            nextPosition = new Point(map.getCenter().getX(), nextPosition.getY());
            return nextPosition;
        }

        private void safelyGoToPoint(Point nextPosition) {
            System.err.println("safelyGoToPoint: nextPosition: " + nextPosition + " state: " + state);
            if (notValid(nextPosition, map)) {
                if (state.getSpeed(speed) == 1) {
                    state = state.turnAround();
                } else {
                    speed = state.pressBrake(speed);
                }
                nextPosition = state.jumpFrom(position, map, this);
                safelyGoToPoint(nextPosition);
            } else {
                printAndAddToHistory(nextPosition);
            }
        }

        private void printAndAddToHistory(Point validNextPosition) {
            position = validNextPosition;
            addToSpeedHistory(speed.copy());
            System.err.println("Spds:" + speedQueue);
            System.err.println("State: " + state);
            positionQueue.add(position);
            printPosition();
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

        boolean addBombDistance(BombDistance bombDistance) {
            if (bombDistanceQueue.size() == 4) {
                bombDistanceQueue.poll();
            }
            boolean add = bombDistanceQueue.add(bombDistance);
            System.err.println("bombDistanceQueue: " + bombDistanceQueue);
            return add;
        }

        private boolean speedLowTwoTimes() {
            int times = 2;

            int size = speedQueue.size();
            if (size < times) {
                return false;
            }
            List<Speed> speedView = new ArrayList(speedQueue);
            return speedView.subList(speedView.size() - 2, speedView.size())
                    .stream()
                    .allMatch(this::isLowSpeed);
        }

        private boolean isLowSpeed(Speed lastSpeed) {
            return state.getSpeed(lastSpeed) == 1;
        }

        void goToCentrePoint() {
            if (positionQueue.size() < 2) {
                System.err.println("positionQueue is empty: " + positionQueue);
                return;
            }

            Point previousPosition = getPreviousPosition();
            Point beforePreviousPosition = getBeforePreviousPosition();
            if (isVertical()) {
                int nextY = (previousPosition.y + beforePreviousPosition.y)/2;
                Point nextPosition = makeFoundAxisMove(new Point(previousPosition.x, nextY));
                safelyGoToPoint(nextPosition);
            } else {
                int nextX = (previousPosition.x + beforePreviousPosition.x)/2;
                Point nextPosition = new Point(nextX, previousPosition.y);
                safelyGoToPoint(nextPosition);
            }

        }

        private boolean isVertical() {
            return state == State.UP || state == State.DOWN;
        }

    }

}
