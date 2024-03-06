package org.example.DataStructure.Hashing;

public class StringToInteger {
    String name;

    public StringToInteger(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println((int) 'A');
        System.out.println((int) 'ö');
        System.out.println((int) '漢');
        System.out.println((char) 28450);
        System.out.println("--------------------------------");
        System.out.println(new StringToInteger("aA").hashCode());
        System.out.println(new StringToInteger("Aa").hashCode());
        System.out.println(new StringToInteger("12").hashCode());
        System.out.println(new StringToInteger("21").hashCode());
        System.out.println(new StringToInteger("\n").hashCode());
        System.out.println(new StringToInteger("").hashCode());
        System.out.println(new StringToInteger(" ").hashCode());
        System.out.println("");


        System.out.println(new StringToInteger("A").hashCode()); // 65
        System.out.println(new StringToInteger("a").hashCode()); // 97

        System.out.println(new StringToInteger("Aa").hashCode()); // 3654
        int Aa = ((65) + (97 * 37) & 0x7FFFFFFF); // hash operation of 'Aa'
        System.out.println(Aa); // 3654
    }

    /*
    word: "this"
    unicode & position, for each character:
    t = 116 & 0
    h = 104 & 1
    i = 105 & 2
    s = 115 & 3

    HashCode = ( 116g^0 + 104g^1 + 105g^2 + 115g^3 ...... ) & 0x7FFFFFFF

     */
    @Override
    public int hashCode() {
        int g = 37;
        int total = 0;

        for (int i = 0; i < name.length(); i++)
            total += (int) (((int) name.charAt(i)) * (Math.pow(g, i)));

        return (total & 0x7FFFFFFF);
    }
}
