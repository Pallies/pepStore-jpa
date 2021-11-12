package fr.diginamic.utils;

import fr.diginamic.enums.Color;
import fr.diginamic.enums.FishLivEnv;

import java.time.LocalDate;
import java.util.Random;

public abstract class Rand {

    private static Random random = new Random();
    private Rand(){

    }
    public static LocalDate getDate(){

            int year = random.nextInt(22) + 2000;
            int month = random.nextInt(11)+1;
            int day = random.nextInt(27)+1;
            return LocalDate.of(year,month,day);
    }
    public static Color getColor(){
        int numero = random.nextInt(Color.values().length);
        return Color.getColor(numero);
    }
    public static FishLivEnv getEnv(){
        int numero = random.nextInt(FishLivEnv.values().length);
        return FishLivEnv.getEnv(numero);
    }
    public static String chipID(){
        int a = random.nextInt(9)+1;
        int b = random.nextInt(9)+1;
        int c = random.nextInt(9)+1;
        int x = random.nextInt(25)+1;
        int y = random.nextInt(25)+1;
        int z = random.nextInt(25)+1;
        String cd= new StringBuilder().append(a).append(b).append(c)
                .append(getCharForNumber(x))
                .append(getCharForNumber(y))
                .append(getCharForNumber(z))
                .toString();
        return cd;
    }
    private static String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
    }
}
