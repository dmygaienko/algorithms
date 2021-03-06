//package com.mygaienko.common.algorithms.condingame.very_hard.shadows_of_knight2;//package com.mygaienko.common.algorithms.condingame.very_hard.shadows_of_knight2;
//
//
//import java.util.*;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//
///**
// * Auto-generated code below aims at helping you parse
// * the standard input according to the problem statement.
// **/
//class PlayerV2 {
//
//    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        Game game = initGame(in);
//
//        // game loop
//        while (true) {
//
//            String bombDir = in.next(); // Current distance to the bomb compared to previous distance (COLDER, WARMER, SAME or UNKNOWN)
//
//            System.err.println(bombDir);
//            if ("UNKNOWN".equals(bombDir)) {
//
//                if (game.getPosition().isHigher(game.getMap().getCenter())) {
//                    game.goDirection(State.DOWN);
//                } else {
//                    game.goDirection(State.UP);
//                }
//
//            }
//
//            if ("WARMER".equals(bombDir)) {
//                game.keepDirection();
//            }
//
//            if ("COLDER".equals(bombDir) || "SAME".equals(bombDir)) {
//                game.changeDirection();
//            }
//
//        }
//
//    }
//
//    enum State {
//
//        UP {
//            Point jumpFrom(Point previousPoint, Map map, Game game) {
//                return new Point(previousPoint.getX(), previousPoint.getY() - getSpeed(game.speed));
//            }
//
//            public State makeAturn() {
//                return RIGHT;
//            }
//
//            public State turnAround() {
//                return DOWN;
//            }
//
//            int getSpeed(Speed speed) {
//                return speed.verticalSpeed;
//            }
//
//            Speed pressBrake(Speed speed) {
//                speed.verticalSpeed = Game.safelyPressBrake(speed.verticalSpeed);
//                return speed;
//            }
//
//            Speed pressGas(Speed speed, Game game) {
//                speed.verticalSpeed = game.getStartVerticalSpeed();
//                return speed;
//            }
//
//            public boolean isFirstChangeDirection(FirstChangeDirection firstChangeDirection) {
//                boolean result = false;
//                if (firstChangeDirection.firstVerticalChangeDirection) {
//                    firstChangeDirection.firstVerticalChangeDirection = false;
//                    result = true;
//                }
//                return result;
//            }
//
//
//        },
//        DOWN {
//            Point jumpFrom(Point previousPoint, Map map, Game game) {
//                return new Point(previousPoint.getX(), previousPoint.getY() + getSpeed(game.speed));
//            }
//
//            public State makeAturn() {
//                return LEFT;
//            }
//
//            public State turnAround() {
//                return UP;
//            }
//
//            int getSpeed(Speed speed) {
//                return speed.verticalSpeed;
//            }
//
//            Speed pressBrake(Speed speed) {
//                speed.verticalSpeed = Game.safelyPressBrake(speed.verticalSpeed);
//                return speed;
//            }
//
//            Speed pressGas(Speed speed, Game game) {
//                speed.verticalSpeed = game.getStartVerticalSpeed();
//                return speed;
//            }
//
//            public boolean isFirstChangeDirection(FirstChangeDirection firstChangeDirection) {
//                boolean result = false;
//                if (firstChangeDirection.firstVerticalChangeDirection) {
//                    firstChangeDirection.firstVerticalChangeDirection = false;
//                    result = true;
//                }
//                return result;
//            }
//        },
//        RIGHT {
//            Point jumpFrom(Point previousPoint, Map map, Game game) {
//                return new Point(previousPoint.getX() + getSpeed(game.speed), previousPoint.getY());
//            }
//
//            public State makeAturn() {
//                return DOWN;
//            }
//
//            public State turnAround() {
//                return LEFT;
//            }
//
//            int getSpeed(Speed speed) {
//                return speed.horizontalSpeed;
//            }
//
//            Speed pressBrake(Speed speed) {
//                speed.horizontalSpeed = Game.safelyPressBrake(speed.horizontalSpeed);
//                return speed;
//            }
//
//            Speed pressGas(Speed speed, Game game) {
//                speed.horizontalSpeed = game.getStartHorizontalSpeed();
//                return speed;
//            }
//
//            public boolean isFirstChangeDirection(FirstChangeDirection firstChangeDirection) {
//                boolean result = false;
//                if (firstChangeDirection.firstHorizontalChangeDirection) {
//                    firstChangeDirection.firstHorizontalChangeDirection = false;
//                    result = true;
//                }
//                return result;
//            }
//        },
//        LEFT {
//            Point jumpFrom(Point previousPoint, Map map, Game game) {
//                return new Point(previousPoint.getX() - getSpeed(game.speed), previousPoint.getY());
//            }
//
//            public State makeAturn() {
//                return UP;
//            }
//
//            public State turnAround() {
//                return RIGHT;
//            }
//
//            int getSpeed(Speed speed) {
//                return speed.horizontalSpeed;
//            }
//
//            Speed pressBrake(Speed speed) {
//                speed.horizontalSpeed = Game.safelyPressBrake(speed.horizontalSpeed);
//                return speed;
//            }
//
//            Speed pressGas(Speed speed, Game game) {
//                speed.horizontalSpeed = game.getStartHorizontalSpeed();
//                return speed;
//            }
//
//            public boolean isFirstChangeDirection(FirstChangeDirection firstChangeDirection) {
//                boolean result = false;
//                if (firstChangeDirection.firstHorizontalChangeDirection) {
//                    firstChangeDirection.firstHorizontalChangeDirection = false;
//                    result = true;
//                }
//                return result;
//            }
//
//        };
//
//        abstract Point jumpFrom(Point previousPoint, Map map, Game game);
//
//        abstract State makeAturn();
//
//        abstract State turnAround();
//
//        abstract int getSpeed(Speed speed);
//
//        abstract Speed pressBrake(Speed speed);
//
//        abstract Speed pressGas(Speed speed, Game game);
//
//        public abstract boolean isFirstChangeDirection(FirstChangeDirection firstChangeDirection);
//    }
//
//    public static class Point {
//
//        final int x;
//        final int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public String toString() {
//            return x + " " + y;
//        }
//
//        public int getX() {
//            return x;
//        }
//
//        public int getY() {
//            return y;
//        }
//
//        public boolean isHigher(Point center) {
//            return y < center.y;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Point point = (Point) o;
//            return x == point.x &&
//                    y == point.y;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
//    }
//
//    public static class Map {
//        int width;
//        int height;
//
//        public Map(int width, int height) {
//            this.width = width;
//            this.height = height;
//        }
//
//        public int getWidth() {
//            return width;
//        }
//
//        public int getHeight() {
//            return height;
//        }
//
//        @Override
//        public String toString() {
//            return "Map{" +
//                    "width=" + width +
//                    ", height=" + height +
//                    '}';
//        }
//
//        public Point getCenter() {
//            return new Point(getWidth() / 2, getHeight() / 2);
//        }
//    }
//
//    private static Game initGame(Scanner in) {
//        return new Game(
//                initMap(in),
//                initMaxTurns(in),
//                initFirstPosition(in));
//    }
//
//    private static int initMaxTurns(Scanner in) {
//        int N = in.nextInt(); // maximum number of turns before game over.
//        System.err.println("N: " + N);
//        return N;
//    }
//
//    private static Point initFirstPosition(Scanner in) {
//        int X0 = in.nextInt();
//        int Y0 = in.nextInt();
//        return new Point(X0, Y0);
//    }
//
//    private static Map initMap(Scanner in) {
//        int width = in.nextInt(); // width of the building.
//        int height = in.nextInt(); // height of the building.
//        Map map = new Map(width, height);
//        System.err.println("building: " + map);
//        return map;
//    }
//
//    enum Action { KEEP_DIRECTION, CHANGE_DIRECTION }
//
//    public static class Speed {
//        int horizontalSpeed;
//        int verticalSpeed;
//
//        public Speed(int horizontalSpeed, int verticalSpeed) {
//            this.horizontalSpeed = horizontalSpeed;
//            this.verticalSpeed = verticalSpeed;
//        }
//
//        @Override
//        public String toString() {
//            return "Spd{" +
//                    "hor=" + horizontalSpeed +
//                    ",vert=" + verticalSpeed +
//                    '}';
//        }
//
//        public Speed copy() {
//            return new Speed(horizontalSpeed, verticalSpeed);
//        }
//    }
//
//    public static class FirstChangeDirection {
//        boolean firstHorizontalChangeDirection = true;
//        boolean firstVerticalChangeDirection = true;
//    }
//
//    public static class Game {
//        Map map;
//        int maxTurns;
//        Point position;
//        State state;
//        Speed speed;
//
//        FirstChangeDirection firstChangeDirection = new FirstChangeDirection();
//
//        AtomicBoolean axisFound = new AtomicBoolean(false);
//
//        Queue<Action> actionQueue = new LinkedBlockingQueue<>(4);
//        Queue<Speed> speedQueue = new LinkedBlockingQueue<>(4);
//
//        List<Action> colderBalanceTurns = initColderBalanceTurns();
//        List<Action> warmerBalanceTurns = initWarmerBalanceTurns();
//        List<Action> changesBalanceTurns = initChangesBalanceTurns();
//
//        private List<Action> initChangesBalanceTurns() {
//            return Arrays.asList(Action.CHANGE_DIRECTION, Action.CHANGE_DIRECTION, Action.CHANGE_DIRECTION, Action.CHANGE_DIRECTION);
//        }
//
//        private List<Action> initColderBalanceTurns() {
//            return Arrays.asList(Action.CHANGE_DIRECTION, Action.KEEP_DIRECTION, Action.CHANGE_DIRECTION, Action.KEEP_DIRECTION);
//        }
//
//        private List<Action> initWarmerBalanceTurns() {
//            return Arrays.asList(Action.KEEP_DIRECTION, Action.CHANGE_DIRECTION, Action.KEEP_DIRECTION, Action.CHANGE_DIRECTION);
//        }
//
//        public Game(Map map, int maxTurns, Point position) {
//            this.map = map;
//            this.maxTurns = maxTurns;
//            this.position = position;
//            this.speed = new Speed(getStartHorizontalSpeed(), getStartVerticalSpeed());
//        }
//
//        private int getStartVerticalSpeed() {
//            return map.getHeight() / 4;
//        }
//
//        private int getStartHorizontalSpeed() {
//            return map.getWidth() / 4;
//        }
//
//        public static int safelyPressBrake(int speed) {
//            return speed >= 4 ? speed / 4 : 1;
//        }
//
//        public boolean addToActionHistory(Action action){
//            System.err.println("actionQueue: " + actionQueue + "\n new Action: " + action);
//            if (actionQueue.size() == 4) {
//                actionQueue.poll();
//            }
//            boolean add = actionQueue.add(action);
//            System.err.println("actionQueue: " + actionQueue);
//            return add;
//        }
//
//        public boolean addToSpeedHistory(Speed speed){
//            if (speedQueue.size() == 4) {
//                speedQueue.poll();
//            }
//            return speedQueue.add(speed);
//        }
//
//        public Map getMap() {
//            return map;
//        }
//
//        public int getMaxTurns() {
//            return maxTurns;
//        }
//
//        public Point getPosition() {
//            return position;
//        }
//
//        public void setMap(Map map) {
//            this.map = map;
//        }
//
//        public void setMaxTurns(int maxTurns) {
//            this.maxTurns = maxTurns;
//        }
//
//        public void setPosition(Point position) {
//            this.position = position;
//        }
//
//        public State getState() {
//            return state;
//        }
//
//        public void goDirection(State state) {
//            System.err.println("State: " + state);
//            this.state = state;
//            Point nextPosition = state.jumpFrom(position, map, this);
//            safelyGoToPoint(nextPosition, Action.KEEP_DIRECTION);
//        }
//
//        public void keepDirection() {
//            System.err.println("keepDirection");
//
//            List<Action> queueView = new ArrayList<>(actionQueue);
//            if (queueView.equals(warmerBalanceTurns) && speedLowTwoTimes() && isAxisNotFound()) {
//                this.state = state.makeAturn();
//                System.err.println("axis found " + position);
//                actionQueue.clear();
//            }
//
//            Point nextPosition = state.jumpFrom(position, map, this);
//            safelyGoToPoint(nextPosition, Action.KEEP_DIRECTION);
//        }
//
//        private boolean speedLowTwoTimes() {
//            int times = 4;
//
//            int size = speedQueue.size();
//            if (size < times) {
//                return false;
//            }
//            return speedQueue
//                    .stream()
//                    .allMatch(this::isLowSpeed);
//        }
//
//        private boolean isLowSpeed(Speed lastSpeed) {
//            return state.getSpeed(lastSpeed) == 1;
//        }
//
//        public void changeDirection() {
//            System.err.println("changePointToMoveFrom: actionQueue" + actionQueue);
//            List<Action> queueView = new ArrayList<>(actionQueue);
//
//            if (queueView.equals(colderBalanceTurns) && speedLowTwoTimes()) {
//                turnAroundAndPrepareToMakeATurn();
//            } else if (queueView.equals(changesBalanceTurns)) {
//                turnAroundAndPrepareToMakeATurn();
//            } else if (state.isFirstChangeDirection(firstChangeDirection)){
//                this.state = state.turnAround();
//            } else if (state.getSpeed(speed) > 1){
//                System.err.println("changePointToMoveFrom: next try slowly start position - " + position + " state - " + state.name() + " speed - " + speed);
//                this.state = state.turnAround();
//                this.position = state.jumpFrom(position, map, this);
//                this.state = state.turnAround();
//                this.speed = state.pressBrake(speed);
//                System.err.println("changePointToMoveFrom: next try slowly start position - " + position + " state - " + state.name() + " speed - " + speed);
//            } else {
//                this.speed = state.pressBrake(speed);
//                this.state = state.turnAround();
//            }
//
//            Point nextPosition = state.jumpFrom(position, map, this);
//            System.err.println("changePointToMoveFrom: nextPosition" + nextPosition);
//            safelyGoToPoint(nextPosition, Action.CHANGE_DIRECTION);
//        }
//
//        private boolean isAxisNotFound() {
//            return  !axisFound.getAndSet(true);
//        }
//
//        private void turnAroundAndPrepareToMakeATurn() {
//            if (state.getSpeed(speed) == 1 && isAxisNotFound()) {
//                this.state = state.turnAround();
//                position = state.jumpFrom(position, map, this);
//                this.state = state.makeAturn();
//
//                System.err.println("axis found - " + position);
//                actionQueue.clear();
//            }
//        }
//
//        private void safelyGoToPoint(Point nextPosition, Action action) {
//            System.err.println("safelyGoToPoint: nextPosition: " + nextPosition + " action: " + action );
//            if (notValid(nextPosition, map)) {
//                if (state.getSpeed(speed) == 1) {
//                    state = state.turnAround();
//                    state.pressGas(speed, this);
//                    action = Action.CHANGE_DIRECTION;
//                } else {
//                    state.pressBrake(speed);
//                }
//                nextPosition = state.jumpFrom(position, map, this);
//                safelyGoToPoint(nextPosition, action);
//            } else {
//                printAndAddToHistory(action, nextPosition);
//            }
//        }
//
//        private void printAndAddToHistory(Action action, Point validNextPosition) {
//            position = validNextPosition;
//            addToSpeedHistory(speed.copy());
//            System.err.println("Speeds: " + speedQueue);
//            printPosition();
//            addToActionHistory(action);
//        }
//
//        private void printPosition() {
//            System.out.println(position);
//        }
//
//        private boolean notValid(Point position, Map map) {
//            boolean result = position.getX() < 0 ||
//                    position.getX() >= map.getWidth() ||
//                    position.getY() < 0 ||
//                    position.getY() >= map.getHeight();
//
//            System.err.println("Position: " + position + " map: "  + map + " result: " + result);
//            return result;
//        }
//
//        @Override
//        public String toString() {
//            return "Game{" +
//                    "map=" + map +
//                    ", maxTurns=" + maxTurns +
//                    ", position=" + position +
//                    '}';
//        }
//
//    }
//
//}
