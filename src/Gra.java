import java.util.Random;
import java.util.Scanner;

public class Gra {
    private int papier = 1;
    private int kamien = 2;
    private int nozyce = 3;
    private int wyborFiguryCzlowiek;
    private int wyborFiguryKomputer;
    private int punktyCzlowiek = 0;
    private int punktyKomputer = 0;
    private int licznikRund = 0;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public void rozgrywka(){
        while (punktyCzlowiek != 3 && punktyKomputer != 3) {
            licznikRund ++;
            losowanieFigur();
            sprawdzenieWybranychLiczb();
            sprawdzWariantKomputerPapier();
            sprawdzWariantKomputerKamien();
            sprawdzWariantKomputerNozyce();
        }
        wyświetlWyniki();
    }

    public void losowanieFigur(){
        System.out.println("wybierz: \n" +
                "1 - papier \n" +
                "2 - kamień \n" +
                "3 - nożyce");
        wyborFiguryCzlowiek = scanner.nextInt();
        wyborFiguryKomputer = random.nextInt(3) + 1;
    }

    public void sprawdzenieWybranychLiczb(){
        while (wyborFiguryCzlowiek != papier && wyborFiguryCzlowiek != kamien && wyborFiguryCzlowiek != nozyce) {
            System.out.println("błędna liczba! Wybierz liczbę 1, 2 lub 3:");
            wyborFiguryCzlowiek = scanner.nextInt();
        }
    }

    public void sprawdzWariantKomputerPapier(){
        while (wyborFiguryKomputer == papier) {
            if (wyborFiguryCzlowiek == papier) {
                System.out.println("Komputer wybrał: papier , Ty wybrałeś: papier");
                System.out.println("remis");
            } else if (wyborFiguryCzlowiek == kamien) {
                punktyKomputer++;
                System.out.println("Komputer wybrał: papier , Ty wybrałeś: kamień");
                System.out.println("wygrywa komputer");
            } else if (wyborFiguryCzlowiek == nozyce) {
                punktyCzlowiek++;
                System.out.println("Komputer wybrał: papier , Ty wybrałeś: nożyce");
                System.out.println("wygrywasz Ty");
            }break;
        }

    }

    public void sprawdzWariantKomputerKamien(){
        while (wyborFiguryKomputer == kamien) {
            if (wyborFiguryCzlowiek == papier) {
                punktyCzlowiek++;
                System.out.println("Komputer wybrał: kamień , Ty wybrałeś: papier");
                System.out.println("wygrywasz Ty");
            } else if (wyborFiguryCzlowiek == kamien) {
                System.out.println("Komputer wybrał: kamień , Ty wybrałeś: kamień");
                System.out.println("remis");
            } else if (wyborFiguryCzlowiek == nozyce) {
                punktyKomputer++;
                System.out.println("Komputer wybrał: kamień , Ty wybrałeś: nożyce");
                System.out.println("wygrywa komputer");
            }break;
        }
    }

    public void sprawdzWariantKomputerNozyce(){
        while (wyborFiguryKomputer == nozyce) {
            if (wyborFiguryCzlowiek == papier) {
                punktyKomputer++;
                System.out.println("Komputer wybrał: nożyce , Ty wybrałeś: papier");
                System.out.println("wygrywa komputer");
            } else if (wyborFiguryCzlowiek == kamien) {
                punktyCzlowiek++;
                System.out.println("Komputer wybrał: nożyce , Ty wybrałeś: kamień");
                System.out.println("wygrywasz Ty");
            } else if (wyborFiguryCzlowiek == nozyce) {
                System.out.println("Komputer wybrał: nożyce , Ty wybrałeś: nożyce");
                System.out.println("remis");
            }break;
        }
    }

    public void wyświetlWyniki(){
        if (punktyCzlowiek == 3){
            System.out.println();
            System.out.println("Koniec gry");
            System.out.println("wygrałeś z komputerem, punktacja: " + punktyCzlowiek + ":" + punktyKomputer +
                    " w " +licznikRund+ " rundach");
        } else if (punktyKomputer == 3){
            System.out.println();
            System.out.println("Koniec gry");
            System.out.println("wygrywa komputer, punktacja: " + punktyCzlowiek + ":" + punktyKomputer +
                    " w " +licznikRund+ " rundach");
        }
    }

    public int getWyborFiguryCzlowiek() {
        return wyborFiguryCzlowiek;
    }

    public int getWyborFiguryKomputer() {
        return wyborFiguryKomputer;
    }
}
