package com.billies_works;

import java.util.Scanner;
import java.util.HashMap;
import com.billies_works.janken.Janken;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.print_title();
        app.print_start();
        String[] kekka = app.game_start();
        app.print_winner( kekka );
    }

    public void print_winner( String[] kekka ) {
        HashMap <String, String> hands = new HashMap <> ();
        hands.put( "gu", "グー" );
        hands.put( "choki", "チョキ" );
        hands.put( "pa", "パー" );

        String text = "";
        switch (kekka[2]) {
        case "user":
            text = "あなたの勝ちです";
            break;
        case "com":
            text = "わたしの勝ちです";
            break;
        case "draw":
            text = "引き分けです";
            break;
        default:
            text = "てへっ";
        }

        System.out.println("あなた:" + hands.get( kekka[0] ) + " わたし:" + hands.get( kekka[1]) );
        System.out.println("結果:" + text);
    }

    public void print_title () {
        String title_text =
            "\n=================================\n" +
            "        じゃんけんゲーム" +
            "\n=================================\n";
        System.out.println( title_text );
    }

    public void print_start () {
        System.out.println("1:グー  2:チョキ  3:パー\n");
        System.out.println("数字で選んでください");
    }

    public String[] game_start () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String user_num = scanner.nextLine();
        scanner.close();

        String user = toMoji( user_num );
        Janken janken = new Janken();
        String winner = janken.input( user );

        String[] kekka = new String[3];
        kekka[0] = user;
        kekka[1] = janken.getCom();
        kekka[2] = winner;
        return kekka;
    }

    private String toMoji (String num) {
        switch (num) {
        case "1":
            return "gu";
        case "2":
            return "choki";
        case "3":
            return "pa";
        default:
            return "tehe :P";
        }
    }
}

// 修正時刻: Sun Aug 16 06:14:59 2020

