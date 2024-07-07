package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    // 課題は正規表現をたくさん使う。
    // Listにランダムな文字列（いろいろ自分で入れてもいいし、ChatGPTとかにお願いしてもいい）を30個ほど入れる。
    Map<Integer, String> randomMap = new HashMap<>();
    randomMap.put(1, "あ2い3");
    randomMap.put(2, "ひらがなdef");
    randomMap.put(3, "234567");
    randomMap.put(4, "445566");
    randomMap.put(5, "ひ4ら5が6");
    randomMap.put(6, "890123");
    randomMap.put(7, "Ab1c2D3");
    randomMap.put(8, "67890");
    randomMap.put(9, "カタカナABC");
    randomMap.put(10, "FTNHSTHJ");
    randomMap.put(11, "Abc漢字");
    randomMap.put(12, "1漢2字3カ4");
    randomMap.put(13, "あいうえお");
    randomMap.put(14, "あ1い2漢3");
    randomMap.put(15, "12345");
    randomMap.put(16, "あいうえ漢");
    randomMap.put(17, "1ABC2漢3");
    randomMap.put(18, "112233");
    randomMap.put(19, "123Abc漢");
    randomMap.put(20, "567890");
    randomMap.put(21, "901234");
    randomMap.put(22, "漢字ひらカナ");
    randomMap.put(23, "漢1A2B3C");
    randomMap.put(24, "AbcDEF");
    randomMap.put(25, "カ7タ8カ9");
    randomMap.put(26, "789012");
    randomMap.put(27, "1あ2い3");
    randomMap.put(28, "OPEINVJU");
    randomMap.put(29, "漢字123漢");
    randomMap.put(30, "ATHEHEDH");

    // その文字列のリストに対して「数字だけを抜き出す正規表現」と「文字だけを抜き出す正規表現」を試す。
    // 実際にあっているか確認。
    List<String> randomList = randomMap.values().stream()
        .filter(random -> random.matches("\\d+"))
        .collect(Collectors.toList());
    System.out.println(randomList);

    randomList = randomMap.values().stream()
        .filter(random -> random.matches("[ぁ-んァ-ヶ一-龥a-zA-Z]+"))
        .collect(Collectors.toList());
    System.out.println(randomList);

    // 文字を抜き出すときに英数字の大文字だけ抜き出す。
    randomList = randomMap.values().stream()
        .filter(random -> random.matches("[A-Z]+"))
        .collect(Collectors.toList());
    System.out.println(randomList);

    // 漢字とひらがな、カタカナなどの日本語にマッチする正規表現を書いて抜き出す。
    randomList = randomMap.values().stream()
        .filter(random -> random.matches("[一-龥ぁ-んァ-ヶー]+"))
        .collect(Collectors.toList());
    System.out.println(randomList);

    // 英数字以外の文字を抜き出すという正規表現にチャレンジ。
    randomList = randomMap.values().stream()
        .filter(random -> random.matches("[^a-zA-Z0-9]+"))
        .collect(Collectors.toList());
    System.out.println(randomList);


  }
}