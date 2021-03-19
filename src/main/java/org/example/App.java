package org.example;

import org.example.model.Room;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter room height: ");
        int roomX = console.nextInt();
        while (roomX < 1) {
            System.out.print("Enter room height: ");
            roomX = console.nextInt();
        }
        System.out.print("Enter room width: ");
        int roomY = console.nextInt();
        while (roomY < 1) {
            System.out.print("Enter room width: ");
            roomY = console.nextInt();
        }

        System.out.print("Enter car position row (1 - " + roomX + "): ");
        int carX = console.nextInt();
        while(carX < 1 || carX > roomX) {
            System.out.print("Enter car position row (1 - " + roomX + "): ");
            carX = console.nextInt();
        }
        System.out.print("Enter car position column (1 - " + roomY + "): ");
        int carY = console.nextInt();
        while(carY < 1 || carY > roomY) {
            System.out.print("Enter car position column (1 - " + roomY + "): ");
            carY = console.nextInt();
        }

        System.out.print("Enter car direction (N W S E): ");
        char direction = console.next().toUpperCase().charAt(0);
        while (!(direction == 'N' || direction == 'W' || direction == 'S' || direction == 'E')) {
            System.out.print("Enter car direction (N W S E): ");
            direction = console.next().toUpperCase().charAt(0);
        }

        Room room = new Room(roomX, roomY, carX - 1, carY - 1, direction);
        room.print();

        while (true) {
            System.out.print("Enter a commands (F B L R N W S E), (Q for Quit): ");
            char command = console.next().toUpperCase().charAt(0);
            if (command == 'Q') {
                break;
            }
            int value = room.executeCommand(command);
            if (value == 0) {
                System.out.println("Invalid command.");
                continue;
            } else if (value < 0) {
                room.print();
                System.out.println("car crashes into a wall");
                break;
            }
            room.print();
        }

        if (room.isSafe()) {
            room.print();
            room.printCarInfo();
        }

    }
    }

