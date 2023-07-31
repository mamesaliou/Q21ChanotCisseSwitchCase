class Change {
    long coin2;
    long bill5;
    long bill10;

    public Change(long coin2, long bill5, long bill10) {
        this.coin2 = coin2;
        this.bill5 = bill5;
        this.bill10 = bill10;
    }
}

public class Solution {
    public static Change optimalChange(long s) {
        long bill10 = 0;
        long bill5 = 0;
        long coin2 = 0;

        if(s==1||s==3) {
            return null;
        }
        else if (s >= 10) {
            bill10 = s / 10;
            s -= bill10 * 10;
        }

        switch ((int) s) {
            case 0:
                break;
            case 5:
                bill5 = 1;
                break;
            case 2:
                coin2 = 1;
                break;
            case 1:
                bill10--;
                bill5 = 1;
                coin2 = 3;
                break;
            case 3:
                bill10--;
                bill5 = 1;
                coin2 = 4;
                break;
            default:
                if (s % 5 == 0) {
                    bill5 = s / 5;
                } else if (s % 2 == 0) {
                    coin2 = s / 2;
                } else if ((s % 5) % 2 == 0) {
                    bill5 = s / 5;
                    coin2 = (s % 5) / 2;
                } else {
                    return null;
                }
        }

        return new Change(coin2, bill5, bill10);
    }

    public static void main(String[] args) {
        //long s = 11L;
        for(long s =0; s<100; s++){
        Change m = Solution.optimalChange(s);
        if (m != null) {
            /*System.out.println("Rendu de monnaie :");
            System.out.println("Pièces de 2€ : " + m.coin2);
            System.out.println("Billets de 5€ : " + m.bill5);
            System.out.println("Billets de 10€ : " + m.bill10);
            long r = m.coin2 * 2 + m.bill5 * 5 + m.bill10 * 10;
            System.out.println("\nChange given = " + r);*/
            System.out.println(s+": "+m.bill10+" "+ m.bill5+" "+ m.coin2);
        }
    }
}
}