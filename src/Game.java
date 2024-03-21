import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);


    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz ! ");
        System.out.println("Lütfen bir isim giriniz : ");
        //String playerName = input.nextLine();
        Player player = new Player("Emin");
        System.out.println("Sayın " + player.getName() + " Karanlığa Hoşgeldin Dostum! ");
        System.out.println("Bundan sonra göreceğin detayları aklından çıkarmamaya dikkat et!! ");
        System.out.println("Unutma, detaylar yaşatır! ");

        System.out.println("Lütfen Seçeceğiniz Karakteri Belirtiniz. ");
        player.selectChar();


        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("Bölgeler");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Eşya Dükkanı");
            System.out.println("3 - Mağara");
            System.out.println("4 - Tehlikeli Orman ");
            System.out.println("5 - Nehir");
            System.out.println("0 - Çıkış Yap");
            System.out.println("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;

                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;

                default:
                    System.out.println(" Lütfen Geçerli Bir Bölge Giriniz. ");


            }
            if (location == null) {
                System.out.println("Oyun Bitti.");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }

        }


    }
}
