public class App {


    public enum Size{
        petit,
        moyen,
        grand
    }

    // calcule le prix payé par l'utilisateur dans le restaurant, en fonction de type de
    // repas qu'il prend (assiette ou sandwich), de la taille de la boisson (petit, moyen, grand), du dessert et
    // de son type (normal ou special) et si il prend un café ou pas (yes ou no).
    // les prix sont fixes pour chaque type de chose mais des réductions peuvent s'appliquer
    // si cela rentre dans une formule!
    public int Compute(String type, String name, String beverage, Size BottleSize, String dessert, String dsize, String coffee) {
        // prix total à payer pour le client
        int total = 0;

        // le type ne peut être vide car le client doit déclarer au moins un repas
        if (type == null || name == null || type.isEmpty() || name.isEmpty()) return -1;

        // si le client prends un plat en assiette
        if (type.equals("assiette")) {
            total += 15;
            total = ChekSize(total, BottleSize, dsize);
        }
        // mode sandwich
        else {
            total += 10;
            // ainsi qu'une boisson de taille:
            total = ChekSize(total, BottleSize, dsize);

        }
        if (type.equals("assiette") && BottleSize == Size.moyen && dsize.equals("normal") && coffee.equals("yes")) {
            System.out.print(" avec café offert!");
        } else {
            // Assume coffee costs 1 unit, adding to the total only if coffee is not included
            if (!coffee.equals("yes")) {
                total += 1;
            }
        }
        return total;
    }

    //ckeck taille dessert
    public int DessertSise(int total, String dsize, boolean IfFormuleNormal, boolean IfFormuleBig, int PriceNormal, int PriceBIg) {

        if (dsize.equals("normal")) {
            total = CalculFormulePrice(total, IfFormuleNormal, PriceNormal);
        } else {
            total = CalculFormulePrice(total, IfFormuleBig, PriceBIg);
        }

        return total;
    }

    // calcul si il y a une formule ou pas
    public int CalculFormulePrice(int total, boolean IfFormule, int Price) {
        if (IfFormule == true) {
            total = Price;
            System.out.print("Prix Formule appliquée ");
        }
        else
            total += Price;
        return total;
    }

    // Calcul le prix en fonction de la taille des bouteilles
    private int ChekSize(int total, Size size, String dsize) {
        if (size == Size.petit) {
            total += 2;
            // pas de formule
            // on ajoute le prix du dessert normal
            // sinon on rajoute le prix du dessert special
            total = DessertSise(total, dsize, false, false, 2, 4);

        } else if (size == Size.moyen) {
            total += 3;

            // j'affiche la formule appliquée
            // le prix de la formule est donc 18
            // sinon on rajoute le prix du dessert special
            total = DessertSise(total, dsize, true, false, 18, 4);


        } else if (size == Size.grand) {
            total += 4;

            // pas de formule
            // on ajoute le prix du dessert normal
            // dans ce cas on a la fomule max
            total = DessertSise(total, dsize, false, true, 2, 21);
        }

        return total;
    }


}