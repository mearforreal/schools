package org.lauchcode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static DB dtb;

    public static void main(String[] args) {
        dtb = new DB();
        scanner = new Scanner(System.in);

        int ind = -1;
        while (ind != 0) {
            main_menu();
            ind = scanner.nextInt();
            switch (ind) {
                case 1:
                    System.out.println("Enter LOGIN: ");
                    String login = scanner.next();

                    System.out.println("Enter PASSWORD: ");
                    String password = scanner.next();

                    if (login.equals("meiyr") & password.equals("meiyr")) {

                        int choose = -1;
                        while (choose != 0) {
                            adminMenu();
                            choose = scanner.nextInt();
                            switch (choose) {
                                case 1:
                                    addTeacher();
                                    break;
                                case 2:
                                    addPupils();

                                    break;

                                case 3:
                                    System.out.println(dtb.teacherList());
                                    break;
                                case 4:
                                    System.out.println(dtb.listPupil());

                                case 5:
                                    if (dtb.teacherList().size() > 0) {
                                        dtb.teacherList();

                                        System.out.println("Choose the index: ");
                                        Long choosing = scanner.nextLong();
                                        if (choosing == 0) {
                                            break;
                                        }
                                        dtb.kickTeach(choosing);
                                    } else
                                        System.out.println("No teachers");
                                    break;
                                case 6:

                                    //database.removeZapisov();
                                    break;
                            }


                        }
                    } else {
                        System.out.println("LOGIN OR PASSWORD IS WRONG!!!");
                    }
                    break;
                case 2:
                    teacherMenu();
                    int choose = -1;
                    while (choose != 0) {
                        teacherMenu();
                        Teacher teacher = new Teacher();
                        choose = scanner.nextInt();

                        switch (choose) {
                            case 1:
                                System.out.println(dtb.listPupil());
                                break;
                            case 2:
                                System.out.println("Enter old password: ");
                                String passwords = scanner.next();
                                System.out.println("Enter new password: ");
                                String newPasswords = scanner.next();
                                System.out.println("Enter id: ");

                                dtb.changePassword(passwords, newPasswords, teacher.getId());
                                System.out.println("Password successfully updated");
                                break;

                        }
                    }

                    break;

                case 3:
                    pupilMenu();
                    break;
            }
        }
    }

    private static void main_menu() {
        System.out.println("1. Admin" +
                "\n2. Teacher" +
                "\n3. Pupil" +
                "\n0. Exit");
        System.out.println("Enter choose: ");

    }

    private static void adminMenu() {
        System.out.println("1. Add teacher");
        System.out.println("2. Add pupil");
        System.out.println("3. List of teachers");
        System.out.println("4. List of pupils");
        System.out.println("5. Delete teacher");
        System.out.println("6. Delete pupil");
        System.out.println("0. EXIT");
        System.out.println("Enter index: ");
    }


    private static void pupilMenu() {
        System.out.println("1. List of subjects");
        System.out.println("2. ");
        System.out.println("3. Information about me");
        System.out.println("0. EXIT");
        System.out.println("Enter from list: ");
    }

    public static void teacherMenu() {
        System.out.println("1. List of students");
        System.out.println("2. Change my password");
        System.out.println("3. Give grades");
        System.out.println("0. EXIT");
        System.out.println("Enter from list: ");
    }

    private static void addPupils() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the username: ");
        String login = scanner.next();
        System.out.println("Write the password");
        String password = scanner.next();

        System.out.println("Enter first name: ");
        String name = scanner.next();
        System.out.println("Enter last name: ");
        String surname = scanner.next();
        System.out.println("Enter  middle_name: ");
        String middle_name = scanner.next();
        System.out.println("Enter class number(1 <-> 11): ");
        int class_name = scanner.nextInt();

        System.out.print("Class char(A, B, C, D, E): ");
        String clas_char = scanner.next();
        System.out.println("Pupil age: ");
        int age = scanner.nextInt();


        Pupil pupil = new Pupil(0L, name, surname, middle_name, age, class_name, clas_char, login, password);

        dtb.addPupil(pupil);

    }

    private static void addTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the first name: ");
        String name = scanner.next();
        System.out.println("Write the last name: ");
        String surname = scanner.next();
        System.out.println("Write the middle_name: ");
        String middle_name = scanner.next();
        System.out.println("Write the subject name: ");
        scanner.nextLine();
        String subject_name = scanner.nextLine();
        System.out.println("Write yor achievement");
        String achievement = scanner.nextLine();
        System.out.println("Write email");
        String email = scanner.nextLine();
        System.out.println("Write the salary: ");
        int salary = scanner.nextInt();
        System.out.println("Write the age:");
        int age = scanner.nextInt();
        System.out.println("Write the username");
        String username = scanner.next();
        System.out.println("Write password");
        String password = scanner.next();

        DB database = new DB();
        Teacher doc = new Teacher(null, name, surname, middle_name, subject_name, achievement, email, age, salary, username, password);
        database.addTeacher(doc);

    }

    public static void loginPage() {
        System.out.println("Write username");
        String username = scanner.next();
        System.out.println("Write password");
        String password = scanner.next();
        Teacher teacher = dtb.getTeacherByAuth(username, password);
            int choose = -1;
            while (choose != 0) {
                teacherMenu();
                choose = scanner.nextInt();

                switch (choose) {
                    case 1:
                        System.out.println(dtb.listPupil());
                        break;
                    case 2:
                        System.out.println("Enter old password: ");
                        String passwords = scanner.next();
                        System.out.println("Enter new password: ");
                        String newPasswords = scanner.next();

                        dtb.changePassword(passwords, newPasswords, teacher.getId());
                        System.out.println("Password successfully updated");
                        break;

                }


            }
        }

    }



