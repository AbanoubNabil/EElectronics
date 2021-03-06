package com.mycompany.eelectronics_iti;
// Generated Feb 26, 2018 3:42:38 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Orders generated by hbm2java
 */
public class Orders  implements java.io.Serializable {


     private Integer orederId;
     private Users users;
     private String orderDate;
     private int orderAmount;
     private double orderPrice;
     private Set productses = new HashSet(0);

    public Orders() {
    }

	
    public Orders(Users users, String orderDate, int orderAmount, double orderPrice) {
        this.users = users;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderPrice = orderPrice;
    }
    public Orders(Users users, String orderDate, int orderAmount, int orderPrice, Set productses) {
       this.users = users;
       this.orderDate = orderDate;
       this.orderAmount = orderAmount;
       this.orderPrice = orderPrice;
       this.productses = productses;
    }
   
    public Integer getOrederId() {
        return this.orederId;
    }
    
    public void setOrederId(Integer orederId) {
        this.orederId = orederId;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public int getOrderAmount() {
        return this.orderAmount;
    }
    
    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
    public double getOrderPrice() {
        return this.orderPrice;
    }
    
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
    public Set getProductses() {
        return this.productses;
    }
    
    public void setProductses(Set productses) {
        this.productses = productses;
    }




}


