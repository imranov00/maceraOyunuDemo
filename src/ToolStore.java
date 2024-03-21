public class ToolStore extends Location {


    public ToolStore(Player player) {
        super(player, "Mağaza");
    }


    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz !");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.print("Seçiminizi Yapınız :");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz değer, Tekrar giriniz : ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;


                case 3:
                    System.out.println("Yeniden Bekleriz. ");
                    showMenu = false;
                    break;

            }

        }
        return true;

    }

    public void printWeapon() {
        System.out.println("Silahlar");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " Para :" + w.getPrice() + " ,  Hasar : " + w.getDamage());
        }
        System.out.println("0-Çıkış Yap .");
    }

    public void buyWeapon() {
        System.out.println("Bir Silah Seçiniz : ");

        int selectWeapon = input.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, Tekrar giriniz : ");
            selectWeapon = input.nextInt();
        }
        if (selectWeapon != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Bakiyeniz Bulunmamaktadır ! ");

                } else {
                    System.out.println(selectedWeapon.getName() + " Silahını Satın Aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Geriye Kalan Bakiyeniz : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }

        }
    }


    public void printArmor() {
        System.out.println(" Zırh Mağazasına Hoşgeldiniz. ");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getName() + " Para : " + a.getPrice() + " Zırh : " + a.getBlock() + " ");
        }
        System.out.println("0-Çıkış Yap .");


    }

    public void buyArmor() {
        System.out.println("Bir Zırh Seçiniz : ");

        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Geçersiz değer, Tekrar giriniz : ");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Bakiyeniz Bulunmamaktadır ! ");
                } else {
                    System.out.println(selectedArmor.getName() + "Zırhını Satın Aldınız. ");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Geriye Kalan Bakiyeniz : " + this.getPlayer().getMoney());
                }
            }
        }
    }
}
