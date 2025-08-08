package com.example.demo.service;
import java.util.List;
import com.example.demo.model.Item;

public interface ItemService {
    public List<Item> gets();
    
    public Item get(Item item);
    
    public void delete(Item item);
    
    public void save(Item item);
    
    public void update(Item item);
    
    public void facturar();
    
    public double getTotal();
}
