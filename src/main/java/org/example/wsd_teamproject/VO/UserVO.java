package org.example.wsd_teamproject.VO;

import java.security.Timestamp;

public class UserVO {
    public int getUserInventoryId() {
        return userInventoryId;
    }

    public void setUserInventoryId(int userInventoryId) {
        this.userInventoryId = userInventoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    private int userInventoryId; // user_inventory_id
    private int userId;          // user_id
    private int inventoryId;     // inventory_id
    private int quantity;        // quantity
    private Timestamp addedAt;   // added_at
}
