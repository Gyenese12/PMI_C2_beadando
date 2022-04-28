import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static int Num;
    public static ArrayList<users> felhasznalok = new ArrayList<users>();
    public static Scanner scann = new Scanner(System.in);
    public static void main(String[] args) {
        Menu();
        scann.close();
    }

    public static void Menu(){
        System.out.println("Új felhasználó bevitele(1)");
        System.out.println("Felhasználó törlése(2)");
        System.out.println("Felhasználók listázása(3)");
        System.out.println("Felhasználó Módosítása(4)");
        System.out.println("Kilépés(5)");
        System.out.print("Kérem írja be annak a menüpontnak a számát amit választani szeretne: ");
        scann = new Scanner(System.in);
        Num = scann.nextInt();
        if(Num < 0 || Num > 5){
            wrongMenu();
        }
        if(Num == 1){
            newUser();
            Menu();
        }

        if(Num == 2){
            UserDelete();
            Menu();
        }
        if(Num == 3){
            Listazas();
            Menu();
        }
        if(Num == 4){
            System.out.println("Viszont látásra!");
        }
        }

        public static void wrongMenu(){
            clearScreen();
            System.out.println("Hibás adat!");
            System.out.print("Kérem írja be annak a menüpontnak a számát amit választani szeretne: ");
        }

        public static void newUser(){
            clearScreen();
            System.out.println("Kérem írja be a felhasználó nevét: ");
            String Nev = scann.next();
            System.out.println("Kérem írja be a felhasználó életkorát: ");
            int eletkor = scann.nextInt();
            while(eletkor < 0){
                System.out.print("Hibás adat!");
                eletkor = scann.nextInt();
            }
            System.out.println("Kérem írja be a felhasználó Címét(pl.: 7600 Pécs Szentenderi út 22): ");
            String cim = scann.next();
            felhasznalok.add(new users(Nev,eletkor,cim));
        }

        public static void UserDelete(){
            clearScreen();
            System.out.println("Kérem a törölni kivánt személy nevét: ");
            String Nev = scann.next();
            System.out.println("Kérem a törölni kivánt személy életkorát: ");
            int eletkor = scann.nextInt();
            while(eletkor < 0){
                System.out.print("Hibás adat!");
                eletkor = scann.nextInt();
            }
            int i = 0;
            for(users user : felhasznalok) {
                if(user.getName() == Nev && user.getAge() == eletkor)
                {
                    felhasznalok.remove(user);
                    i++;
                }
                }
            if(i > 0) System.out.println("Felhasználó sikeresen törölve!");
            else {
                System.out.println("Nem találtunk ilyen nevű felhasználót");
            }
        }

        public static void Listazas(){
            clearScreen();
            System.out.println("Regisztrált felhasználók listája: ");
            for(users user : felhasznalok){
                System.out.println("Név: " + user.getName() + " Életkor: " + user.getAge() + " Lakcím: "  + user.getAddress());
            }
        }

        public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        }


}

