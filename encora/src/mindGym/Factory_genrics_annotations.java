//package mindGym;
//
//import java.io.Serializable;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.reflect.Field;
//import java.util.Objects;
//
//// ====== ANNOTATIONS ======
//@Retention(RetentionPolicy.RUNTIME)
//@interface Components {
//    String value();
//}
//
//@Retention(RetentionPolicy.RUNTIME)
//@interface Ins {}
//
//// ====== CONTAINER WITH GENERICS ======
//class Containers {
//    private Containers() {}
//
//    public static <P, C, F extends Manufacturers<P>, S extends Sellers<P, C>> 
//           S getShop(Class<F> factoryType, Class<S> shopType) throws Exception {
//
//        // Read factory annotation
//        Component com = factoryType.getAnnotation(Component.class);
//        String factoryName = (com != null) ? com.value() : null;
//
//        // Read shop annotation
//        com = shopType.getAnnotation(Component.class);
//        String shopName = (com != null) ? com.value() : null;
//
//        // Create factory instance
//        F factory = factoryType.cast(Class.forName(factoryName)
//                .getConstructor().newInstance());
//
//        // Create shop instance
//        S shop = shopType.cast(Class.forName(shopName)
//                .getConstructor().newInstance());
//
//        // Dependency injection
//        Field f = shop.getClass().getSuperclass().getDeclaredField("factory");
//        f.setAccessible(true);
//        if (f.getAnnotation(In.class) != null) {
//            f.set(shop, factory);
//        }
//
//        return shop;
//    }
//}
//
//// ====== MAIN ======
//public class Factory_genrics_annotations {
//    public static void main(String[] args) throws Exception {
//        ShoeShops<Shoe, Customer> shop = Containers.getShop(
//                ShoesFactory.class, ShoeShop.class);
//
//        Customer customer = new Customer();
//        customer.setName("ramu kaka");
//
//        Shoe shoe = shop.sellShoe(customer);
//        System.out.println("Shoe....:" + shoe);
//    }
//}
//
//// ====== GENERIC INTERFACES ======
//interface Manufacturers<P> {
//    P makeProduct();
//}
//
//interface Sellers<P, C> {
//    P sellShoe(C customer);
//}
//
//// ====== SPECIALIZED INTERFACES ======
//interface ShoeManufacturers extends Manufacturers<Shoe> {
//    @Override
//    Shoe makeProduct();
//}
//
//interface ShoeSellers extends Sellers<Shoe, Customer> {
//    @Override
//    Shoe sellShoe(Customer customer);
//}
//
//// ====== MODEL CLASSES ======
//class Customer implements Comparable<Customer>, Serializable {
//    String name;
//
//    @Override
//    public int compareTo(Customer o) {
//        return this.name.compareTo(o.name);
//    }
//
//    public Customer() {}
//    public Customer(String name) { this.name = name; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    @Override
//    public String toString() { return "Customer [name=" + name + "]"; }
//    @Override
//    public int hashCode() { return Objects.hash(name); }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Customer other = (Customer) obj;
//        return Objects.equals(name, other.name);
//    }
//}
//
//// ====== FACTORIES ======
//@Component(value = "mindGym.LakhaniShoeFactory")
//abstract class ShoesFactory implements ShoeManufacturer {
//    @Override
//    public abstract Shoe makeProduct();
//}
//
//class BataShoesFactory extends ShoesFactory {
//    @Override
//    public Shoe makeProduct() {
//        return LeatherShoe.newMultiInstance();
//    }
//}
//
//class LakhaniShoesFactory extends ShoesFactory {
//    @Override
//    public Shoe makeProduct() {
//        return SportsShoe.newMultiInstance();
//    }
//}
//
//// ====== SHOPS ======
//@Component(value = "mindGym.BabuShoeShop")
//abstract class ShoeShops<P extends Shoe, C extends Customer> implements ShoeSeller {
//    @In
//    protected ShoesFactory factory;
//
//    public ShoeShops() {}
//    public ShoeShops(ShoesFactory factory) { this.factory = factory; }
//
//    public ShoesFactory getFactory() { return factory; }
//    public void setFactory(ShoesFactory factory) { this.factory = factory; }
//}
//
//class BabuShoeShops extends ShoeShops<Shoe, Customer> {
//    @Override
//    public Shoe sellShoe(Customer customer) {
//        return getFactory().makeProduct();
//    }
//}
//
//// ====== PRODUCTS ======
//abstract class Shoes {}
//
//class LeatherShoes extends Shoes implements Cloneable {
//    private LeatherShoes() { System.out.println("LeatherShoe object created..."); }
//    private static LeatherShoes leatherShoe;
//
//    public LeatherShoes getClone() throws Exception {
//        return (LeatherShoes) super.clone();
//    }
//
//    public static synchronized LeatherShoes newSingleInstance() {
//        if (leatherShoe == null) {
//            leatherShoe = new LeatherShoes();
//        }
//        return leatherShoe;
//    }
//
//    public static synchronized LeatherShoes newMultiInstance() {
//        return new LeatherShoes();
//    }
//}
//
//class SportsShoes extends Shoes implements Cloneable {
//    private SportsShoes() { System.out.println("SportsShoe object created..."); }
//    private static SportsShoes sportsShoe;
//
//    public SportsShoes getClone() throws Exception {
//        return (SportsShoes) super.clone();
//    }
//
//    public static synchronized SportsShoes newSingleInstance() {
//        if (sportsShoe == null) {
//            sportsShoe = new SportsShoes();
//        }
//        return sportsShoe;
//    }
//
//    public static synchronized SportsShoes newMultiInstance() {
//        return new SportsShoes();
//    }
//}
