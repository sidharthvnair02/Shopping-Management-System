// Java code for Shopping System Management
import java.util.*;

public class Customer {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num;

        do{
            System.out.println("Enter a valid choice:");
            System.out.println("1.Register");
            System.out.println("2.Shopping");
            System.out.println("3.Shipping details");
            System.out.println("4.Exit");
            num= scanner.nextInt();
            switch(num)
            {
                case 1:
                    register reg = new register();
                    int id = reg.Register();
                    System.out.println(id);

                    break;
                case 2:
                    Shoppingcart bk = new Shoppingcart();
                    System.out.println("Shopping");
                    Scanner scc=new Scanner(System.in);
                    int num2;
                {
                    do{
                        System.out.println("Enter a valid choice:");
                        System.out.println("1.View cart");
                        System.out.println("2.Add to Cart");
                        System.out.println("3.Delete from cart");
                        System.out.println("4.Exit");
                        num2= scc.nextInt();
                        switch(num2)
                        {
                            case 1:
                                System.out.println("Items");
                                bk.display(1);

                                break;
                            case 2:
                                System.out.println("Prodcuts:-");
                                System.out.println();
                                bk.viewitem();
                                bk.addCartitem();

                                break;
                            case 3:
                                System.out.println("Enter orderid to be deleted ");
                                int d= scc.nextInt();
                                bk.deleteitem(d);
                                break;
                            case 4:
                                System.out.println("Thank You");
                                break;

                        }
                    }while(num2!=4);

                }
                break;
                case 3:
                    ShippingDetail SD=new ShippingDetail();
                    SD.ShippingDetails();

                    break;
                case 4:
                    System.out.println("Thank You");
                    break;

            }
        }
        while(num!=4);

    }
}

class register{
    public static int i = 1, j = 0, s = 10;
    public static database[] customer = new database[s];
    {
        customer[0] = new database(14, 45, "User1", "2541541542", "user1@gmail.com", "mumbai");

    }

    int Register() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        while (true) {
            int count = 0;
            for (int y = 0; y < i; y++) {
                if (id == customer[y].id) {
                    count++;
                }
            }
            if (count == 0)
                break;
            else {
                System.out.println("Id already taken");
                System.out.println("Enter id: ");
                id = sc.nextInt();
            }

        }
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter credit card info: ");
        String creditcartinfo = sc.nextLine();
        System.out.println("Enter Address: ");
        String address = sc.nextLine();
        System.out.println("Enter Email: ");
        String mail = sc.next();
        customer[i] = new database(id, age, name, creditcartinfo, mail, address);
        i++;
        System.out.println("The User has been successfully added");
        return id;
    }
}
class database {
    int id;
    public String name;
    private int age;
    private String address;
    private String email;
    protected String credit_card_info;

    public database(int id, int age, String name, String creditcardinfo, String mail, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address =address;
        this.email = mail;
        this.credit_card_info = creditcardinfo;
    }

    public int pr_no;
    public String pr_name;
    public int cost;

    public database(int pr_no, String pr_name, int cost) {
        this.pr_name = pr_name;
        this.pr_no = pr_no;
        this.cost = cost;
    }

    public int orderID;
    public int finalcost;
    public int quantity;
    public database(int orderID, int finalcost, int quantity) {
        this.orderID = orderID;
        this.finalcost = finalcost;
        this.quantity = quantity;
    }

}

class Shoppingcart
{

    Scanner sc = new Scanner(System.in);
    public static int k = 3, pr_limit = 10, j = 0;
    public static database[] products = new database[pr_limit];
    {
        products[0] = new database(1425, "Phone", 10000);
        products[1] = new database(5541, "Keyboard",500);
        products[2] = new database(1125, "Mouse", 400);
    }

    register reg = new register();
    Scanner sccc = new Scanner(System.in);
    int orderID = 100;
    int orderNo = 1;
    int count;

    database[] order = new database[10];

    void addCartitem() {
        int plaInd;
        int quantity;
        boolean check = false;
        System.out.print("Enter the  product no :");
        int no = sccc.nextInt();

        for (int i = 0; i < 3; i++) {
            if (no == products[i].pr_no) {
                check = true;
                plaInd = i;
                System.out.println("Enter quantity to be booked:");
                quantity = sccc.nextInt();
                if (products[plaInd].cost >= quantity) {
                    //products[i].cost = quantity;
                    int finalcost = products[i].cost * quantity;
                    order[orderNo] = new database(orderID, finalcost, quantity);
                    System.out.println("\nYour order No: " + orderNo);
                    System.out.println("Your order is Booked");
                    System.out.println("product:"+products[plaInd].pr_name);
                    System.out.println("quantity:"+quantity);
                    System.out.println("Amount:"+finalcost);
                    System.out.println("your order id is "+orderID);
                    orderID++;

                }
            }
        }
        if (!check) {
            System.out.println("Incorrect product No.");
            return;
        }
    }

    void deleteitem(int orderID) {
        boolean t = true;
        for (int i = 1; i < orderNo; i++) {
            if (orderID == order[i].orderID) {
                for (int j = i; j < orderNo - 1; j++) {
                    order[j] = order[j + 1];
                }
                orderNo--;
                t = true;
            }
        }
        if (!t) {
            System.out.println("Incorrect PRODUCT ID");
        }
        System.out.println("Your item has been deleted from the cart");
    }
    void viewitem(){
        for (int j = 0; j < 3; j++) {

            System.out.println("product Name: " + products[j].pr_name + "\tproduct No: " + products[j].pr_no);

        }
    }
    void display(int orderNo) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("\norder No: " + orderNo + "\t\t\torder ID: " + order[orderNo].orderID);

        System.out.println("quantity: " + order[orderNo].quantity + "\t\nAmount:"+ order[orderNo].finalcost);

        System.out.println("-------------------------------------------------------------------------------------");
    }

}

class ShippingDetail extends register {

    private int Shippingid;
    private String ShippingType;
    private int ShippingCost;


    public void ShippingDetails(){
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println(Shippingid);

        System.out.println(" Enter 1 for COD and 2 for online payment ");
        choice=sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Your shipping type is Cash on delivery");
                break;
            case 2:
                System.out.println("your shipping type is Online");
                break;
            default:
                System.out.println("Enter valid choice:");
        }
        System.out.println("customer name: "+ customer[1].name);
        System.out.println(" Shipping cost: 50");

    }
}
