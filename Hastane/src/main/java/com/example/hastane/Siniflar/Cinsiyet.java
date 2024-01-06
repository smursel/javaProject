package com.example.hastane.Siniflar;

public enum Cinsiyet {
        ERKEK(0),
        KADIN(1);

        private final int deger;

        Cinsiyet(int deger) {
            this.deger = deger;
        }

        public int getDeger() {
            return deger;
        }
}
