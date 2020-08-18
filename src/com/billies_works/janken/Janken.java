package com.billies_works.janken;

import java.util.Random;
import java.io.Serializable;

/**
 * ジャンケンクラス
 * このクラスの input メソッドに "gu"、"choki"、"pa" のいずれかを
 * 引数として与えると、"user"、"com"、"draw" のいずれかが返ってくる。
 * 使用法:
 *   String kekka = null;
 *   Janken janken = new Janken();
 *   kekka = janken.input( "gu" );
 *   System.out.println( kekka );    // "user" / "com" / "draw"
 */
public class Janken implements Serializable {
    private String user = null;
    private String com = null;
    private String winner = null;

    public Janken () {}

    public String getUser () { return this.user; }
    public String getCom () { return this.com; }
    public String getWinner () { return this.winner; }
    public void setUser (String user) { this.user = user; }


    /**
     * ユーザーからジャンケンの入力を受け付ける
     * @param:
     *   String hand -- "gu" or "choki" or "pa"
     * @return:
     *   String  -- "user" or "com" or "draw"
     */
    public String input (String hand) {
        this.user = hand;
        com = setCom();
        this.winner = hantei (hand, com);
        return this.winner;
    }

    /**
     * コンピュータに "gu" "choki" "pa" のどれかを
     * ランダムに選択させる
     * @param: none
     * @return: String -- "gu" or "choki" or "pa"
     */
    private String setCom () {
        // com_int に 0...2 の値を取得
        Random random = new Random();
        int com_int = random.nextInt(3);
        String _com = null;
        switch (com_int) {
        case 0:
            _com = "gu";
            break;
        case 1:
            _com = "choki";
            break;
        case 2:
            _com = "pa";
            break;
        default:
            _com = "tehe :P";
        }
        return _com;
    }

    /**
     * 判定処理
     * @param:
     *   String user -- "gu" or "choki" or "pa"
     *   String com  -- "gu" or "choki" or "pa"
     * @return
     *   String -- "user" or "com" or "draw"
     *   もし "tehe :P" が返ってきたら大事。あり得ないことが起こった。
     */
    private String hantei (String user, String com) {
        switch (com) {
        case "gu":
            if (user.equals("gu")) return "draw";
            if (user.equals("choki")) return "com";
            if (user.equals("pa")) return "user";
            break;
        case "choki":
            if (user.equals("gu")) return "user";
            if (user.equals("choki")) return "draw";
            if (user.equals("pa")) return "com";
            break;
        case "pa":
            if (user.equals("gu")) return "com";
            if (user.equals("choki")) return "user";
            if (user.equals("pa")) return "draw";
            break;
        default:
            return "tehe :P";
        }
        return "tehe :P";
    }
}

// 修正時刻: Mon Aug 17 12:42:10 2020

