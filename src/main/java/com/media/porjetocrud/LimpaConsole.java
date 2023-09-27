package com.media.porjetocrud;
import java.io.IOException;

public class LimpaConsole {
    public static void limpar() throws InterruptedException, IOException{

        //Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

    }
}
