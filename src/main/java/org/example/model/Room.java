package org.example.model;

public class Room {

    private int[][] arr;
    private Car car;

    public Room(int roomX, int roomY, int carX, int carY, char direction) {
        this.arr = new int[roomX][roomY];
        this.car = new Car(carX, carY, direction);
    }

    public int executeCommand(char command) {
        if (command == 'N' || command == 'W' || command == 'S' || command == 'E') {
            changeDirection(command);
        } else if (command == 'F' || command == 'B' || command == 'L' || command == 'R') {
            if (move(command) == false) {
                return -1;
            }
        } else {
            return 0;
        }
        return 1;
    }

    private void changeDirection(char dir) {
        car.setDirection(dir);
    }

    public boolean isSafe() {
        return (car.getX() >= 0 && car.getX() < arr.length && car.getY() >= 0 && car.getY() < arr[0].length);
    }

    private boolean move(char command) {
        if (!isSafe()) {
            return false;
        }
        char direction = car.getDirection();
        if (command == 'F') {
            if (direction == 'N') {
                car.setX(car.getX()-1);
            } else if (direction == 'S') {
                car.setX(car.getX()+1);
            } else if (direction == 'W') {
                car.setY(car.getY()-1);
            } else if (direction == 'E') {
                car.setY(car.getY()+1);
            }
        } else if (command == 'B') {
            if (direction == 'N') {
                car.setX(car.getX()+1);
            } else if (direction == 'S') {
                car.setX(car.getX()-1);
            } else if (direction == 'W') {
                car.setY(car.getY()+1);
            } else if (direction == 'E') {
                car.setY(car.getY()-1);
            }
        } else if (command == 'L') {
            if (direction == 'N') {
                car.setY(car.getY()-1);
            } else if (direction == 'S') {
                car.setY(car.getY()+1);
            } else if (direction == 'W') {
                car.setX(car.getX()+1);
            } else if (direction == 'E') {
                car.setX(car.getX()-1);
            }
        } else if (command == 'R') {
            if (direction == 'N') {
                car.setY(car.getY()+1);
            } else if (direction == 'S') {
                car.setY(car.getY()-1);
            } else if (direction == 'W') {
                car.setX(car.getX()-1);
            } else if (direction == 'E') {
                car.setX(car.getX()+1);
            }
        }
        return isSafe();
    }

    public void print() {
        System.out.print("#");
        if (arr.length > 0) {
            for (int j = 0; j < arr[0].length; j++) {
                if (car.getX() == -1 && car.getY() == j) {
                    System.out.print("@");
                } else {
                    System.out.print("#");
                }
            }
        }
        System.out.println("#");
        for (int i = 0; i < arr.length; i++) {
            if (car.getX() == i && car.getY() == -1) {
                System.out.print("@");
            } else {
                System.out.print("#");
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (i == car.getX() && j == car.getY()) {
                    char direction = car.getDirection();
                    if (direction == 'N') {
                        System.out.print("^");
                    } else if (direction == 'W') {
                        System.out.print("<");
                    } else if (direction == 'S') {
                        System.out.print("v");
                    } else if (direction == 'E') {
                        System.out.print(">");
                    }
                } else {
                    System.out.print(" ");
                }
            }
            if (car.getX() == i && car.getY() == arr[i].length) {
                System.out.println("@");
            } else {
                System.out.println("#");
            }
        }
        System.out.print("#");
        if (arr.length > 0) {
            for (int j = 0; j < arr[0].length; j++) {
                if (car.getX() == arr.length && car.getY() == j) {
                    System.out.print("@");
                } else {
                    System.out.print("#");
                }
            }
        }
        System.out.println("#");
    }

    public void printCarInfo() {
        if (isSafe()) {
            System.out.println("Car Position is (" + (car.getX()+1) + " , " + (car.getY()+1) + ")");
            char direction = car.getDirection();
            if (direction == 'N') {
                System.out.println("Direction of Car is North.");
            } else if (direction == 'W') {
                System.out.println("Direction of Car is West.");
            } else if (direction == 'S') {
                System.out.println("Direction of Car is South.");
            } else if (direction == 'E') {
                System.out.println("Direction of Car is East.");
            }
        }
    }

}
