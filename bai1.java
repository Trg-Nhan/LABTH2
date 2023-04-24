import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Account{
    private long stk;
    private String tentk;
    private double tien;
    private String trangthai;

    public Account(){
        this.stk=999999;
        this.tentk="Chua xac dinh";
        this.tien=50;
    }

    public Account(long stk, String tentk, 
    Double tien, String trangthai){
        this.stk=stk;
        this.tentk=tentk;
        this.tien=tien;
        this.trangthai=trangthai;
    }
    public long getSTK(){
       return stk;
    }
    public void setSTK(long stk){
        if(this.stk<0 && this.stk==999999){
           System.out.println("So tai khoan khong hop le");
           this.stk=999999;
           System.out.println(this.stk);
        }else{
            this.stk=stk;
        }
    }
    
    public String getTenTK(){
        return tentk;
    }
    public void setTenTK(String tentk){
        if(this.tentk!=null){
            this.tentk="Chua xac dinh";
            System.out.println(this.tentk);
        } else {
            this.tentk=tentk;
        }
    }
    public double getTien(){
        return tien;
    }
    public void setTien(double tien){
        if(this.tien<50){
            System.out.println("So tien khong hop le");
        }
    }
    public String getTrangThai(){
        return trangthai;
    }
    public void setTrangThai(String trangthai){
        this.trangthai=trangthai;
    }
    @Override
    public String toString(){
        Locale locale = new  Locale("vi","vn");   
        NumberFormat currencyformatter = NumberFormat.getCurrencyInstance(locale);
        String stttk=currencyformatter.format(tien);
        return "Account [\nSo tai khoan: "+ stk +
        "\nTen tai khoan: " + tentk + 
        "\nTien co trong tai khoan: " +stttk+"]";
    }
    public double napTien() {
        double nap;
        System.out.print("Nhap so tien can nap: ");
        Scanner sc=new Scanner(System.in);
        nap = sc.nextDouble();
        if (nap >= 0) {
            tien = nap + tien;
            NumberFormat currencyformatter = NumberFormat.getCurrencyInstance();
            String stttk = currencyformatter.format(nap);
            System.out.println("Vua nop: " + stttk + " vao tai khoan.");
        } else {
            System.out.println("So tien khong hop le!");
        }
        return nap;
    }
 
    public double rutTien() {
        double rut;
        System.out.print("Nhap so tien can rut: ");
        Scanner sc=new Scanner(System.in);
        rut = sc.nextDouble();
        if (rut <= tien) {
            tien = tien - rut;
            NumberFormat currencyformatter = NumberFormat.getCurrencyInstance();
            String stttk = currencyformatter.format(rut);
            System.out.println("Vua rut" + stttk + "tu tai khoan.");
        } else {
            System.out.println("So tien rut khong hop le!");
            return rutTien();
        }
        return rut;
    }
    
    public double daoHan() {
        double laiSuat = 0.035;
        tien = tien + tien * laiSuat;
        NumberFormat currencyformatter = NumberFormat.getCurrencyInstance();
        String stttk = currencyformatter.format(tien);
        System.out.println("Da duoc dao han: "+stttk);
        return tien;
    }
}

class AccountList {
    private ArrayList<Account> ac;
    private int count;
    
    public AccountList(){
        int count[]= new int[10];
        for (int i = 0; i < count.length; i++){
            System.out.println(count[i]);
        }
    }

    public AccountList(int n){
        if(n>0){
        System.out.println(n);
    }else{
        int count[]= new int[10];
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
            }
        }
    }
    public void themTK(Account account){
        this.ac.add(account);
    }
    public void timSTK(long stk){
        for (Account account : ac) {
            } 
        }
    public void xoaTK(long stk){
        this.ac.clear();
    }
    public int soluongtaikhoan(){
        return this.ac.size();
    }  
    public void indanhsachTK(){
        for (Account account : ac) {
            System.out.println(account);
        }
}
}
public class bai1{
    public static void main(String[] args) {
        AccountList al= new AccountList();
        Scanner sc= new Scanner(System.in);
        Account a[] = null;
        int n = 0;
        long taikhoancanchuyen, taikhoan, nhantien, f;
        do{
            System.out.println("______MENU______");
            System.out.println("1.Them tai khoan." +
            "\n2.In thong tin tat ca TK."+
            "\n3. Nap tien vao tai khoan."+
            "\n4.Rut tien."+
            "\n5.Dao han."+
            "\n6. Chuyen tien."+
            "\n0.Ket thuc");
            System.out.println("Hay nhap lua chon!");
            n=sc.nextInt();
            sc.nextLine();
            if(n==1){
                System.out.println("Nhap so tai khoan: ");
                long stk= sc.nextLong();
                System.out.println("Nhap ten tai khoan: ");
                String tentk=sc.nextLine();
                System.out.println("Nhap so tien: ");
                double tien=sc.nextDouble();
                
                Account ac = new Account(stk, tentk, null, tentk);

                al.themTK(ac);
                
                System.out.println("Them tai khoan moi thanh cong!");
                System.out.println("Thong tin tai khoan: \n" + 
                "   So tai khoan: " + stk +
                "   Ten tai khoan: "+ tentk +
                "   So tien: "+ tien);
            }else if(n==2){
                al.indanhsachTK();
            }else if(n==3){
                System.out.println("Nha so tai khoan can nap tien: ");
                taikhoancanchuyen = sc.nextLong();
                for (int i = 0; i < n; i++) {
                    taikhoan = a[i].getSTK();
                    if (taikhoancanchuyen == taikhoan) {
                        System.out.println("Chon tai khoan: " + taikhoan);
                        a[i].napTien();
                    } else {
                        System.out.println("");
                    }
                }
            }else if(n==4){
                System.out.println("Nhap so tai khoan can rut tien: ");
                taikhoancanchuyen = sc.nextLong();
                for (int i = 0; i < n; i++) {
                    taikhoan = a[i].getSTK();
                    if (taikhoancanchuyen == taikhoan) {
                        System.out.println("Chon tai khoan: " + taikhoan);
                        a[i].rutTien();
                    }
                }
            }else if(n==5){
                System.out.println("Nhap so tai khoan can dao han: ");
                taikhoancanchuyen = sc.nextLong();
                for (int i = 0; i < n; i++) {
                    taikhoan = a[i].getSTK();
                    if (taikhoancanchuyen == taikhoan) {
                        System.out.println("Chon tai khoan: " + taikhoan);
                        a[i].daoHan();
                    } else {
                        System.out.println("");
                    }
                }
            }else if(n==6){
                double chuyen, nhan, tienChuyen;
                    System.out.print("Nhap so tai khoan can chuyen: ");
                    taikhoancanchuyen = sc.nextLong();
                    System.out.print("Nhap tai khoan nhan tien: ");
                    nhantien = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        taikhoan = a[i].getSTK();
                        if (taikhoancanchuyen == taikhoan) {
                            chuyen = a[i].getTien();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getSTK();
                                if (nhantien == f) {
                                    nhan = a[j].getTien();
                                    System.out.println("Nhap so tien can chuyen: ");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setTien(tienChuyen);
                                        a[j].setTien(nhan);
                                        System.out.println("Tai khoan " + taikhoan + " da chuyen" + tienChuyen);
                                        System.out.println(" Tai khoan" + f + " da nhan" + tienChuyen);
                                    } else {
                                        System.out.println("So tien nhan khong hop le!");
                                    }
                                }
                            }
                        }
                    }
                }
        }while(n!=0);
    }
}
    
