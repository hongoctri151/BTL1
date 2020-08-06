package Model;

public class Order {
    private String ProductId;
    private String ProductName;
    private String Quantity;
    private String Comment;
    private String Price;

    public Order(){};
    public Order(String productId, String productName, String quantity, String price, String comment) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
        Comment = comment;
        Price = price;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductID(String productID) {
        ProductId = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
