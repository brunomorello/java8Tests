package br.com.bmo.java8tips.interviews;

import java.util.Base64;

public class RevolutEvent {

    public static void main(String[] args) {
        var values = new String[]{
                "TmV2ZXIgU2V0dGxl",
                "RHJlYW0gVGVhbQ==",
                "VGhpbmsgRGVlcGVy",
                "R2V0IEl0IERvbmU=",
                "RGVsaXZlciBXT1c="
        };

        for (var i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                System.out.printf("\"%s\" ", new String(Base64.getDecoder().decode(values[i].getBytes())));
            }
        }
    }
}