import java.util.*;


public class Sapi {

    public boolean mati;
    public String jenisKelamin;
    public int umur;
    public boolean subur;
    public int jeniskel;

    /**
     * constructor yang membuat data ketika dipanggil
     *
     * @param jenisKelamin
     */
    public Sapi(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
        this.umur = 0;
        this.subur = false;
        this.mati = false; // false berarti masih hidup

    }

    /**
     * membuat Objek sapi baru jika melahirkan anak atau saat diinisiasi awal
     *
     * @param jenisKelamin
     * @param nambah
     * @return
     */
    public static ArrayList<Sapi> kandang(String jenisKelamin, int nambah) {
        ArrayList<Sapi> kandang = new ArrayList<>();
        for (int i = 0; i < nambah; i++) {
            Sapi anak = new Sapi(jenisKelamin);
            kandang.add(anak);
        }
        return kandang;
    }

    /**
     * Mengembalikan keadaan cuaca dengan library  random yang dibatas dari 0 - 9
     *
     * @return
     */
    public static boolean cuaca() {
        Random acak = new Random();
        int hasil = acak.nextInt(10);
        int buruk = 3; // 30 persen kemungkinan terjadi cuaca buruk pada tiap tahun
        boolean cuacaBuruk;
        cuacaBuruk = hasil < buruk;
        // false = cuaca tidak buruk
        return cuacaBuruk;
    }

    /*
     * Jika terjadi cuaca buruk, probabilitas kematian akan naik 10%
     */
    public static int getProbmati(Sapi sapi, boolean cuaca) {
        int probmati;
        if (cuaca == false) {
            switch (sapi.umur) {
                case 0:
                    probmati = 0;
                    break;
                case 1:
                    probmati = 1;
                    break;
                case 2:
                    probmati = 1;
                    break;
                case 3:
                    probmati = 2;
                    break;
                case 4:
                    probmati = 2;
                    break;
                case 5:
                    probmati = 3;
                    break;
                case 6:
                    probmati = 3;
                    break;
                case 7:
                    probmati = 4;
                    break;
                case 8:
                    probmati = 5;
                    break;
                default:
                    probmati = 10;
                    break;
            }
        } else {
            switch (sapi.umur) {
                case 0:
                    probmati = 1;
                    break;
                case 1:
                    probmati = 2;
                    break;
                case 2:
                    probmati = 2;
                    break;
                case 3:
                    probmati = 3;
                    break;
                case 4:
                    probmati = 3;
                    break;
                case 5:
                    probmati = 4;
                    break;
                case 6:
                    probmati = 4;
                    break;
                case 7:
                    probmati = 5;
                    break;
                case 8:
                    probmati = 6;
                    break;
                default:
                    probmati = 10;
                    break;
            }
        }
        return probmati;
    }

    public boolean setMati(int prob) {
        Random acak = new Random();
        if (prob == 10)
            this.mati = true; // di set menjadi hidup
        else if (prob == 0)
            this.mati = false; // hidup
        else {
            int hasil = acak.nextInt(10); // 0 - 9
            this.mati = hasil < prob;
            // misal
            // 5 < 3 => menghasilkan false
            // false = tidak mati
        }
        return this.mati;
    }

    public boolean masaSubur(Sapi sapi) {
        if (sapi.jenisKelamin.equals("betina")) {
            if (sapi.umur >= 3 && sapi.umur <= 7) {
                this.subur = true;
            } else
                this.subur = false;
        }

        return this.subur;
    }

    public int melahirkan(Sapi sapi) {
        if (sapi.mati == false) {
            if (sapi.masaSubur(sapi)) {
                if (sapi.jenisKelamin.equals("betina")) {
                    Random acak = new Random();
                    sapi.jeniskel = acak.nextInt(101); // mengacak bilangan bulat dari 0 - 100
                    return sapi.jeniskel;
                } else
                    return sapi.jeniskel = 101;
            } else
                return sapi.jeniskel = 101;
        } else
            return sapi.jeniskel = 101;
    }

    public void nambahUmur(Sapi sapi) {
        sapi.umur++;
    }

}