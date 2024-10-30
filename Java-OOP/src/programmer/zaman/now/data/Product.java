package programmer.zaman.now.data;

import java.util.Objects;

public  class Product {
    protected String name;
    protected int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Product product = (Product) object;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + price;
        return result;
    }

    /*

    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }

        if(!(object instanceof Product)) {
            return false;
        }

        Product product = (Product) object;

        if(this.price != product.price) {
            return false;
        }

        if(this.name == null) {
            return this.name.equals(product.name);
        } else {
            return product.name == null;
        }
    }

     */
}
